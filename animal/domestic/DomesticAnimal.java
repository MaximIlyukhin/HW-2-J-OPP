package animal.domestic;

import java.time.LocalDate;

import animal.Animal;

public abstract class DomesticAnimal extends Animal implements ShowAffection {
    protected String nickname;
    protected String breed;
    protected String vaccination;
    protected String сoatСolor;
    protected LocalDate dateBirth;

    public DomesticAnimal(float height, float weight, String eyeColor, String nickname, String breed,
            String vaccination, String сoatСolor, LocalDate dateBirth) {
        super(height, weight, eyeColor);
        this.nickname = nickname;
        this.breed = breed;
        this.vaccination = vaccination;
        this.сoatСolor = сoatСolor;
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", \nКличка - " + nickname +
                ", \nПорода - " + breed +
                ", \nНаличие прививок - " + vaccination +
                ", \nЦвет шерсти - " + сoatСolor +
                ", \nДата рождения -  " + dateBirth;
    }
}
