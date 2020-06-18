package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tabela {

    Conexao conexao = new Conexao();
    Connection con = conexao.Abrir();
    Statement stmt = null;
    ResultSet rs = null;
    String sql = null;

    public String Consulta() {
        String a = "";
        try {
            String nome = null;
            int voto = 0;
            con = conexao.Abrir();
            stmt = con.createStatement();
            sql = "SELECT * FROM CANDIDATOS ORDER BY VOTO DESC;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                nome = rs.getString("NOME");
                voto = rs.getInt("VOTO");
                a += "Resultado final: " + nome + " -> " + voto + "\n";
            }
            conexao.Fechar(con);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return a;
    }

    public void Zerar() {
        try {
            con = conexao.Abrir();
            stmt = con.createStatement();
            sql = "UPDATE CANDIDATOS SET VOTO = 0;";
            rs = stmt.executeQuery(sql);
            System.out.println("Zerado com sucesso.");
            stmt.close();
            conexao.Fechar(con);
        } catch (Exception ex) {
            System.err.println("Erro ao zerar.\n" + ex);
        }
    }
}
