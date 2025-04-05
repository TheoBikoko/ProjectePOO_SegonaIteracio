import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import manager.*;
import domain.enums.ErasmusCountry;
import domain.enums.RequiredSubject;
import domain.model.*;

import static org.junit.jupiter.api.Assertions.*;

class InternshipManagerTest {
    private InternshipManager manager;
    private InternshipService service;
    private Student testStudent;
    private Supervisor testSupervisor;

    @BeforeEach
    void initialize() {
        service = new InternshipServiceImpl();
        manager = new InternshipManager(service);

        testStudent = new Student("1", "Marti", "Serra", 2026);
        testSupervisor = new Supervisor("S1", "Jordi", "Divison");

        manager.addStudent(testStudent);
        manager.addSupervisor(testSupervisor);
    }

    @Test
    void testAddStudent() {
        Student found = manager.findStudentById("1");
        assertNotNull(found);
        assertEquals("Marti", found.getName());
    }

    @Test
    void testAddSupervisor() {
        Supervisor found = manager.findSupervisorById("S1");
        assertNotNull(found);
        assertEquals("Jordi", found.getName());
    }

    @Test
    void testAssignSubject() {
        RequiredSubject subject = new RequiredSubject("Math", 8.5f);
        manager.assignSubjectToStudent(subject, testStudent);
        assertEquals(1, testStudent.getSubjects().size());
    }

    @Test
    void testAddValidInternship() {
        manager.assignSubjectToStudent(new RequiredSubject("Math", 6.0f), testStudent);

        NationalInternship internship = new NationalInternship(
                testStudent, testSupervisor, "Tech Corp", NationalInternship.Type.INTENSIVE);

        manager.addInternship(internship);
        assertNotNull(testStudent.getCurrentInternship());
    }

    @Test
    void testErasmusInternship() {
        manager.assignSubjectToStudent(new RequiredSubject("Math", 6.0f), testStudent);

        ErasmusInternship internship = new ErasmusInternship(
                testStudent, testSupervisor, "Euro Corp", ErasmusCountry.FRANCE);

        manager.addInternship(internship);
        assertNotNull(testStudent.getCurrentInternship());
    }

    @Test
    void testAssignStudentToSupervisor() {
        manager.assignSubjectToStudent(new RequiredSubject("Math", 6.0f), testStudent);
        manager.assignStudentToSupervisor(testStudent, testSupervisor);
        assertEquals(1, testSupervisor.getAssignedStudents().size());
    }
}