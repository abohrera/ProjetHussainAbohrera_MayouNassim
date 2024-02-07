package TP2D;
import javax.swing.*;
import java.awt.*;


public class GameOver extends JFrame {
    private static boolean isGameOverDisplayed = false;  // Ajout d'une variable statique pour suivre l'état d'affichage
    //private static boolean isDisplayed = false;

    public GameOver() {
        super("Game Over");
        this.setSize(820, 520);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon gameOverImage = new ImageIcon("img/Game_Over2.png");

        Image image = gameOverImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedGameOverImage = new ImageIcon(image);
        JLabel imageLabel = new JLabel(resizedGameOverImage);

        JLabel gameOverLabel = new JLabel("Game Over - Temps écoulé!");
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(gameOverLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);
        this.add(panel);
        this.setVisible(true);
    }
        public static boolean isGameOverDisplayed () {
            return isGameOverDisplayed;
        }

        public static void setGameOverDisplayed ( boolean gameOverDisplayed){
            isGameOverDisplayed = gameOverDisplayed;
        }
    }

