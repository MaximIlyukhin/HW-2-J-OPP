package animal;

public abstract class Animal {
    protected float height;
    protected float weight;
    protected String eyeColor;

    public Animal(float height, float weight, String eyeColor) {
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

    @Override
    public String toString() {
        return "Вид животного - " + this.getClass() +
                "\nрост животного - " + height +
                ", \nвес животного - " + weight +
                ", \nцвет глаз животного - " + eyeColor;
    }

    public abstract String getSound();
}
