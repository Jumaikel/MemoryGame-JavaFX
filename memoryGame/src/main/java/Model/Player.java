package Model;

/**
 *
 * @author jumac
 */
public class Player {
    private int id;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
}
