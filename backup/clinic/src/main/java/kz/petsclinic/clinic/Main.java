package kz.petsclinic.clinic;

import kz.petsclinic.clinic.collection.PersonCollection;
import kz.petsclinic.clinic.controller.MainController;
import kz.petsclinic.clinic.emulatedUsers.Administrator;
import kz.petsclinic.clinic.emulatedUsers.User;

import java.util.concurrent.CountDownLatch;

/**
 * @author DK
 * @version 1.0.3
 */
public class Main {
    static Administrator admin;
    static User userOne;
    static User userTwo;
    public static StringBuilder log;
    public static CountDownLatch cld;
    public static void main(String[] args) throws InterruptedException {
        cld = new CountDownLatch(3);
        log = new StringBuilder("\n");
        PersonCollection clinic = new PersonCollection();
        MainController controller = new MainController(clinic);
        admin = new Administrator(controller);
        Thread adminTread = new Thread(admin);
        adminTread.start();
        userOne = new User(controller);
        Thread userOneThread = new Thread(userOne);
        userOneThread.start();
        userTwo = new User(controller);
        Thread userTwoThread = new Thread(userTwo);
        userTwoThread.start();
        Main.cld.await();
        System.out.println(log.toString());
    }
}