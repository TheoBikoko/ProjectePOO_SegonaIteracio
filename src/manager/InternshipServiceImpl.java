package manager;

import domain.enums.RequiredSubject;
import domain.model.*;
import java.util.ArrayList;
import java.util.List;

public class InternshipServiceImpl implements InternshipService {
    private List<Student> students = new ArrayList<>();
    private List<Supervisor> supervisors = new ArrayList<>();
    private List<Internship> internships = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void addSupervisor(Supervisor supervisor) {
        supervisors.add(supervisor);
    }

    @Override
    public void addInternship(Internship internship) {
        internships.add(internship);
        internship.getStudent().setCurrentInternship(internship);
    }

    @Override
    public void assignSubjectToStudent(RequiredSubject subject, Student student) {
        student.assignSubject(subject);
    }

    @Override
    public void assignStudentToSupervisor(Student student, Supervisor supervisor) {
        supervisor.assignStudent(student);
    }

    @Override
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Supervisor findSupervisorById(String id) {
        for (Supervisor supervisor : supervisors) {
            if (supervisor.getId().equals(id)) {
                return supervisor;
            }
        }
        return null;
    }

    @Override
    public String getInternshipDetails(Student student) {
        Internship internship = student.getCurrentInternship();
        return internship != null ? internship.getDetails() : "No internship assigned";
    }

    @Override
    public boolean validateStudentElegibility(Student student) {
        return student.isEligibleForInternship();
    }
}