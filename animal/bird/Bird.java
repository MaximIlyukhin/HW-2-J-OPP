package animal.bird;

import animal.Animal;

public abstract class Bird extends Animal implements Fly {
    protected float flyingHeight;

    public Bird(float height, float weight, String eyeColor, float flyingHeight) {
        super(height, weight, eyeColor);
        this.flyingHeight = flyingHeight;
    }

    protected void showFly() {
        System.out.printf("Я лечу на %s метрах.", flyingHeight);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", \nВысота полёта - " + flyingHeight;
    }
}
