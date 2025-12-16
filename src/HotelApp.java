import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CatalogoQuartos<Quarto> catalogoQuartos = new CatalogoQuartos<>();

        // Quartos iniciais
        for (int i = 1; i <= 5; i++) {
            catalogoQuartos.adicionar(new QuartoSimples(i, "Quarto simples", 450));
        }
        for (int i = 6; i <= 10; i++) {
            catalogoQuartos.adicionar(new SuiteLuxo(i, "Suíte luxo", 600));
        }

        System.out.println("=== Cadastro de quartos ===");

        try {   // ABRE TRY 1

            System.out.println("Digite o número do quarto para o cadastro: ");
            int numero = scanner.nextInt();

            if (!catalogoQuartos.existe(numero)) {

                System.out.println("Qual o tipo de quarto (1 = suíte / 2 = quarto simples): ");
                int tipo = scanner.nextInt();

                if (tipo == 1 || tipo == 2) {

                    System.out.println("Qual a descrição do quarto: ");
                    String descricao = scanner.next();

                    System.out.println("Qual o valor da diária: ");
                    double valor = scanner.nextDouble();

                    if (tipo == 1) {
                        catalogoQuartos.adicionar(new SuiteLuxo(numero, descricao, valor));
                    } else {
                        catalogoQuartos.adicionar(new QuartoSimples(numero, descricao, valor));
                    }

                } else {
                    System.out.println("Tipo inexistente");
                }

            } else {
                System.out.println("Quarto já existe, cadastro cancelado");
            }

        } catch (InputMismatchException e) {   // FECHA TRY 1
            System.out.println("Entrada inválida! Use apenas números.");
            scanner.nextLine(); // limpa buffer
        }

        // ==================================================================================

        System.out.println("\n=== Realizando uma reserva === ");

        try {   // ABRE TRY 2

            System.out.print("Digite o número do quarto para a reserva: ");
            int numeroQ = scanner.nextInt();

            Quarto quarto = catalogoQuartos.buscar(numeroQ);

            if (quarto == null) {
                System.out.println("Quarto inexistente");
            } else {

                System.out.println("Qual a quantidade de diárias: ");
                int quantidadeDiarias = scanner.nextInt();

                quarto.reservar(quantidadeDiarias);
                System.out.println("Valor total: R$ " + quarto.calcularValorTotal(quantidadeDiarias));
            }

        } catch (InputMismatchException e) {   // FECHA TRY 2
            System.out.println("Erro: número inválido.");
            scanner.nextLine();
        }

        // ==================================================================================

        System.out.println("\n=== Aplicar desconto ===");

        try {   // ABRE TRY 3

            System.out.println("Digite o número do quarto para o desconto: ");
            int numeroDesconto = scanner.nextInt();

            Quarto quartoDesc = catalogoQuartos.buscar(numeroDesconto);

            if (quartoDesc == null) {
                System.out.println("Quarto inexistente");
            } else {

                System.out.println("Qual a porcentagem de desconto: ");
                double porcentagemDesconto = scanner.nextDouble();

                try {   // ABRE TRY 3.1
                    quartoDesc.aplicarDesconto(porcentagemDesconto);
                    System.out.println("Desconto aplicado com sucesso!");
                } catch (IllegalArgumentException e) {   // FECHA TRY 3.1
                    System.out.println("Erro: " + e.getMessage());
                }
            }

        } catch (InputMismatchException e) {   // FECHA TRY 3
            System.out.println("Erro: entrada inválida.");
            scanner.nextLine();
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}
