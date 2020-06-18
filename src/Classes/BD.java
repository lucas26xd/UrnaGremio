package Classes;

import java.sql.*;

public class BD {

    Statement stmt = null;
    Connection con = null;
    String sql = null;
    Conexao conexao = new Conexao();

    public void CriarTabela() {
        try {
            con = conexao.Abrir();
            stmt = con.createStatement();
            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM CANDIDATOS ORDER BY VOTO DESC;");
                if (rs != null) {
                    System.out.println("Tabela já criada!");
                }
            } catch (SQLException sqlex) {
                sql = "CREATE TABLE CANDIDATOS"
                        + "(NOME VARCHAR (10) NOT NULL,"
                        + "VOTO INT (300) NOT NULL);";
                stmt.executeUpdate(sql);
                System.out.println("Tabela criada com sucesso.");

                sql = "INSERT INTO CANDIDATOS VALUES ('CH01', 0);";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO CANDIDATOS VALUES ('CH02', 0);";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO CANDIDATOS VALUES ('CH03', 0);";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO CANDIDATOS VALUES ('CH04', 0);";
                stmt.executeUpdate(sql);

                sql = "INSERT INTO CANDIDATOS VALUES ('BRANCO', 0);";
                stmt.executeUpdate(sql);

                stmt.close();
            }
        } catch (Exception ex) {
            System.err.println("Erro ao criar tabela.");
        }
        conexao.Fechar(con);
    }
}
