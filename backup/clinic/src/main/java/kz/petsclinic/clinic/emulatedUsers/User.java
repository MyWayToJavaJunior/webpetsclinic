package kz.petsclinic.clinic.emulatedUsers;

import kz.petsclinic.clinic.Main;
import kz.petsclinic.clinic.controller.MainController;

import java.util.Random;

import static kz.petsclinic.clinic.emulatedUsers.Generator.*;

/**
 * эмулирует работу Пользователей,
 * меняющих имена животных
 */
public class User implements Runnable{

    private MainController controller;
    private int failCount;

    public User(final MainController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        long timer = - System.currentTimeMillis();
        for (int i = 0; i < 520; i++) {
            String getPName = getPersonName();
            String getNewPName = getPersonName();
            if (controller.renamePerson(getPName, getNewPName) == false) {
                System.out.println("User operations: rename failed / Person name " + getPName + " not renamed to " +getNewPName);
                failCount++;
            } else System.out.println("User operations: successfully renamed / " + getPName + " to " +getNewPName);
            /*String getPName = getPersonName();
            if (controller.removeByName(getPName) == false) {
                System.out.println("User operations: remove failed / Pet name " + getPName);
                failCount++;
            }*/
            /*if (controller.renamePet(getPetName(), getPetName()) == false) {
                System.out.println("User operations: rename failed");
                failCount++;
            }*/
            System.out.println(controller.getAll());
            sleep();
        }
        timer += System.currentTimeMillis();
        Main.log.append("Passed: " + (timer) / 1000 + " sec (User)\n");
        Main.log.append("Operations failed: " + failCount + " times (User)\n");
        Main.cld.countDown();
    }

    private void sleep() {
        Random rand = new Random();
        try {
            Thread.sleep(rand.nextInt(4) * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
