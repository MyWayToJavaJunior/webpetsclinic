package kz.petsclinic.clinic.inputoutput;

import java.util.Scanner;

/**
 * Класс ввода-вывода
 */
public class IO {
    public static final String MSG_MAIN_MENU = "1 - view all | Person: 3 remove * 4 rename * 5 view |  0 - exit\n" +
            "2 - add      | Pet:    6 remove * 7 rename * 8 view |";
    private static final String MSG_NAME_ALREADY_USED = "Name already used!";
    private static final String MSG_CLINIC_IS_EMPTY = "Clinic is empty, add Persons ";

    private static final String ASK_NAME_OF_PERSON_FOR_REMOVING = "Pls, enter name of Person for removing";
    private static final String ASK_NAME_OF_PERSON_FOR_RENAME = "Pls, enter name of Person for rename";
    private static final String ASK_NEW_NAME_FOR_PERSON = "Pls enter new name for Person";
    private static final String ASK_NAME_OF_PERSON_FOR_VIEW = "Pls enter Person name for find and view";
    private static final String ASK_NAME_FOR_PET = "Pls enter name for Pet";
    private static final String ASK_TYPE_OF_PET = "Pls choose type of pet: 1 Cat / 2 Bird / 3 Dog";
    private static final String ASK_NAME_OF_PET_FOR_VIEW = "Pls enter Person name for find and view";
    private static final String ASK_NAME_OF_PET_FOR_REMOVING = "Pls, enter name of Pet for removing";
    private static final String ASK_NAME_OF_PET_FOR_RENAME = "Pls, enter name of Pet for rename";
    private static final String ASK_NEW_NAME_FOR_PET = "Pls enter new name for Pet";

    private static final String NOT_FOUND = "Not found!";
    private static final String MSG_OPERATION_COMPLETE = "Operation complete";
    private static final String MSG_OPERATION_FAILED = "Operation failed";


    public static void print(String stringToOutput) {
        System.out.println(stringToOutput);
    }

    public static void showMainMenu() {
        print(MSG_MAIN_MENU);
    }

    public static String getString() {
        String result;
        try (Scanner scanner = new Scanner(System.in)) {
            result = scanner.nextLine();
        }
        return result;
    }

    public static void notFound() {
        print(NOT_FOUND);
    }

    public static void personRemoved(String removedPerson) {
        print("Removed: " + removedPerson);
    }

    public static void personRenamed(String removedPet) {
        print("Renamed " + removedPet);
    }

    public static void nameAlreadyUsed() {
        print(MSG_NAME_ALREADY_USED);
    }

    public static String askAndGetTypeForPet() {
        print(ASK_TYPE_OF_PET);
        return getString();
    }

    public static String getUserChoice() {
        return getString();
    }

    public static String askAndGetNameOfPet() {
        print(ASK_NAME_OF_PET_FOR_VIEW);
        return getString();
    }

    public static String askAndGetNameOfPetForRemoving() {
        print(ASK_NAME_OF_PET_FOR_REMOVING);
        return getString();
    }

    public static String askAndGetNameOfPetForRename() {
        print(ASK_NAME_OF_PET_FOR_RENAME);
        return getString();
    }

    public static String askAndGetNameOfPersonForView() {
        print(ASK_NAME_OF_PERSON_FOR_VIEW);
        return getString();
    }

    public static String askAndGetNameOfPersonForRemoving() {
        print(ASK_NAME_OF_PERSON_FOR_REMOVING);
        return getString();
    }

    public static String askAndGetNameOfPersonForRename() {
        print(ASK_NAME_OF_PERSON_FOR_RENAME);
        return getString();
    }

    public static String askAndGetNewNameForPerson() {
        print(ASK_NEW_NAME_FOR_PERSON);
        return getString();
    }

    public static String askAndGetNameForPet() {
        print(ASK_NAME_FOR_PET);
        return getString();
    }

    public static String askAndGetNewNameForPet() {
        print(ASK_NEW_NAME_FOR_PET);
        return getString();
    }

    public static void clinicIsEmpty() {
        print(MSG_CLINIC_IS_EMPTY);
    }

    public static void success() {
        print(MSG_OPERATION_COMPLETE);
    }

    public static void fail() {
        print(MSG_OPERATION_FAILED);
    }
}
