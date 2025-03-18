package Interface;

import classes.Pedido;

public class EntregaPedido implements PedidoStrategy {
    @Override
    public void processarPedido(Pedido pedido) {
        pedido.atualizarStatus("Em entrega");
        System.out.println("Pedido " + pedido.getId() + " está a caminho!");
    }
}
