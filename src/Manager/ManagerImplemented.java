package Manager;

import Models.Internship.Internship;
import Models.Person.Person;
import Models.Person.Student;
import Models.Person.Supervisor;
import Models.Subject;

public class ManagerImplemented {
    Manager manager;

    public ManagerImplemented(Manager manager) {
        this.manager = manager;
    }

    public void addStudent(Student student) {
        manager.addStudent(student);
    }

    public void assignSubjectToStudent(Subject subject, Student student) {
        manager.assignSubjectToStudent(subject, student);
    }

    public String reviewInternshipDetails(Student student) {
        return manager.reviewInternshipDetails(student);
    }

    public void addSupervisor(Supervisor supervisor) {
        manager.addSupervisor(supervisor);
    }

    public void assignStudentToSupervisor(Student student, Supervisor supervisor) {
        manager.assignStudentToSupervisor(student, supervisor);
    }

    public void addInternship(Internship internship) {
        manager.addInternship(internship);
    }

    public Student findStudentById(String id) {
        return (Student) manager.findStudentById(id);
    }

    public Supervisor findSupervisorById(String id) {
        return (Supervisor) manager.findSupervisorById(id);
    }
}
