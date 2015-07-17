package kz.petsclinic.clinic.pets;

/**
 * Абстрактный класс, наследованием которого
 * реализуюется любой новый класс - животное
 */
public class AbstractPet {

    private String nameOfPet;

    private String abilityOfPet;

    public AbstractPet(final String nameOfPet, final String abilityOfPet) {
        this.nameOfPet = nameOfPet;
        this.abilityOfPet = abilityOfPet;
    }

    public String getNameOfPet() {
        return nameOfPet;
    }

    public void setNameOfPet(final String newNameOfPet) {
        this.nameOfPet = newNameOfPet;
    }

    @Override
    public String toString() {
        return "name of " + this.getClass().getSimpleName()  + ": " + nameOfPet + ", ability: " + abilityOfPet;
    }

}
