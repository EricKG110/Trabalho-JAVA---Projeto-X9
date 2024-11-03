import java.io.*;  //Importa classes da API de I/O (java.io) para manipulação de arquivos e exceções.
import java.util.ArrayList; //Importa ArrayList e List para trabalhar com listas de usuários.
import java.util.List; //Importa ArrayList e List para trabalhar com listas de usuários.

public class UsuarioService { // Declara a classe UsuarioService, que contém métodos para salvar e listar usuários.
    private static final String ARQUIVO = "usuarios.txt";  //Define uma constante estática que armazena o nome do arquivo onde os dados dos usuários serão salvos.

    //Método salvarUsuario()

    public void salvarUsuario(Usuario usuario) throws IOException { //Declara o método salvarUsuario, que recebe um objeto Usuario e pode lançar uma exceção de I/O caso algo dê errado na gravação.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) { //Cria um BufferedWriter com FileWriter para gravar no arquivo. // O modo "append" (true) permite adicionar novos dados sem sobrescrever o conteúdo existente.
            writer.write(usuario.toString()); //Escreve o usuário no arquivo, usando o método toString() da classe Usuario.
            writer.newLine(); // Adiciona uma nova linha para separar os registros.
        } //O bloco try-with-resources garante que o BufferedWriter seja fechado automaticamente após o uso, mesmo que ocorra uma exceção.
    }


    //Método listarUsuarios()


    public List<Usuario> listarUsuarios() throws IOException {  // Declara o método listarUsuarios, que retorna uma lista de objetos Usuario e pode lançar uma exceção de I/O.
        List<Usuario> usuarios = new ArrayList<>(); // Cria uma lista vazia para armazenar os usuários lidos do arquivo.
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) { // Abre um BufferedReader com FileReader para ler o conteúdo do arquivo linha por linha.
            String linha; //Lê o arquivo linha por linha usando readLine().
            while ((linha = reader.readLine()) != null) { // O loop continua até que não haja mais linhas no arquivo.
                usuarios.add(Usuario.fromString(linha)); // Converte a linha lida em um objeto Usuario usando o método fromString() e adiciona à lista de usuários.
            } //O bloco try-with-resources garante que o BufferedReader seja fechado automaticamente após o uso.
        }
        return usuarios; // Retorna a lista de usuários lidos do arquivo. 
        }
}
