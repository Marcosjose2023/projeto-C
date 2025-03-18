package classes;

public class Cliente {
    private static int contadorId = 0;
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.id = contadorId++;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone;
    }
}
