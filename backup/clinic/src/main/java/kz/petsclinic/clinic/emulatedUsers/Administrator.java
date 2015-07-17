package kz.petsclinic.clinic.emulatedUsers;

import kz.petsclinic.clinic.Main;
import kz.petsclinic.clinic.controller.MainController;

import java.util.Random;

import static kz.petsclinic.clinic.emulatedUsers.Generator.*;

/**
 * эмулирует работу Администратора,
 * добавляющего записи в клинику
 */
public class Administrator implements Runnable{

    private MainController controller;
    private int failCount;

    public Administrator(final MainController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        long timer = - System.currentTimeMillis();
        for (int i = 0; i < 520; i++) {
            String getPName = getPersonName();
            if (controller.addPerson(getPName, getPetName() , getPetType()) == false) {
                System.out.println("Administrator operations: add failed / name " + getPName);
                failCount++;
            }
            sleep();
            getPName = getPersonName();
            if (controller.removeByName(getPName) == false) {
                System.out.println("Administrator operations: remove failed / name " + getPName);
                failCount++;
            }
            System.out.println(controller.getAll());
            sleep();
        }
        timer += System.currentTimeMillis();
        Main.log.append("Passed: " +  (timer)/1000 + " sec (Administrator)\n" );
        Main.log.append("Operations failed: " + failCount + " times (Administrator)\n");
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
