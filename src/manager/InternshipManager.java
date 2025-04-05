package manager;

import domain.enums.RequiredSubject;
import domain.model.*;

public class InternshipManager {
    private final InternshipService service;

    public InternshipManager(InternshipService service) {
        this.service = service;
    }

    public void addStudent(Student student) {
        service.addStudent(student);
    }

    public void addSupervisor(Supervisor supervisor) {
        service.addSupervisor(supervisor);
    }

    public void addInternship(Internship internship) {
        if (service.validateStudentElegibility(internship.getStudent())) {
            service.addInternship(internship);
        }
    }

    public void assignSubjectToStudent(RequiredSubject subject, Student student) {
        service.assignSubjectToStudent(subject, student);
    }

    public void assignStudentToSupervisor(Student student, Supervisor supervisor) {
        if (service.validateStudentElegibility(student)) {
            service.assignStudentToSupervisor(student, supervisor);
        }
    }

    public Student findStudentById(String id) {
        return service.findStudentById(id);
    }

    public Supervisor findSupervisorById(String id) {
        return service.findSupervisorById(id);
    }

    public String getInternshipDetails(Student student) {
        return service.getInternshipDetails(student);
    }
}