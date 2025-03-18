package classes;

public class PedidoStrategy {
    public static Pedido criarPedido(Cliente cliente, Restaurante restaurante) {
        return new Pedido(cliente, restaurante);
    }

    public void processarPedido(Pedido pedido) {
    }
}
