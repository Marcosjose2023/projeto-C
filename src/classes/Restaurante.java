package classes;

public class Restaurante {
    private static int contadorId = 0;
    private int id;
    private String nome;
    private String categoria;

    public Restaurante(String nome, String categoria) {
        this.id = contadorId++;
        this.nome = nome;
        this.categoria = categoria;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Categoria: " + categoria;
    }
}
