import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class App extends JFrame {

    Usuario usuario = Banco.carregar();

    public App() {

        if (usuario == null) usuario = new Usuario();

        if (usuario.nome == null) {
            setTitle("Sistema de Séries");
        } else {
            setTitle("Sistema de Séries - " + usuario.nome);
        }

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        JButton bNome = new JButton("Definir nome");
        JButton bBuscar = new JButton("Buscar séries");
        JButton bFav = new JButton("Favoritos");
        JButton bAss = new JButton("Assistidos");
        JButton bQuero = new JButton("Quero ver");
        JButton bSalvar = new JButton("Salvar");

        bNome.addActionListener(e -> Nome());
        bBuscar.addActionListener(e -> janelaBusca());
        bFav.addActionListener(e -> janelaLista(usuario.favoritos, "Favoritos"));
        bAss.addActionListener(e -> janelaLista(usuario.assistidos, "Assistidos"));
        bQuero.addActionListener(e -> janelaLista(usuario.queroVer, "Quero ver"));
        bSalvar.addActionListener(e -> Banco.salvar(usuario));

        add(bNome);
        add(bBuscar);
        add(bFav);
        add(bAss);
        add(bQuero);
        add(bSalvar);

        setVisible(true);
    }

    private void Nome() {
        String nomeNovo = JOptionPane.showInputDialog("Digite seu nome:");

        if (nomeNovo != null && !nomeNovo.isBlank()) {
            usuario.nome = nomeNovo.trim();
            Banco.salvar(usuario);

            setTitle("Sistema de Séries - " + usuario.nome);

            JOptionPane.showMessageDialog(null, "Nome salvo com sucesso!");
        }
    }

    private void janelaBusca() {

        JFrame f = new JFrame("Buscar Séries");
        f.setSize(500, 400);
        f.setLayout(new BorderLayout());

        JTextField txt = new JTextField();

        if (usuario.nome != null)
            txt.setText(usuario.nome);

        JButton b = new JButton("Buscar");

        DefaultListModel<Serie> model = new DefaultListModel<>();
        JList<Serie> lista = new JList<>(model);

        lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (lista.getSelectedValue() != null) {
                    mostrarDetalhes(lista.getSelectedValue());
                }
            }
        });

        b.addActionListener(e -> {
            model.clear();
            if (txt.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Digite algo para buscar.");
                return;
            }

            List<Serie> resultado = Api.buscar(txt.getText());

            if (resultado == null || resultado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma série encontrada.");
                return;
            }

            for (Serie s : resultado) model.addElement(s);
        });

        f.add(txt, BorderLayout.NORTH);
        f.add(b, BorderLayout.SOUTH);
        f.add(new JScrollPane(lista), BorderLayout.CENTER);
        f.setVisible(true);
    }

    private void mostrarDetalhes(Serie s) {

        String info =
                "Nome: " + s.nome +
                        "\nIdioma: " + s.idioma +
                        "\nGêneros: " + s.generos +
                        "\nNota: " + s.nota +
                        "\nEstado: " + s.estado +
                        "\nEstreia: " + s.estreia +
                        "\nFim: " + s.fim +
                        "\nEmissora: " + s.emissora;

        Object[] op = {"Favoritos", "Assistidos", "Quero ver", "Fechar"};

        int es = JOptionPane.showOptionDialog(null, info, "Detalhes",
                0, 0, null, op, op[3]);

        if (es == 0) usuario.favoritos.add(s);
        else if (es == 1) usuario.assistidos.add(s);
        else if (es == 2) usuario.queroVer.add(s);

        Banco.salvar(usuario);
    }

    private void janelaLista(List<Serie> lista, String nome) {

        JFrame f = new JFrame(nome);
        f.setSize(800, 400);

        DefaultListModel<Serie> model = new DefaultListModel<>();
        for (Serie s : lista) model.addElement(s);

        JList<Serie> l = new JList<>(model);

        l.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (l.getSelectedValue() != null) {
                    mostrarDetalhes(l.getSelectedValue());
                }
            }
        });

        String[] opcoesOrdenar = {
                "Ordenar por nome",
                "Ordenar por nota",
                "Ordenar por estado",
                "Ordenar por data de estreia"
        };

        JComboBox<String> boxOrdenar = new JComboBox<>(opcoesOrdenar);
        JButton btnOrdenar = new JButton("Ordenar");

        btnOrdenar.addActionListener(e -> {

            for (Serie s : lista) {
                if (s.nome == null) s.nome = "";
                if (s.estado == null) s.estado = "";
                if (s.estreia == null || s.estreia.equals("-")) s.estreia = "0000-00-00";
                if (s.nota == null) s.nota = 0.0;
            }

            String op = (String) boxOrdenar.getSelectedItem();

            if (op.equals("Ordenar por nome")) {
                lista.sort((a, b) -> a.nome.compareToIgnoreCase(b.nome));

            } else if (op.equals("Ordenar por nota")) {
                lista.sort((a, b) -> Double.compare(b.nota, a.nota));

            } else if (op.equals("Ordenar por estado")) {
                lista.sort((a, b) -> a.estado.compareToIgnoreCase(b.estado));

            } else if (op.equals("Ordenar por data de estreia")) {
                lista.sort((a, b) -> a.estreia.compareToIgnoreCase(b.estreia));
            }

            model.clear();
            for (Serie s : lista) model.addElement(s);

            l.updateUI();
            Banco.salvar(usuario);
        });

        JButton Remover = new JButton("Remover selecionado");
        Remover.addActionListener(e -> {
            Serie s = l.getSelectedValue();
            if (s == null) {
                JOptionPane.showMessageDialog(null, "Selecione uma série primeiro.");
                return;
            }
            model.removeElement(s);
            lista.remove(s);
            Banco.salvar(usuario);
        });

        JPanel painelBaixo = new JPanel();
        painelBaixo.add(Remover);
        painelBaixo.add(boxOrdenar);
        painelBaixo.add(btnOrdenar);

        f.add(new JScrollPane(l), BorderLayout.CENTER);
        f.add(painelBaixo, BorderLayout.SOUTH);

        f.setVisible(true);
    }
}
