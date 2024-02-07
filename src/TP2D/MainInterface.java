package TP2D;
import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.Timer;


public class MainInterface extends JFrame implements KeyListener {
    JLabel labelTimer = new JLabel("Temps restant : 30 secondes"); // Ajout de la JLabel pour le timer
    TileManager tileManager = new TileManager(48,48,"./img/tileSet.png");
    Dungeon dungeon = new Dungeon("./gameData/level1.txt",tileManager);
    Hero hero = Hero.getInstance();
    GameRender panel = new GameRender(dungeon,hero);
    FramerateDisplay framerateDisplay = new FramerateDisplay();

    int secondesRestantes=30;
    private final int speed = 10;
    private boolean gameOverDisplayed = false;

    public MainInterface() throws HeadlessException {
        super();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(labelTimer, BorderLayout.SOUTH);
        this.getContentPane().add(framerateDisplay, BorderLayout.NORTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.setSize(new Dimension(dungeon.getWidth() * tileManager.getWidth(), dungeon.getHeight() * tileManager.getHeigth()));
        this.addKeyListener(this);

        javax.swing.Timer timer = new javax.swing.Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimerLabel();
            }
        });
        timer.start();
        javax.swing.Timer timerUpdate = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimerLabel();
                framerateDisplay.incrementFrameCount();  // Incrémente le compteur de framerate
                framerateDisplay.repaint();
            }
        });
        timerUpdate.start();


        javax.swing.Timer movetimer = new javax.swing.Timer(50, new ActionListener() {
            //ActionListener animationTimer=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                // Met a jour le temps restants
                // final int speed=10;
                if (hero.isWalking()) {
                    moveCharacter();
                }
            }
        });
        movetimer.start();
    }
    private static MainInterface showWelcomeScreen() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.setVisible(true);
        return null;
    }

                private void moveCharacter() {
                    switch (hero.getOrientation()){
                        case LEFT:  hero.moveIfPossible(-speed,0,dungeon);
                                    break;
                        case RIGHT: hero.moveIfPossible(speed,0,dungeon);
                                    break;
                        case UP:    hero.moveIfPossible(0,-speed,dungeon);
                                    break;
                        case DOWN:  hero.moveIfPossible(0,speed,dungeon);
                                    break;

                    }
                }


        //javax.swing.Timer timer = new javax.swing.Timer(1000,animationTimer);
        //movementTimer.start();

    private void updateTimerLabel() {
       // int seconds = (int) (System.currentTimeMillis() / 1000);
        //int secondesRestantes = Integer.parseInt(labelTimer.getText().split("")[2]);
        if (secondesRestantes>0) {
            secondesRestantes--;
            labelTimer.setText("Temps restants :" + secondesRestantes + "secondes");
        }else {
            labelTimer.setText("Temps écoulé!");// Mettez à jour le texte de la JLabel avec le temps écoulé
            showGameOverScreen();
        }
    }//int seconds = (int) (System.currentTimeMillis() / 1000);
       // labelTimer.setText("Temps écoulé : " + seconds + " secondes");
       private void showGameOverScreen() {
           // Affiche l'écran Game Over

           if (!GameOver.isGameOverDisplayed()) {
               SwingUtilities.invokeLater(new Runnable() {
                   @Override
                   public void run() {
                       // Affiche l'écran Game Over
                       GameOver gameOver = new GameOver();
                   }
               });
               GameOver.setGameOverDisplayed(true);
           }
       }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainInterface mainInterface = showWelcomeScreen();
                mainInterface.setVisible(true);
            }
        });
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                hero.setOrientation(Orientation.LEFT);
                hero.setWalking(true);
                break;
            case KeyEvent.VK_RIGHT:
                hero.setOrientation(Orientation.RIGHT);
                hero.setWalking(true);
                break;
            case KeyEvent.VK_UP:
                hero.setOrientation(Orientation.UP);
                hero.setWalking(true);
                break;
            case KeyEvent.VK_DOWN:
                hero.setOrientation(Orientation.DOWN);
                hero.setWalking(true);
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.setWalking(false);
    }
}
