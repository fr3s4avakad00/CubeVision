import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CubeGame2 extends JPanel implements ActionListener {

    private int cubeSize; // size of the cube
    private JButton[][] cube; // cube initiated
    private int GuesX, GuesY, zeroX, zeroY; // Guesses && position of zero
    private int scoreDue; // score duetan
    private int scorePro; // score protan
    private int scoreTri; // score tritan
    private VisionType visionType; // Now we use VisionType abstraction for vision-related behavior
    private int r, g, b;
    private JPanel panel;
    private JFrame frame;
    private GameLoop gameLoop; // Reference to the GameLoop class\
    private soundPlayer soundPlayer;

    


    public CubeGame2() {
        createGameFrame();
        gameLoop = new GameLoop(this); // Initialize GameLoop
        resetGame(); // Start the game
    }

    public void createGameFrame() { // create the game window
        frame = new JFrame("CubeVision");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 6));
        frame.add(panel);
        frame.setVisible(true);

        try {
            soundPlayer = new soundPlayer("/Users/ask/Library/CloudStorage/OneDrive-Personal/03 Karthik/coding/Block/Jazz_Cube.wav");
        } catch (Exception e) {
            System.out.println("Error creating sound player: " + e.getMessage());
        }

        // Ensure that the sound stops when the frame is closed
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                soundPlayer.stopBackgroundSound();  // Stop the sound
            }
        });
    }

    public void resetGame() { // reset the game - main
        if (gameLoop.getRoundCount() <= 5) {
            visionType = new DuetanVision(); // Set to Duetan for rounds 1-5
        } else if (gameLoop.getRoundCount() <= 10) {
            visionType = new ProtanVision(); // Set to Protan for rounds 6-10
        } else {
            visionType = new TritanVision(); // Set to Tritan for rounds 11-15
        }

        System.out.println("Vision Type: " + visionType.getClass().getSimpleName());

        int max = 6;
        int min = 3;
        cubeSize = (int) (Math.random() * (max - min + 1)) + min;

        panel.removeAll();
        panel.setLayout(new GridLayout(cubeSize, cubeSize));

        int colorIndex = ((gameLoop.getRoundCount() - 1) % visionType.getRGB().length);
        r = visionType.getRGB()[colorIndex][0];
        g = visionType.getRGB()[colorIndex][1];
        b = visionType.getRGB()[colorIndex][2];

        System.out.println("r: " + r + " g: " + g + " b: " + b);

        initialize();

        zeroY = (int) (Math.random() * cubeSize);
        zeroX = (int) (Math.random() * cubeSize);

        // Set the color of the zero button using the modifyZeroColor method from the vision type
        cube[zeroX][zeroY].setBackground(visionType.modifyZeroColor(r, g, b));

        panel.revalidate();
        panel.repaint();
    }

    private void initialize() { // initialize the cube
        cube = new JButton[cubeSize][cubeSize];

        for (int i = 0; i < cubeSize; i++) { // initializing the cube to j buttons
            for (int j = 0; j < cubeSize; j++) {
                cube[i][j] = new JButton();
                cube[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
                cube[i][j].setPreferredSize(new Dimension(cubeSize * 10, cubeSize * 10)); // set the size of the cube
                cube[i][j].setLocation(50 + j * 60, 50 + i * 60);
                cube[i][j].setBackground(new Color(r, g, b)); // set the color of the cube
                cube[i][j].setOpaque(true);
                panel.add(cube[i][j]);
                cube[i][j].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { // action listener
        for (int i = 0; i < cubeSize; i++) {
            for (int j = 0; j < cubeSize; j++) {
                if (e.getSource() == cube[i][j]) {
                    setGuesX(i);
                    setGuesY(j);
                    System.out.println("Button clicked at row " + i + ", col " + j);
                    checkZero();
                    gameLoop.runGameLoop(); // Call the game loop
                    break;
                }
            }
        }
    }

    public void setGuesX(int x) {
        GuesX = x;
    }

    public void setGuesY(int y) {
        GuesY = y;
    }

    public boolean checkZero() {
        System.out.println("zeroX: " + zeroX + " zeroY: " + zeroY);
        if (cube[GuesY][GuesX] == cube[zeroY][zeroX] && visionType instanceof DuetanVision) {
            scoreDue++;
            return true;
        } else if (cube[GuesY][GuesX] == cube[zeroY][zeroX] && visionType instanceof ProtanVision) {
            scorePro++;
            return true;
        } else if (cube[GuesY][GuesX] == cube[zeroY][zeroX] && visionType instanceof TritanVision) {
            scoreTri++;
            return true;
        } else {
            return false;
        }
    }

    // Getters for scores and frame (used by GameLoop)
    public int getScoreDue() {
        return scoreDue;
    }

    public int getScorePro() {
        return scorePro;
    }

    public int getScoreTri() {
        return scoreTri;
    }

    public JFrame getFrame() {
        return frame;
    }
}
