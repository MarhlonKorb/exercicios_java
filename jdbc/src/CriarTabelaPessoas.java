import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {

    public static void main(String[] args) {
        Connection conexao = FabricaConexao.getConexao();

        String sql = "CREATE TABLE pessoas ("
                + "codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "nome VARCHAR(80) NOT NULL"
                + ")";

        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela criada com sucesso!");
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
