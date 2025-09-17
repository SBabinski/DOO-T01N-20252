package Alunos.Jose_Euclides.Prova_1trim;

public class Customer {
    private String name;
    private String cpf;
    private String email;
    private String phone;

    public Customer() {
        super();
    }

    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "Nome='" + name + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Email='" + email + '\'' +
                ", Telefone='" + phone + '\'' +
                '}';
    }
}
