import java.io.IOException;
import java.util.List;
import java.util.Scanner;


        //Classe Principal e Inicialização

public class Main { //Declara a classe Main, que contém o método principal do programa.
    public static void main(String[] args) { // Método principal que inicia a execução do programa.
        UsuarioService usuarioService = new UsuarioService(); //Cria uma instância de UsuarioService para manipular usuários (salvar e listar).
        Scanner scanner = new Scanner(System.in); //Cria um scanner para ler a entrada do usuário via terminal.

        //Loop e Menu

        while (true) { //Inicia um loop infinito para exibir o menu repetidamente até que o usuário escolha "Sair".
            System.out.println("\n--- Menu ---"); //Exibe um cabeçalho do menu.
            System.out.println("1. Cadastrar novo usuário"); //Exibe as opções disponíveis no menu.
            System.out.println("2. Listar usuários"); // Exibe as opções disponíveis no menu.
            System.out.println("0. Sair"); //Exibe as opções disponíveis no menu.
            System.out.print("Escolha uma opção: "); //Exibe a mensagem pedindo que o usuário escolha uma opção.

            int opcao = scanner.nextInt(); //Lê a opção escolhida como um número inteiro.
            scanner.nextLine(); // Lê e descarta a quebra de linha após nextInt() para evitar erros na próxima entrada.

            //Opção 1 – Cadastrar Novo Usuário

            switch (opcao) { 
                case 1:
                    System.out.print("Nome: "); //Solicita o nome do usuário.
                    String nome = scanner.nextLine(); // Lê o nome digitado pelo usuário.
                    System.out.print("Email: "); // Solicita o e-mail do usuario.
                    String email = scanner.nextLine(); // Le o e-mail do usuario.
                    System.out.print("Senha: "); // solicita a senha do usuario.
                    String senha = scanner.nextLine(); //Le a senha do usuario.

                    Usuario usuario = new Usuario(nome, email, senha); // Cria um novo objeto Usuario com o nome, email e senha fornecidos.
                    try {
                        usuarioService.salvarUsuario(usuario);  //Tenta salvar o usuário usando o método salvarUsuario. Referente ao Try
                        System.out.println("Usuário cadastrado com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar o usuário: " + e.getMessage()); // Se houver erro de I/O, exibe uma mensagem de erro com o motivo.
                    }
                    break;

                    //Opção 2 – Listar Usuários

                case 2:
                    try {
                        List<Usuario> usuarios = usuarioService.listarUsuarios(); // Tenta listar os usuários cadastrados chamando listarUsuarios().
                        if (usuarios.isEmpty()) {
                            System.out.println("Nenhum usuário cadastrado."); // Se a lista estiver vazia, exibe uma mensagem informando que não há usuários.
                        } else {
                            System.out.println("--- Lista de Usuários ---"); // Caso contrário, imprime a lista de usuários.
                            usuarios.forEach(System.out::println);
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao listar os usuários: " + e.getMessage()); // Em caso de erro ao listar usuários, captura a exceção e exibe a mensagem.
                    }
                    break;

                    //Opção 0 – Encerrar o Programa

                case 0:
                    System.out.println("Encerrando o programa...");  //Exibe uma mensagem de encerramento.
                    scanner.close();
                    System.exit(0); //Fecha o scanner e encerra o programa usando System.exit(0).
                    break;

                    //Opção Inválida

                default:
                    System.out.println("Opção inválida! Tente novamente."); //Exibe uma mensagem caso o usuário insira uma opção inválida.
            }
        }
    }
}
