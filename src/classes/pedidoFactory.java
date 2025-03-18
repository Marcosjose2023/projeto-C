package classes;

public class pedidoFactory {
        // Método estático para criar um novo Pedido
        public static Pedido criarPedido(Cliente cliente, Restaurante restaurante) {
            // Cria e retorna uma nova instância de Pedido
            return new Pedido(cliente, restaurante);
        }
    }


