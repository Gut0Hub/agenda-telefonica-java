import java.sql.*;

public class AgendaTelefonica {
    private Connection conexao;

    public AgendaTelefonica() {
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta ao banco de dados via XAMPP (sem senha)
            conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/agendaDB",
                "root",
                ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.executeUpdate();
            System.out.println("Contato adicionado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerContato(String nome) {
        String sql = "DELETE FROM contatos WHERE nome = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Contato removido!");
            } else {
                System.out.println("Contato não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buscarContato(String nome) {
        String sql = "SELECT * FROM contatos WHERE nome = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome") +
                                   ", Telefone: " + rs.getString("telefone") +
                                   ", Email: " + rs.getString("email"));
            } else {
                System.out.println("Contato não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarContatos() {
        String sql = "SELECT * FROM contatos";
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome") +
                                   ", Telefone: " + rs.getString("telefone") +
                                   ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
