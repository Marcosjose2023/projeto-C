package Interface;

import classes.Pedido;

public class RetiradaPedido implements PedidoStrategy {
    @Override
    public void processarPedido(Pedido pedido) {
        pedido.atualizarStatus("Pronto para retirada");
        System.out.println("Pedido " + pedido.getId() + " está pronto para retirada!");
    }
}
