package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Person {
    private List<Student> assignedStudents;

    public Supervisor(String id, String name, String surname) {
        super(id, name, surname);
        this.assignedStudents = new ArrayList<>();
    }

    public void assignStudent(Student student) {
        assignedStudents.add(student);
    }

    public List<Student> getAssignedStudents() { return assignedStudents; }
}