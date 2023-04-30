package Model;

/**
 *
 * @author jumac
 */
public class Player {
    private int id;
    private String name;
    private int score;

    public Player(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

     public Player(String name) {
        this.name = name;
    }

    public Player() {
        
    }
     
    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }
    
    
    
}
