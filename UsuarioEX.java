import java.io.Serializable; // Importa a interface Serializable, que permite que objetos dessa classe sejam salvos e recuperados de arquivos.

public class Usuario implements Serializable { //Declara a classe Usuario como serializável, ou seja, seus objetos podem ser transformados em fluxos de bytes para persistência (salvamento em arquivo, por exemplo).
    private String nome;  // Define os atributos privados da classe: nome.
    private String email;  // Define os atributos privados da classe: email.
    private String senha; // Define os atributos privados da classe: senha.

    public Usuario(String nome, String email, String senha) { //Construtor que inicializa um novo objeto Usuario com os valores fornecidos para nome, email e senha.
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() { //Sobrescreve o método toString() para retornar uma representação do usuário como uma linha de texto.
        return nome + ";" + email + ";" + senha; // Os dados são separados por ; para facilitar o armazenamento em arquivos e a posterior leitura.
    }

    public static Usuario fromString(String linha) {  //Método estático que cria um objeto Usuario a partir de uma linha de texto (como as geradas pelo toString()).
        String[] partes = linha.split(";"); // Usa split(";") para dividir a string em partes e inicializa um novo Usuario com esses valores.
        return new Usuario(partes[0], partes[1], partes[2]);
    }

    // Getters e Setters // Getters fornecem acesso controlado aos atributos privados da classe:
    public String getNome() { return nome; }  // getNome(): Retorna o nome do usuário.
    public String getEmail() { return email; } // getEmail(): Retorna o email do usuário.
    public String getSenha() { return senha; } // getSenha(): Retorna a senha do usuário
}
