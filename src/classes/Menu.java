package classes;

import Interface.EntregaPedido;
import Interface.PedidoStrategy;
import Interface.RetiradaPedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Cliente> clientes;
    private List<Restaurante> restaurantes;
    private List<Pedido> pedidos;
    private Scanner scanner;

    private static Menu instance;

    private Menu() {
        clientes = new ArrayList<>();
        restaurantes = new ArrayList<>();
        pedidos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void abrirMenu() {
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Buscar Cliente pelo Nome");
            System.out.println("3 - Cadastrar Restaurante");
            System.out.println("4 - Buscar Restaurante pelo Nome");
            System.out.println("5 - Criar Pedido");
            System.out.println("6 - Consultar Pedido");
            System.out.println("7 - Processar Pedido");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> novoCliente();
                case 2 -> buscarCliente();
                case 3 -> cadastrarRestaurante();
                case 4 -> buscarRestaurante();
                case 5 -> criarPedido();
                case 6 -> consultarPedido();
                case 7 -> processarPedido();
                case 8 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 8);
    }

    private void novoCliente() {
        // Código para cadastrar cliente
    }

    private void buscarCliente() {
        // Código para buscar cliente
    }

    private void cadastrarRestaurante() {
        // Código para cadastrar restaurante
    }

    private void buscarRestaurante() {
        // Código para buscar restaurante
    }

    private void criarPedido() {
        System.out.println("\n--- Criar Pedido ---");
        System.out.print("Digite o ID do Cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o ID do Restaurante: ");
        int restauranteId = scanner.nextInt();
        scanner.nextLine();

        if (clienteId >= clientes.size() || restauranteId >= restaurantes.size()) {
            System.out.println("Cliente ou Restaurante não encontrado.");
            return;
        }

        Pedido pedido = pedidoFactory.criarPedido(clientes.get(clienteId), restaurantes.get(restauranteId));
        pedidos.add(pedido);

        System.out.println("Pedido criado com sucesso! ID: " + pedido.getId());
    }

    private void consultarPedido() {
        // Código para consultar pedido
    }

    private void processarPedido() {
        System.out.print("Digite o ID do Pedido: ");
        int pedidoId = scanner.nextInt();

        if (pedidoId >= pedidos.size()) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        Pedido pedido = pedidos.get(pedidoId);

        System.out.println("Escolha o tipo de processamento:");
        System.out.println("1 - Entrega");
        System.out.println("2 - Retirada");
        int opcao = scanner.nextInt();

        PedidoStrategy strategy = (opcao == 1) ? new EntregaPedido() : new RetiradaPedido();
        pedido.setPedidoStrategy((classes.PedidoStrategy) strategy);
        pedido.processarPedido();
    }
}
