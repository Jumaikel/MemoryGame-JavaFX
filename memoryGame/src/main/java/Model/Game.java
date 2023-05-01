
package Model;

/**
 *
 * @author jumac
 */
public class Game {
    
    private String difficulty;
    private int playersAmount;
    private boolean reviewMode;
    private boolean wildcards;

    public Game() {
        difficulty = "Facil";
        playersAmount = 1;
        reviewMode = false;
        wildcards = false;
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

    public void setReviewMode(boolean reviewMode) {
        this.reviewMode = reviewMode;
    }

    public boolean isReviewMode() {
        return reviewMode;
    }

    public void setWildcards(boolean wildcards) {
        this.wildcards = wildcards;
    }

    public boolean isWildcards() {
        return wildcards;
    }
    
}
