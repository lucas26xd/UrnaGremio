package GUI;

import Classes.Tabela;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author Lucas
 */
public class Administrador extends javax.swing.JFrame {

    Tabela tb = new Tabela();

    public Administrador() {
        String senha = "";
        while (!"qwe123".equals(senha)) {
            JPasswordField password = new JPasswordField(10);
            password.setEchoChar('*');

            JLabel rotulo = new JLabel("Entre com a senha do administrador:");

            JPanel entUsuario = new JPanel();
            entUsuario.add(rotulo);
            entUsuario.add(password);
            JOptionPane.showMessageDialog(null, entUsuario, "Acesso restrito", JOptionPane.PLAIN_MESSAGE);
            senha = password.getText();
        }
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/politica.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JScrollPane();
        TabelaResultado = new javax.swing.JTextArea();
        barraMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuItemUrna = new javax.swing.JMenuItem();
        separador1 = new javax.swing.JPopupMenu.Separator();
        menuItemResultado = new javax.swing.JMenuItem();
        separador2 = new javax.swing.JPopupMenu.Separator();
        menuItemPDF = new javax.swing.JMenuItem();
        menuZerar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador");

        tab.setAutoscrolls(true);

        TabelaResultado.setEditable(false);
        TabelaResultado.setBackground(new java.awt.Color(204, 204, 204));
        TabelaResultado.setColumns(20);
        TabelaResultado.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        TabelaResultado.setRows(5);
        tab.setViewportView(TabelaResultado);

        menuArquivo.setText("Arquivo");

        menuItemUrna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/urna.png"))); // NOI18N
        menuItemUrna.setText("Iniciar Urna");
        menuItemUrna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUrnaActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemUrna);
        menuArquivo.add(separador1);

        menuItemResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/politica.png"))); // NOI18N
        menuItemResultado.setText("Resultado");
        menuItemResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemResultadoActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemResultado);
        menuArquivo.add(separador2);

        menuItemPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pdf.png"))); // NOI18N
        menuItemPDF.setText("Gerar PDF");
        menuItemPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPDFActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemPDF);

        barraMenu.add(menuArquivo);

        menuZerar.setText("Zerar Banco");
        menuZerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuZerarMouseClicked(evt);
            }
        });
        menuZerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuZerarActionPerformed(evt);
            }
        });
        barraMenu.add(menuZerar);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuZerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuZerarMouseClicked
        tb.Zerar();
        TabelaResultado.setText("");
        TabelaResultado.append(tb.consulta());
    }//GEN-LAST:event_menuZerarMouseClicked

    private void menuItemUrnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUrnaActionPerformed
        new Principal().setVisible(true);
        super.setVisible(false);
    }//GEN-LAST:event_menuItemUrnaActionPerformed

    private void menuItemResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemResultadoActionPerformed
        TabelaResultado.append(tb.consulta());
    }//GEN-LAST:event_menuItemResultadoActionPerformed

    private void menuZerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuZerarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja zerado todo o bnaco de dados?", "Zerar banco?", JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            tb.Zerar();
            JOptionPane.showMessageDialog(null, "Banco zerado com sucesso!", "Zerado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_menuZerarActionPerformed

    private void menuItemPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPDFActionPerformed
        Document document = new Document(PageSize.A4, 72, 72, 72, 72);
        try {
            Font fontBold = new Font(FontFamily.COURIER, 24, Font.BOLD);
            Font fontItalic = new Font(FontFamily.COURIER, 12, Font.ITALIC);
            Date dt = new Date();
            Image img = Image.getInstance(getClass().getResource("/brasao.png").toString());
            img.setAlignment(Element.ALIGN_RIGHT);
            PdfWriter.getInstance(document, new FileOutputStream(getClass().getResource("/Resultado.pdf").toString()));
            document.open();
            document.add(img);
            document.add(new Paragraph("        RESULTADO FINAL:", fontBold));
            document.add(new Paragraph("Apuração dos votos do dia: " + dt.getDate() + "/" + dt.getMonth() + "  Documento criado às " + dt.getHours() + ":" + dt.getMinutes(), fontItalic));
            document.add(new Paragraph(tb.consulta()));
            JOptionPane.showMessageDialog(null, "O arquivo PDF foi gerado com sucesso!\nEle foi salvo em: '" + getClass().getResource("/Resultado.pdf") + "'", "Salvo com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        document.close();
    }//GEN-LAST:event_menuItemPDFActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        /*try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }*/
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TabelaResultado;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuItemPDF;
    private javax.swing.JMenuItem menuItemResultado;
    private javax.swing.JMenuItem menuItemUrna;
    private javax.swing.JMenu menuZerar;
    private javax.swing.JPopupMenu.Separator separador1;
    private javax.swing.JPopupMenu.Separator separador2;
    private javax.swing.JScrollPane tab;
    // End of variables declaration//GEN-END:variables
}
