package Models.Person;
import Models.*;
import Models.Internship.Internship;

import java.util.ArrayList;

public class Student extends Person{
private ArrayList<Subject> subjects;
private Internship currentInternship;
private boolean availableForInternship;
private boolean hirable;

    public Student(String id, String name, String surname) {
        super(id, name, surname);
        this.subjects = new ArrayList<>();
        this.availableForInternship = false;
        this.hirable = false;
    }

    public boolean hasPassedSubject(Subject subject){
        return !(subject.getGrade() < 5);
    }

    public String getDetailsInternship(Internship internship){
        return (currentInternship != null) ? currentInternship.getDetails() : "The student " + internship.getStudent().getName() + " " + internship.getStudent().getSurname() + " does not have assigned an internship yet.";
    }

    public Internship getCurrentInternship() {
        return currentInternship;
    }

    public boolean isAvailableForInternship() {
        for (Subject subject: subjects){
            if (!hasPassedSubject(subject)){
                return false;
            }
        }
        return true;
    }

    public boolean isHirable() {
        for (Subject subject: subjects){
            if (!hasPassedSubject(subject)){
             return false;
            }
        }
        return true;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "subjects=" + subjects +
                ", currentInternship=" + currentInternship +
                ", availableForInternship=" + availableForInternship +
                ", hirable=" + hirable +
                '}';
    }
}
