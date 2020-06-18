package GUI;

import Classes.BD;
import Classes.Confirma;
import Classes.Votar;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 *
 * @author Lucas and Ivan
 */
public class Principal extends javax.swing.JFrame implements SerialPortEventListener {

    String chapa = null;
    Votar v = new Votar();
    Confirma c = new Confirma();

    private SerialPort serialPort;
    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;

    private void inicializaSerial() {
        final String PORT_NAME = "/dev/ttyUSB0"; //Linux
//        final String PORT_NAME = "COM5"; //Windows
        System.setProperty("gnu.io.rxtx.SerialPorts", PORT_NAME);
        CommPortIdentifier portId = null;
        Enumeration pList = CommPortIdentifier.getPortIdentifiers();
        while (pList.hasMoreElements()) {
            CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();
            System.out.println(cpi.getName());
            if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL)
                portId = cpi;
        }
        if (portId == null) {
            System.err.println("Nenhuma porta COM encontrada.");
            return;
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                System.out.println(inputLine);
                if (inputLine.equals("0")) {//botão pressionado
                    c.desbloqueia(chapa01, chapa02, chapa03, chapa04, Branco);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    public Principal() {
        new BD().CriarTabela();
        initComponents();
        inicializaSerial();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/urna.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        chapa01 = new javax.swing.JButton();
        chapa03 = new javax.swing.JButton();
        chapa04 = new javax.swing.JButton();
        chapa02 = new javax.swing.JButton();
        Branco = new javax.swing.JButton();
        LogoEstado = new javax.swing.JLabel();
        LogoEscola = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("   Urna Eletoral para grêmio estudantil                                                                                 Desenvolvedores:   Lucas  e  Ivan");

        painel.setBackground(new java.awt.Color(220, 220, 220));

        chapa01.setBackground(new java.awt.Color(204, 204, 204));
        chapa01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Chapas/gremio s1.jpg"))); // NOI18N
        chapa01.setToolTipText("Ao clicar aqui você irá votar na Chapa 05");
        chapa01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chapa01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapa01ActionPerformed(evt);
            }
        });

        chapa03.setBackground(new java.awt.Color(204, 204, 204));
        chapa03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Chapas/gremio s3.jpg"))); // NOI18N
        chapa03.setToolTipText("Ao clicar aqui você irá votar na Chapa 07");
        chapa03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chapa03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapa03ActionPerformed(evt);
            }
        });

        chapa04.setBackground(new java.awt.Color(204, 204, 204));
        chapa04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Chapas/gremio s4.jpg"))); // NOI18N
        chapa04.setToolTipText("Ao clicar aqui você irá votar na Chapa 08");
        chapa04.setBorder(null);
        chapa04.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chapa04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapa04ActionPerformed(evt);
            }
        });

        chapa02.setBackground(new java.awt.Color(204, 204, 204));
        chapa02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Chapas/gremio s2.jpg"))); // NOI18N
        chapa02.setToolTipText("Ao clicar aqui você irá votar na Chapa 06");
        chapa02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chapa02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapa02ActionPerformed(evt);
            }
        });

        Branco.setBackground(new java.awt.Color(255, 255, 255));
        Branco.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        Branco.setText("Branco");
        Branco.setToolTipText("Ao clicar aqui você irá votar em Branco");
        Branco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Branco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Branco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrancoActionPerformed(evt);
            }
        });

        LogoEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/seduc.png"))); // NOI18N

        LogoEscola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/profissional.png"))); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(chapa01, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chapa02, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(chapa03, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chapa04, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Branco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chapa01, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chapa02, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LogoEscola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chapa04, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chapa03, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(LogoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Branco, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chapa01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapa01ActionPerformed
        chapa = "CH01";
        c.borda(chapa01, 8);
        c.msg("na Chapa 01", chapa01, chapa, chapa01, chapa02, chapa03, chapa04, Branco);
        //bloqueia();
    }//GEN-LAST:event_chapa01ActionPerformed

    private void chapa02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapa02ActionPerformed
        chapa = "CH02";
        c.borda(chapa02, 8);
        c.msg("na Chapa 02", chapa02, chapa, chapa01, chapa02, chapa03, chapa04, Branco);
    }//GEN-LAST:event_chapa02ActionPerformed

    private void chapa03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapa03ActionPerformed
        chapa = "CH03";
        c.borda(chapa03, 8);
        c.msg("na Chapa 03", chapa03, chapa, chapa01, chapa02, chapa03, chapa04, Branco);
    }//GEN-LAST:event_chapa03ActionPerformed

    private void chapa04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapa04ActionPerformed
        chapa = "CH04";
        c.borda(chapa04, 8);
        c.msg("na Chapa 04", chapa04, chapa, chapa01, chapa02, chapa03, chapa04, Branco);
    }//GEN-LAST:event_chapa04ActionPerformed

    private void BrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrancoActionPerformed
        chapa = "BRANCO";
        c.borda(Branco, 8);
        c.msg("Branco", Branco, chapa, chapa01, chapa02, chapa03, chapa04, Branco);
        Branco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
    }//GEN-LAST:event_BrancoActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        //Look and feel
        /*try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }*/
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Branco;
    private javax.swing.JLabel LogoEscola;
    private javax.swing.JLabel LogoEstado;
    private javax.swing.JButton chapa01;
    private javax.swing.JButton chapa02;
    private javax.swing.JButton chapa03;
    private javax.swing.JButton chapa04;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}
