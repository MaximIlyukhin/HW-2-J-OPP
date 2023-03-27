package animal.bird.chicken;

import animal.bird.Bird;

public class Chicken extends Bird {
    public Chicken(float height, float weight, String eyeColor, float flyingHeight) {
        super(height, weight, eyeColor, flyingHeight);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String fly() {
        return "Крылья подрезали, не могу летать";
    }

    @Override
    public String getSound() {
        return "КУКАРЕКАНЬЕ";
    }
}