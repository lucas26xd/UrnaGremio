package Classes;

import java.sql.*;

public class BD {

    Statement stmt = null;
    Connection con = null;
    String sql = null;
    Conexao conexao = new Conexao();

    public void Criar_Tabela() {
        try {
            con = conexao.Abrir();
            stmt = con.createStatement();
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

            System.out.println("Update feito com sucesso.");
            
            stmt.close();
        } catch (Exception ex) {
            System.err.println("Erro ao criar tabela.");
        }
        conexao.Fechar(con);
    }
}
