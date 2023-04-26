package Model;

/**
 *
 * @author jumac
 */

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Card {
    private int id;
    private boolean cardSide;
    private Image front;
    private Image back;

    public Card() {
        
    }
    
    public Card(Image front) {
        this.front = front;
    }
    
    public Card(int id, Image front, Image back) {
        this.id = id;
        this.front = front;
        this.back = back;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCardSide(boolean cardSide) {
        this.cardSide = cardSide;
    }

    public void setFront(Image front) {
        this.front = front;
    }

    public void setBack(Image back) {
        this.back = back;
    }

    public int getId() {
        return id;
    }

    public boolean isCardSide() {
        return cardSide;
    }

    public Image getFront() {
        return front;
    }

    public Image getBack() {
        return back;
    }
    
    
    
}
