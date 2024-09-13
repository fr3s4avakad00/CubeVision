import javax.swing.*;

public class GameLoop {
    private CubeGame2 game; // Reference to CubeGame2
    private int roundCount;

    public GameLoop(CubeGame2 game) {
        this.game = game;
        this.roundCount = 1; // Start at round 1
    }

    public void runGameLoop() {
        roundCount++;
        if (roundCount <= 15) {
            game.resetGame(); // Move to the next round
        } else {
            checkFinalScore(); // Handle game completion
        }
    }

    // Getter for roundCount
    public int getRoundCount() {
        return roundCount;
    }

    // Check the final score and display the appropriate message
    private void checkFinalScore() {
        String message = "";
    
        if (game.getScoreDue() <= 1 && game.getScorePro() <= 1 && game.getScoreTri() <= 1) {
            message = "Maaan YOU NEED Help";
        } else if (game.getScoreDue() > 4 && game.getScorePro() > 4 && game.getScoreTri() > 4) {
            message = "You are a perfect cube!"  + "\n" + "... Wait no you got a perfect score!";
        } else {
            if (game.getScoreDue() <= 2) {
                message = "You Might Have Deuteranopia";
            } else if (game.getScoreDue() > 2 && game.getScoreDue() <= 4) {
                message = "You Might Have Deuteranomaly";
            } else if (game.getScorePro() <= 2) {
                message = "You Might Have Proteranopia";
            } else if (game.getScorePro() > 2 && game.getScorePro() <= 4) {
                message = "You Might Have Proteranomaly";
            } else if (game.getScoreTri() <= 2) {
                message = "You Might Have Tritanopia";
            } else if (game.getScoreTri() > 2 && game.getScoreTri() <= 4) {
                message = "You Might Have Tritanomaly";
            }
        }
    
        // Display the final message and dispose of the game frame
        JOptionPane.showMessageDialog(game.getFrame(), message);
        game.getFrame().dispose();
    }
    
}
