package Classes;

import java.sql.*;
import javax.swing.JOptionPane;

public class Votar {

    String sql = null;
    Statement stmt = null;
    Connection con = null;
    int cont = 0;
    Conexao conexao = null;
    BD bd = null;

    public void setVotar(String chapa) {
        try {
            conexao = new Conexao();
            con = conexao.Abrir();
            stmt = con.createStatement();
            sql = "SELECT VOTO FROM CANDIDATOS WHERE NOME = '" + chapa + "';";
            ResultSet rs = stmt.executeQuery(sql);
            cont = rs.getInt("VOTO");
            cont++;
            //System.out.println("Candidatos: "+chapa+"\nVoto: "+cont);
            sql = "UPDATE CANDIDATOS SET VOTO = " + cont + " WHERE NOME = '" + chapa + "';";

            stmt.executeUpdate(sql);
            System.out.println("Voto realizado com sucesso.");
        } catch (Exception ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao votar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
