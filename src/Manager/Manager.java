package Manager;

import Models.Internship.Internship;
import Models.Person.Student;
import Models.Person.Supervisor;
import Models.Subject;

public interface Manager {
    void addStudent(Student student);

    void assignSubjectToStudent(Subject subject, Student student);

    String reviewInternshipDetails(Student student);

    void addSupervisor(Supervisor supervisor);

    void assignStudentToSupervisor(Student student, Supervisor supervisor);

    void addInternship(Internship internship);

    Student findStudentById(String id);

    Supervisor findSupervisorById(String id);

}
