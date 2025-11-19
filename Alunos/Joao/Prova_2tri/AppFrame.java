import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class AppFrame extends JFrame {

    private ShowManager manager;
    private final ShowService service = new ShowService();

    private final DefaultListModel<Show> favModel = new DefaultListModel<>();
    private final DefaultListModel<Show> seenModel = new DefaultListModel<>();
    private final DefaultListModel<Show> wantModel = new DefaultListModel<>();

    public AppFrame() {
        setTitle("Séries - App");
        setSize(720, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        JTextField userField = new JTextField(22);
        JButton loadBtn = new JButton("Login / Carregar");
        top.add(new JLabel("Nome:"));
        top.add(userField);
        top.add(loadBtn);
        add(top, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        add(tabs, BorderLayout.CENTER);

        JPanel searchPanel = new JPanel(new BorderLayout(6,6));
        JPanel searchTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField searchField = new JTextField(30);
        JButton searchBtn = new JButton("Buscar");
        searchTop.add(new JLabel("Buscar por nome:"));
        searchTop.add(searchField);
        searchTop.add(searchBtn);
        searchPanel.add(searchTop, BorderLayout.NORTH);

        DefaultListModel<Show> searchModel = new DefaultListModel<>();
        JList<Show> searchList = new JList<>(searchModel);
        searchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchPanel.add(new JScrollPane(searchList), BorderLayout.CENTER);

        JPanel searchBottom = new JPanel();
        JButton detailsBtn = new JButton("Detalhes");
        JButton addFavBtn = new JButton("Adicionar a Favoritos");
        JButton addSeenBtn = new JButton("Marcar como Assistido");
        JButton addWantBtn = new JButton("Adicionar à Quero Assistir");
        searchBottom.add(detailsBtn);
        searchBottom.add(addFavBtn);
        searchBottom.add(addSeenBtn);
        searchBottom.add(addWantBtn);
        searchPanel.add(searchBottom, BorderLayout.SOUTH);

        tabs.addTab("Buscar", searchPanel);

        JPanel favPanel = new JPanel(new BorderLayout());
        JList<Show> favList = new JList<>(favModel);
        favList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        favPanel.add(new JScrollPane(favList), BorderLayout.CENTER);
        JPanel favBottom = new JPanel();
        JButton favDetails = new JButton("Detalhes");
        JButton favRemove = new JButton("Remover");
        JComboBox<String> favSort = new JComboBox<>(new String[]{"Ordenar por","Nome","Nota","Status","Estreia"});
        favBottom.add(favDetails); favBottom.add(favRemove); favBottom.add(favSort);
        favPanel.add(favBottom, BorderLayout.SOUTH);
        tabs.addTab("Favoritos", favPanel);

        JPanel seenPanel = new JPanel(new BorderLayout());
        JList<Show> seenList = new JList<>(seenModel);
        seenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        seenPanel.add(new JScrollPane(seenList), BorderLayout.CENTER);
        JPanel seenBottom = new JPanel();
        JButton seenDetails = new JButton("Detalhes");
        JButton seenRemove = new JButton("Remover");
        JComboBox<String> seenSort = new JComboBox<>(new String[]{"Ordenar por","Nome","Nota","Status","Estreia"});
        seenBottom.add(seenDetails); seenBottom.add(seenRemove); seenBottom.add(seenSort);
        seenPanel.add(seenBottom, BorderLayout.SOUTH);
        tabs.addTab("Assistidos", seenPanel);

        JPanel wantPanel = new JPanel(new BorderLayout());
        JList<Show> wantList = new JList<>(wantModel);
        wantList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wantPanel.add(new JScrollPane(wantList), BorderLayout.CENTER);
        JPanel wantBottom = new JPanel();
        JButton wantDetails = new JButton("Detalhes");
        JButton wantRemove = new JButton("Remover");
        JComboBox<String> wantSort = new JComboBox<>(new String[]{"Ordenar por","Nome","Nota","Status","Estreia"});
        wantBottom.add(wantDetails); wantBottom.add(wantRemove); wantBottom.add(wantSort);
        wantPanel.add(wantBottom, BorderLayout.SOUTH);
        tabs.addTab("Quero Assistir", wantPanel);

        loadBtn.addActionListener(e -> {
            String name = userField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Digite um nome/apelido para carregar/criar o usuário.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            manager = JsonStorage.carregar();

            manager.getUser().setName(name);
            JsonStorage.salvar(manager);
            setTitle("Séries - Usuário: " + name);
            reloadAll();
        });

        searchBtn.addActionListener(e -> {
            String q = searchField.getText().trim();
            searchModel.clear();
            if (q.isEmpty()) { JOptionPane.showMessageDialog(this,
                    "Digite um nome para buscar."); return; }
            try {
                List<Show> found = service.searchShows(q);
                if (found.isEmpty()) JOptionPane.showMessageDialog(this,
                        "Nenhum resultado encontrado.");
                for (Show s : found) searchModel.addElement(s);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao buscar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        detailsBtn.addActionListener(e -> showDetails(searchList.getSelectedValue()));
        favDetails.addActionListener(e -> showDetails(favList.getSelectedValue()));
        seenDetails.addActionListener(e -> showDetails(seenList.getSelectedValue()));
        wantDetails.addActionListener(e -> showDetails(wantList.getSelectedValue()));

        addFavBtn.addActionListener(e -> {
            if (!ensureUser()) return;
            Show s = searchList.getSelectedValue();
            if (s == null) { JOptionPane.showMessageDialog(this,
                    "Selecione uma série nos resultados."); return; }

            manager.addFavorito(s);
            JsonStorage.salvar(manager);
            reloadAll();
            JOptionPane.showMessageDialog(this,
                    "Adicionado aos Favoritos.");
        });
        addSeenBtn.addActionListener(e -> {
            if (!ensureUser()) return;
            Show s = searchList.getSelectedValue();
            if (s == null) { JOptionPane.showMessageDialog(this,
                    "Selecione uma série nos resultados."); return; }

            manager.addAssistido(s);
            JsonStorage.salvar(manager);
            reloadAll();
            JOptionPane.showMessageDialog(this, "Marcado como Assistido.");
        });
        addWantBtn.addActionListener(e -> {
            if (!ensureUser()) return;
            Show s = searchList.getSelectedValue();
            if (s == null) { JOptionPane.showMessageDialog(this,
                    "Selecione uma série nos resultados."); return; }

            manager.addQueroAssistir(s);
            JsonStorage.salvar(manager);
            reloadAll();
            JOptionPane.showMessageDialog(this, "Adicionado à Quero Assistir.");
        });

        favRemove.addActionListener(e -> {
            if (!ensureUser()) return;
            Show s = favList.getSelectedValue();
            if (s == null) { JOptionPane.showMessageDialog(this,
                    "Selecione uma série para remover."); return; }

            int r = JOptionPane.showConfirmDialog(this,
                    "Remover " + s.getName() + " dos Favoritos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                manager.removeFavorito(s);
                JsonStorage.salvar(manager);
                reloadAll();
            }
        });
        seenRemove.addActionListener(e -> {
            if (!ensureUser()) return;
            Show s = seenList.getSelectedValue();
            if (s == null) { JOptionPane.showMessageDialog(this,
                    "Selecione uma série para remover."); return; }

            int r = JOptionPane.showConfirmDialog(this,
                    "Remover " + s.getName() + " dos Assistidos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                manager.removeAssistido(s);
                JsonStorage.salvar(manager);
                reloadAll();
            }
        });
        wantRemove.addActionListener(e -> {
            if (!ensureUser()) return;
            Show s = wantList.getSelectedValue();
            if (s == null) { JOptionPane.showMessageDialog(this,
                    "Selecione uma série para remover."); return; }

            int r = JOptionPane.showConfirmDialog(this,
                    "Remover " + s.getName() + " da Quero Assistir?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                manager.removeQueroAssistir(s);
                JsonStorage.salvar(manager);
                reloadAll();
            }
        });

        favSort.addActionListener(e -> {
            if (!ensureUser()) return;
            String sel = (String) favSort.getSelectedItem();
            sortSelection(sel, manager.getFavoritos());
            reloadAll();
        });
        seenSort.addActionListener(e -> {
            if (!ensureUser()) return;
            String sel = (String) seenSort.getSelectedItem();
            sortSelection(sel, manager.getAssistidos());
            reloadAll();
        });
        wantSort.addActionListener(e -> {
            if (!ensureUser()) return;
            String sel = (String) wantSort.getSelectedItem();
            sortSelection(sel, manager.getQueroAssistir());
            reloadAll();
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (manager != null) JsonStorage.salvar(manager);
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private boolean ensureUser() {
        if (manager == null || manager.getUser() == null || manager.getUser().getName() == null || manager.getUser().getName().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faça login primeiro (campo no topo).", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void reloadAll() {
        favModel.clear();
        seenModel.clear();
        wantModel.clear();

        if (manager == null) return;

        for (Show s : manager.getFavoritos()) favModel.addElement(s);
        for (Show s : manager.getAssistidos()) seenModel.addElement(s);
        for (Show s : manager.getQueroAssistir()) wantModel.addElement(s);
    }

    private void showDetails(Show s) {
        if (s == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma série.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(s.getName()).append("\n\n");
        sb.append("Idioma: ").append(empty(s.getLanguage())).append("\n\n");
        sb.append("Gêneros: ").append((s.getGenres() == null || s.getGenres().isEmpty()) ? "N/A" : String.join(", ", s.getGenres())).append("\n\n");
        sb.append("Nota geral: ").append(s.getRating() == null ? "N/A" : String.format("%.1f", s.getRating())).append("\n\n");
        sb.append("Estado: ").append(empty(s.getStatus())).append("\n\n");
        sb.append("Data de estreia: ").append(empty(s.getPremiered())).append("\n\n");
        sb.append("Data de término: ").append(empty(s.getEnded())).append("\n\n");
        sb.append("Emissora: ").append(empty(s.getNetworkName())).append("\n\n");
        sb.append("ID (API): ").append(s.getId());

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(area);
        sp.setPreferredSize(new Dimension(520, 360));
        JOptionPane.showMessageDialog(this, sp, "Detalhes", JOptionPane.INFORMATION_MESSAGE);
    }

    private String empty(String s) { return (s == null || s.isEmpty()) ? "N/A" : s; }

    private void sortSelection(String sel, List<Show> lista) {
        if (sel == null || lista == null) return;
        switch (sel) {
            case "Nome" -> manager.ordenarPorNome(lista);
            case "Nota" -> manager.ordenarPorNota(lista);
            case "Status" -> manager.ordenarPorStatus(lista);
            case "Estreia" -> manager.ordenarPorDataEstreia(lista);
            default -> {}
        }
    }
}