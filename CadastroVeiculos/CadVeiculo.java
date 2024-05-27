import entities.Carro;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import services.VeiculoService;

public class CadVeiculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeiculoService veiculoService = new VeiculoService();

        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Cadastrar Veículo");
                System.out.println("2. Mostrar número total de veículos");
                System.out.println("3. Listar todos os veículos");
                System.out.println("4. Procurar veículo por placa");
                System.out.println("5. Sair");
                System.out.println("6. Remover veículo por placa"); // Opção adicionada
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.println("Tipo de Veículo:");
                        System.out.println("1. Carro");
                        System.out.println("2. Moto");
                        System.out.print("Escolha uma opção: ");
                        int tipoVeiculo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha

                        System.out.print("Placa: ");
                        String placa = scanner.nextLine();

                        switch (tipoVeiculo) {
                            case 1:
                                // Entrada de dados para o Carro
                                System.out.println("Informe os dados do carro:");
                                System.out.print("Marca: ");
                                String carroMarca = scanner.nextLine();
                                System.out.print("Modelo: ");
                                String carroModelo = scanner.nextLine();
                                int carroAno = lerAno(scanner);

                                veiculoService.criarCarro(carroMarca, carroModelo, carroAno, placa);
                                System.out.println("Veículo cadastrado com sucesso!");
                                break;

                            case 2:
                                // Entrada de dados para a Moto
                                System.out.println("Informe os dados da moto:");
                                System.out.print("Marca: ");
                                String motoMarca = scanner.nextLine();
                                System.out.print("Modelo: ");
                                String motoModelo = scanner.nextLine();
                                int motoAno = lerAno(scanner);
                                boolean partidaEletrica = lerPartidaEletrica(scanner);

                                veiculoService.criarMoto(motoMarca, motoModelo, motoAno, partidaEletrica, placa);
                                System.out.println("Veículo cadastrado com sucesso!");
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("Número total de veículos: " + veiculoService.contarVeiculos());
                        break;

                    case 3:
                        System.out.println("Listando todos os veículos:");
                        List<Carro> listaCarros = veiculoService.listarCarros();
                        for (Carro carro : listaCarros) {
                            System.out.println(carro.toString());
                        }
                        break;

                    case 4:
                        System.out.print("Digite a placa do veículo a ser procurado: ");
                        placa = scanner.nextLine();
                        Carro carroEncontrado = veiculoService.procurarCarroPorPlaca(placa);
                        if (carroEncontrado != null) {
                            System.out.println("Veículo encontrado:");
                            System.out.println(carroEncontrado.toString());
                        } else {
                            System.out.println("Nenhum veículo encontrado com essa placa.");
                        }
                        break;

                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    case 6:
                        // Opção para remover veículo por placa
                        System.out.print("Digite a placa do veículo a ser removido: ");
                        placa = scanner.nextLine();
                        if (veiculoService.removerVeiculoPorPlaca(placa)) {
                            System.out.println("Veículo removido com sucesso!");
                        } else {
                            System.out.println("Nenhum veículo encontrado com essa placa.");
                        }
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Consumir a entrada inválida
            } catch (Exception e) {
                System.out.println("Não foi possível realizar a operação: " + e.getMessage());
            } finally {
                System.out.println("Pressione Enter para voltar ao Menu Inicial");
                scanner.nextLine(); // Aguardar pressionar Enter
                limparConsole();
            }
        }
    }

    private static int lerAno(Scanner scanner) {
        int ano;
        while (true) {
            try {
                System.out.print("Ano: ");
                ano = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                if (ano > 0 && ano <= 2024) {
                    break;
                } else {
                    System.out.println("Ano inválido. Digite um ano entre 1 e 2024.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ano inválido. Digite um valor numérico inteiro.");
                scanner.nextLine(); // Consumir a entrada inválida
            }
        }
        return ano;
    }

    private static boolean lerPartidaEletrica(Scanner scanner) {
        System.out.print("Partida elétrica (true/false): ");
        while (true) {
            try {
                return scanner.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Digite 'true' ou 'false'.");
                scanner.nextLine(); // Consumir a entrada inválida
            }
        }
    }

    private static void limparConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }
}
