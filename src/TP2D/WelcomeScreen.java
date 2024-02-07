package TP2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeScreen extends JFrame{
    public WelcomeScreen() {
        super("Bienvenue dans le meilleur jeu du monde");

        // Chargement de l'image de fond
        ImageIcon backgroundImage = new ImageIcon("img\\heroTileSheet.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());

        // Création du message de bienvenue
        JLabel welcomeLabel = new JLabel("Bienvenue dans le meilleur jeu du monde");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Création des boutons
        JButton startButton = new JButton("Lancer une nouvelle partie");
        JButton quitButton = new JButton("Quitter la partie");

        // Ajout des actions aux boutons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme l'écran d'accueil
                MainInterface mainInterface = new MainInterface(); // Lance le jeu
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme l'écran d'accueil
            }
        });

        // Mise en page avec un layout de type BorderLayout
        setLayout(new BorderLayout());

        // Ajout de l'image de fond
        add(backgroundLabel, BorderLayout.CENTER);

        // Ajout du message de bienvenue au-dessus de l'image de fond
        backgroundLabel.add(welcomeLabel, BorderLayout.NORTH);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false); // Rend le panel transparent
        buttonPanel.add(startButton);
        buttonPanel.add(quitButton);

        // Ajout du panel de boutons en dessous de l'image de fond
        backgroundLabel.add(buttonPanel, BorderLayout.SOUTH);

        // Configuration de la fenêtre
        setSize(new Dimension(800, 500)); // Ajuste la taille pour accommoder les boutons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomeScreen::new); // Lance l'écran d'accueil
    }
}


