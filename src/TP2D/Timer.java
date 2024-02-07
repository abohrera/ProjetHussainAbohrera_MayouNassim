package TP2D;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Timer {
    private JFrame frame;
    private JLabel labelTimer;
    private javax.swing.Timer timer;
    private int secondesRestantes = 0;

    public Timer(){
        frame = new JFrame("JEU JAVA");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelTimer = new JLabel("Temps écoulé : 0 secondes");
        frame.add(labelTimer);

        timer = new javax.swing.Timer(1000, new ActionListener() {
            int secondesRestantes = 30;//Initialisation des secondes a 20
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code exécuté à chaque tick du timer
                if (secondesRestantes > 0) {
                    secondesRestantes--;
                    labelTimer.setText("Temps écoulé : " + secondesRestantes + " secondes");
                } else {
                    timer.stop();
                    labelTimer.setText("Limite de Temps atteinte !");
                }
            }
        });
        timer.start();

        frame.setVisible(true);
    }

    public void startTimer() {
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Timer jeu = new Timer();
                jeu.startTimer(); // Démarre le timer lorsque le jeu démarre
            }
        });
    }
}


