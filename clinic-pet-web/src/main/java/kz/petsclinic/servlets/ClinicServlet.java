package kz.petsclinic.servlets;


import ru.lessons.lesson_6.Animal;
import ru.lessons.lesson_6.Dog;
import ru.lessons.lesson_6.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * сервлет клиники
 */
public class ClinicServlet extends HttpServlet {

    final List<Pet> pets = new CopyOnWriteArrayList<>();
    private String nameForFind;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>Clinic Pets</title>" +
                        "<style type=\"text/css\">" +
                        "   TABLE { " +
                        "    border : 1px solid black " +
                        "   }" +
                        "   TD { " +
                        "    border : 1px solid black " +
                        "   }" +
                        "  </style>" +
                        "</head>" +
                        "<body>" +
                        "     <form action='"+req.getContextPath()+"/' method='post'>" +
                        "         Name : <input type='text' name='name'>"+
                        "         Owner : <input type='text' name='owner'>"+
                        "         Age : <input type='text' name='age'>"+
                        "         <input type='submit' value='add new Pet'>"+
                        "     <form>"+
                        this.viewPets() +
                        "<br>" +
                        "<br>" +
                        "     <form action='"+req.getContextPath()+"/' method='post'>" +
                        "         Name : <input type='text' name='find'>"+
                        "         <input type='submit' value='findByPetName'>"+
                        "     <form>"+
                        this.findPets(nameForFind) +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("name").isEmpty() && !req.getParameter("age").isEmpty() && !req.getParameter("owner").isEmpty())
        this.pets.add(new Dog(new Animal(req.getParameter("name"), req.getParameter("owner"), Integer.parseInt(req.getParameter("age")))));
        if (!req.getParameter("find").isEmpty())
        this.nameForFind = req.getParameter("find");
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>All Pets:</p>");
        sb.append("<table>");
        sb.append("<tr><td>").append(" PET NAME: </td><td> PET OWNER: </td><td> PET AGE: </td></tr>");
        for (Pet pet : this.pets) {
            sb.append("<tr><td>").append(pet.getName()).append("</td><td>").append(pet.getOwner()).append("</td><td>").append(pet.getAge()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String findPets(String nameOfPet) {
        StringBuilder sb = new StringBuilder();
        boolean finded = false;
        if (!pets.isEmpty() && nameOfPet != null) {
            sb.append("<p>Pets found:</p>");
            sb.append("<table>");
            sb.append("<tr><td>").append(" PET NAME: </td><td> PET OWNER: </td><td> PET AGE: </td></tr>");
            for (Pet pet : this.pets) {
                if (nameOfPet.equals(pet.getName())) {
                    sb.append("<tr><td>").append(pet.getName()).append("</td><td>").append(pet.getOwner()).append("</td><td>").append(pet.getAge()).append("</td></tr>");
                    finded = true;
                }
            }
            sb.append("</table>");
        }
        if (!finded) {
            sb.delete(0, sb.capacity());
            sb.append("<p>Not Found</p>");
        }
        return sb.toString();
    }
}
