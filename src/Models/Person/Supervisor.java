package Models.Person;

import java.util.ArrayList;

public class Supervisor extends Person{
   private ArrayList<Student> assignedStudents;

    public Supervisor(String id, String name, String surname) {
        super(id, name, surname);
        this.assignedStudents = new ArrayList<>();
    }

    public ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }
        }
