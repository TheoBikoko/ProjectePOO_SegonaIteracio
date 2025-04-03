package Models.Internship;

import Models.Person.Student;
import Models.Person.Supervisor;

public abstract class Internship {
    protected Student student;
    protected Supervisor supervisor;
    protected String company;


    public Internship(Student student, Supervisor supervisor, String company) {
        this.student = student;
        this.supervisor = supervisor;
        this.company = company;
    }

    public Internship(Supervisor supervisor, String company) {
        this.supervisor = supervisor;
        this.company = company;
    }

    public abstract String getDetails();

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Classes.Internship.Classes.Internship{" +
                "student=" + student +
                ", supervisor=" + supervisor +
                '}';
    }

}
