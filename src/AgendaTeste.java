import java.util.Scanner;

public class AgendaTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica();

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Contato contato = new Contato(nome, telefone, email);
                    agenda.adicionarContato(contato);
                    break;
                case 2:
                    System.out.print("Nome do contato a remover: ");
                    nome = scanner.nextLine();
                    agenda.removerContato(nome);
                    break;
                case 3:
                    System.out.print("Nome do contato a buscar: ");
                    nome = scanner.nextLine();
                    agenda.buscarContato(nome);
                    break;
                case 4:
                    agenda.listarContatos();
                    break;
                case 5:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
