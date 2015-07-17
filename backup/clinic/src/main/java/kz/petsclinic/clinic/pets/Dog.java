package kz.petsclinic.clinic.pets;

/**
 * Собака унаследована от AbstractPet
 */
public class Dog extends AbstractPet {

    private static final String ABILITY = "Kill cats";

    public Dog(final String nameOfPet) {
        super(nameOfPet, ABILITY);
    }
}
