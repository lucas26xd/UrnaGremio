package Classes;

import java.awt.Color;
import java.awt.Font;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Lucas
 */
public class Confirma {

    Votar v = new Votar();

    public void msg(String s, JButton b, String chapa, JButton b1, JButton b2, JButton b3, JButton b4, JButton b5) { //throws InterruptedException
        UIManager.getDefaults().put("OptionPane.background", new Color(217, 232, 238));//trocando a cor do fundo dos JOP
        UIManager.put("Panel.background", new Color(217, 232, 238));
        UIManager.put("OptionPane.noButtonText", "Não");//Trocando a linguagem
        UIManager.put("OptionPane.yesButtonText", "<html><font color=blue><b>Confirmar");
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 18)));//editando o texto
        int i = JOptionPane.showConfirmDialog(null, "\nDeseja confirmar seu voto " + s + " ?\n\n", "Confirmar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/Imagens/pergunta.png")));
        if (i == JOptionPane.YES_OPTION) {
            v.setVotar(chapa);
            borda(b, 0);//volta os botões ao estado inicial
            toque();//toque de confirma da urna
            bloqueia(b1, b2, b3, b4, b5);
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 24)));
            UIManager.put("OptionPane.okButtonText", "<html><font color=red><b>Valeu!");
            JOptionPane.showMessageDialog(null, "<html><font color=blue><b>Voto confirmado! :)   ", "Obrigado por votar!", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/Imagens/gostar.png")));
        } else {
            desbloqueia(b1, b2, b3, b4, b5);
        }
        borda(b, 0);//volta os botões ao estado inicial
        //Thread.sleep(5000);//5 seg
    }

    public void borda(JButton b, int i) {
        b.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), i, false));
    }

    public void toque() {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(getClass().getResource("/urna.wav"));
            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void bloqueia(JButton b1, JButton b2, JButton b3, JButton b4, JButton b5) {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
    }

    public void desbloqueia(JButton b1, JButton b2, JButton b3, JButton b4, JButton b5) {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
    }
}
