package manager;

import domain.enums.RequiredSubject;
import domain.model.Internship;
import domain.model.Student;
import domain.model.Supervisor;

public interface InternshipService {
    void addStudent(Student student);
    void assignSubjectToStudent(RequiredSubject subject, Student student);
    void addSupervisor(Supervisor supervisor);
    void assignStudentToSupervisor(Student student, Supervisor supervisor);
    void addInternship(Internship internship);
    Student findStudentById(String id);
    Supervisor findSupervisorById(String id);
    String getInternshipDetails(Student student);
    boolean validateStudentElegibility(Student student);
}