package animal.wild;

import java.time.LocalDate;
import animal.Animal;

public abstract class WildAnimal extends Animal {
    protected String habitat;
    protected LocalDate locationDate;

    public WildAnimal(float height, float weight, String eyeColor, String habitat, LocalDate locationDate) {
        super(height, weight, eyeColor);
        this.habitat = habitat;
        this.locationDate = locationDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", \nМесто обитания - " + habitat +
                ", \nДата нахождения -  " + locationDate;
    }
}
