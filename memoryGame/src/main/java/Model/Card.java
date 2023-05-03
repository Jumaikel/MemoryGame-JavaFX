package Model;

/**
 *
 * @author jumac
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card extends ImageView {
    private int value;
    private Image front;
    private Image back;
    private boolean flipped;
    private boolean foundCouple;

    public Card() {
        
    }

    public Card(int value, Image backImage, Image frontImage) {
        this.value = value;
        this.back = backImage;
        this.front = frontImage;
        this.flipped = false;
        setImage(back);
        this.foundCouple = false;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setFront(Image front) {
        this.front = front;
    }

    public void setBack(Image back) {
        this.back = back;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    public void setFoundCouple(boolean foundCouple) {
        this.foundCouple = foundCouple;
    }

    public Image getFront() {
        return front;
    }

    public Image getBack() {
        return back;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public boolean isFoundCouple() {
        return foundCouple;
    }

    public void flip() {
        if (flipped) {
            setImage(back);
        } else {
            setImage(front);
        }
        flipped = !flipped;
    }
    

    public static boolean isSMOOTH_DEFAULT() {
        return SMOOTH_DEFAULT;
    }

    public static double getBASELINE_OFFSET_SAME_AS_HEIGHT() {
        return BASELINE_OFFSET_SAME_AS_HEIGHT;
    }

    @Override
    public String toString() {
        return "Card{" + "front=" + front + ", back=" + back + ", flipped=" + flipped + '}';
    }

    public int getValue() {
        return value; 
    }

 
}

