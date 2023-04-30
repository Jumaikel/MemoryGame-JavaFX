
package Model;

/**
 *
 * @author jumac
 */
public class Game {
    
    private String difficulty;
    private int playersAmount;

    public Game() {
        difficulty = "Facil";
        playersAmount = 1;
    }
    

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setPlayersAmount(int playersAmount) {
        this.playersAmount = playersAmount;
    }

    public int getPlayersAmount() {
        return playersAmount;
    }
    
}
