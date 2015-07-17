package kz.petsclinic.clinic.pets;

/**
 * Птица унаследована от AbstractPet
 */
public class Bird extends AbstractPet {

    private static final String ABILITY = "Kill dogs";

    public Bird(final String nameOfPet) {
        super(nameOfPet, ABILITY);
    }
}
