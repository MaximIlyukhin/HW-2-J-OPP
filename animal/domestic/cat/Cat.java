package animal.domestic.cat;

import java.time.LocalDate;

import animal.domestic.DomesticAnimal;

public class Cat extends DomesticAnimal {
    protected boolean presenceWool;

    public Cat(float height, float weight, String eyeColor, String nickname, String breed, String vaccination,
            String сoatСolor, LocalDate dateBirth, boolean presenceWool) {
        super(height, weight, eyeColor, nickname, breed, vaccination, сoatСolor, dateBirth);
        this.presenceWool = presenceWool;
    }

    public boolean isPresenceWool() {
        return presenceWool;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", \nНаличие шерсти -  " + presenceWool;
    }

    @Override
    public String getSound() {
        return "Мяу-мяу!";
    }

    @Override
    public String showAffection() {
        return "Мурлыкание!";
    }
}
