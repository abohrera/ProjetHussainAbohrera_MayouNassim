package TP2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class FramerateDisplay extends JLabel {

    private int frameCount;
    private long startTime;

    public FramerateDisplay() {
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setVerticalAlignment(JLabel.TOP);
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);

        javax.swing.Timer timer = new javax.swing.Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFramerate();
            }
        });
        timer.start();

        startTime = System.currentTimeMillis();
    }

    private void updateFramerate() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;

        if (elapsedTime > 0) {
            double fps = (double) frameCount * 1000 / elapsedTime;
            setText("FPS: " + String.format("%.2f", fps));
        }

        // Réinitialise le compteur de trames et le temps de départ
        frameCount = 0;
        startTime = currentTime;
    }

    public void incrementFrameCount() {
        frameCount++;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Framerate Display Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);

                FramerateDisplay framerateDisplay = new FramerateDisplay();
                frame.getContentPane().add(framerateDisplay, BorderLayout.NORTH);

                frame.setVisible(true);

                // Simule l'incrémentation du compteur de trames à chaque rafraîchissement
                javax.swing.Timer timer = new javax.swing.Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        framerateDisplay.incrementFrameCount();
                        framerateDisplay.repaint();
                    }
                });
                timer.start();
            }
        });
    }
}
