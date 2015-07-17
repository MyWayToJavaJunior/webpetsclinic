package kz.petsclinic.clinic.pets;

/**
 * Кот унаследован от AbstractPet
 */
public class Cat extends AbstractPet {

    private static final String ABILITY = "Kill birds";

    public Cat(final String nameOfPet) {
        super(nameOfPet, ABILITY);
    }
}
