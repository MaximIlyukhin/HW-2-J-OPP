package animal.bird.stork;
import animal.bird.Bird;

public class Stork extends Bird {
    public Stork(float height, float weight, String eyeColor, float flyingHeight) {
        super(height, weight, eyeColor, flyingHeight);
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public String fly() {
        return "Умею летать";
    }
    @Override
    public String getSound() {
        return "Ого-го!";
    }
    
}
