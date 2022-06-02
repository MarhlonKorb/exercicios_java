import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Connection conexao = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas WHERE nome like ?";

        System.out.println("Informe um valor para pesquisa: ");
        String valor = entrada.nextLine();

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + valor + "%");
            ResultSet resultado = stmt.executeQuery();

            List<Pessoa> pessoas = new ArrayList<>();

            while (resultado.next()){
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");
                pessoas.add(new Pessoa(codigo, nome));
            }

            for(Pessoa p: pessoas){
                System.out.println(p.getCodigo() + " ==> " + p.getNome());
            }

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        entrada.close();
    }
}
