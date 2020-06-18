package Classes;

import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    Connection con = null;

    public Connection Abrir() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + new File("/").getAbsolutePath() + "urna.sqlite");
            System.out.println("Conexão aberta com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir conexão na classe Conexão.");
        }
        return con;
    }

    public void Fechar(Connection con) {
        try {
            con.close();
            System.out.println("Conexão fechada com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error ao fechar conexão.");
        }
    }
}
