package animal.wild.tiger;

import java.time.LocalDate;
import animal.wild.WildAnimal;

public class Tiger extends WildAnimal {
    public Tiger(float height, float weight, String eyeColor, String habitat, LocalDate locationDate) {
        super(height, weight, eyeColor, habitat, locationDate);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getSound() {
        return "РРрррр!";
    }
}
