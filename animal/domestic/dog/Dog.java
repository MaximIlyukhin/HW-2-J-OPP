package animal.domestic.dog;

import java.time.LocalDate;

import animal.domestic.DomesticAnimal;

public class Dog extends DomesticAnimal implements Train {
    protected boolean availabilityTraining;

    public Dog(float height, float weight, String eyeColor, String nickname, String breed, String vaccination,
            String сoatСolor, LocalDate dateBirth, boolean availabilityTraining) {
        super(height, weight, eyeColor, nickname, breed, vaccination, сoatСolor, dateBirth);
        this.availabilityTraining = availabilityTraining;
    }

    public boolean isAvailabilityTraining() {
        return availabilityTraining;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", \nНаличие дрессировки -  " + availabilityTraining;
    }

    @Override
    public String getSound() {
        return "Гав-гав!";
    }

    @Override
    public String showAffection() {
        return "Виляет хвостом";
    }

    @Override
    public String train() {
        return "Дрессировка";
    }
}