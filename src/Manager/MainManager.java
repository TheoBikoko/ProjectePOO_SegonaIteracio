package Manager;

import Models.Internship.Internship;
import Models.Person.Student;
import Models.Person.Supervisor;
import Models.Subject;
import java.util.HashSet;

public class MainManager implements Manager {
    private static HashSet<Student> students = new HashSet<>();
    private static HashSet<Supervisor> supervisors = new HashSet<>();
    private static HashSet<Internship> internships = new HashSet<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void assignSubjectToStudent(Subject subject, Student student) {
        student.getSubjects().add(subject);
    }

    @Override
    public String reviewInternshipDetails(Student student) {
        return student.getDetailsInternship(student.getCurrentInternship());
    }

    @Override
    public void addSupervisor(Supervisor supervisor) {
        supervisors.add(supervisor);
    }

    @Override
    public void assignStudentToSupervisor(Student student, Supervisor supervisor) {
            if (student.isAvailableForInternship()){
                        supervisor.getAssignedStudents().add(student);
                    }
                }

    @Override
     public void addInternship(Internship internship) {
        internships.add(internship);
    }

    public static HashSet<Internship> getInternships() {
        return internships;
    }

    public static HashSet<Student> getStudents() {
        return students;
    }

    public static HashSet<Supervisor> getSupervisors() {
        return supervisors;
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
}
