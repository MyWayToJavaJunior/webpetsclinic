package kz.petsclinic.clinic.controller;


import kz.petsclinic.clinic.inputoutput.IO;

/**
 * Контроллер - реализация взаимодействия
 * с пользователем
 */
public class UserController {

    private boolean on = true;
    private MainController controller;

    public UserController(final MainController controller) {
        this.controller = controller;
    }

    public void start() {
        while (on) {
            mainMenu();
        }
    }

    private void mainMenu() {
        IO.showMainMenu();
        String userChoice = IO.getUserChoice();
        switch (userChoice) {
            default:
            case "1":       viewAll();
                            break;
            case "2":       add();
                            break;
            case "3":       removeByName();
                            break;
            case "4":       renameByName();
                            break;
            case "5":       viewByPersonName();
                            break;
            case "6":       removeByPetName();
                            break;
            case "7":       renameByPetName();
                            break;
            case "8":       viewByPetName();
                            break;
            case "9":       break;
            case "0":       setOff();
                            break;
        }
    }

    private void viewByPetName() {
        IO.print(controller.getPersonByPetName(IO.askAndGetNameOfPet()));
    }

    private void renameByPetName() {
        String nameOfPet = IO.askAndGetNameOfPetForRename();
        if (controller.renamePet(nameOfPet, IO.askAndGetNewNameForPet()))
            IO.success();
        else IO.fail();
    }

    private void removeByPetName() {
        if (controller.removeByPetName(IO.askAndGetNameOfPetForRemoving()))
            IO.success();
        else IO.fail();
    }

    private void renameByName() {
        String nameOfPerson = IO.askAndGetNameOfPersonForRename();
        if (controller.renamePerson(nameOfPerson, IO.askAndGetNewNameForPerson()))
            IO.success();
        else IO.fail();
    }

    private void removeByName() {
        if (controller.removeByName(IO.askAndGetNameOfPersonForRemoving()))
            IO.success();
        else IO.fail();
    }

    private void viewByPersonName() {
        IO.print(controller.getPersonByName(IO.askAndGetNameOfPersonForView()));
    }

    private void add() {
        String nameForPerson = IO.askAndGetNewNameForPerson();
        String nameForPet = IO.askAndGetNameForPet();
        String typeOfPet = IO.askAndGetTypeForPet();
        if (controller.addPerson(nameForPerson, nameForPet, typeOfPet))
            IO.success();
        else IO.fail();
    }

    private void viewAll() {
        IO.print(controller.getAll());
    }

    private void setOff() {
        on = false;
    }
}
