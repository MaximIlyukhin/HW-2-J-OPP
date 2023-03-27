package animal.wild.wolf;

import java.time.LocalDate;
import animal.wild.WildAnimal;

public class Wolf extends WildAnimal {
    protected boolean leader;

    public Wolf(float height, float weight, String eyeColor, String habitat, LocalDate locationDate, boolean leader) {
        super(height, weight, eyeColor, habitat, locationDate);
        this.leader = leader;
    }

    public boolean isLeader() {
        return leader;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", \nВожак стаи -  " + leader;
    }

    @Override
    public String getSound() {
        return "Вуууу";
    }
}
