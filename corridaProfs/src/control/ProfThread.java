package control;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProfThread extends JLabel implements Runnable {
    private Thread ProfThread = null;
    private int posX;
    private int posY;
    private ImageIcon imagem;
    private static int pos=0;
    private String nome;
    // CONSTRUTOR DEFAULT
    public ProfThread() {
       
    }
    // CONSTRUTOR SOBRECARREGADO
    public ProfThread(String nome, ImageIcon img, int posX, int posY){
    super(img);
    this.imagem = img;
    this.posX = posX;
    this.posY = posY;
    this.nome = nome;
 
    ProfThread = new Thread(this, nome);
    ProfThread.start();
   
    }
    // M�TODO RUN() DA INTERFACE RUNNABLE
    @Override
    public void run() {
        try {
            while (posX < 1280) {
                posX += new Random().nextInt(3) * 25; // avanço pequeno
                this.setLocation(posX, posY);
                Thread.sleep(new Random().nextInt(5) * 100);
            }
            pos++;
            JOptionPane.showMessageDialog(null, pos + ") " + nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}