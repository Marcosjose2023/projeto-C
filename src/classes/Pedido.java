package classes;

public class Pedido {
    private static int contadorId = 0;
    private int id;
    private Cliente cliente;
    private Restaurante restaurante;
    private String status;
    private PedidoStrategy strategy;

    public Pedido(Cliente cliente, Restaurante restaurante) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.status = "Novo";
    }

    public int getId() {
        return id;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setPedidoStrategy(PedidoStrategy strategy) {
        this.strategy = strategy;
    }

    public void processarPedido() {
        if (strategy != null) {
            strategy.processarPedido(this);
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", restaurante=" + restaurante.getNome() +
                ", status='" + status + '\'' +
                '}';
    }
}
