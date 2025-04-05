package domain.ui;

import domain.enums.ErasmusCountry;
import domain.enums.RequiredSubject;
import domain.model.*;
import manager.InternshipManager;
import manager.InternshipService;
import manager.InternshipServiceImpl;
import domain.ui.Components.*;
import java.util.Scanner;

public class MenuController {
    private final InternshipManager manager;
    private final Scanner scanner;
    private final MainMenuUI mainMenuUI;
    private final StudentUI studentUI;
    private final SupervisorUI supervisorUI;
    private final InternshipUI internshipUI;

    public MenuController() {
        InternshipService service = new InternshipServiceImpl();
        this.manager = new InternshipManager(service);
        this.scanner = new Scanner(System.in);
        this.mainMenuUI = new MainMenuUI();
        this.studentUI = new StudentUI();
        this.supervisorUI = new SupervisorUI();
        this.internshipUI = new InternshipUI();
    }

    public void start() {
        mainMenuUI.showWelcome();
        boolean running = true;

        while (running) {
            mainMenuUI.display();
            int choice = getIntInput();

            switch (choice) {
                case 1 -> handleStudentMenu();
                case 2 -> handleSupervisorMenu();
                case 3 -> handleInternshipMenu();
                case 4 -> running = false;
                default -> mainMenuUI.showInvalidOption();
            }
        }
        mainMenuUI.showExit();
        scanner.close();
    }

    private void handleStudentMenu() {
        boolean inMenu = true;
        while (inMenu) {
            studentUI.display();
            int choice = getIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> assignSubject();
                case 3 -> viewInternshipDetails();
                case 4 -> inMenu = false;
                default -> mainMenuUI.showInvalidOption();
            }
        }
    }

    private void addStudent() {
        studentUI.promptId();
        String id = scanner.nextLine();
        studentUI.promptName();
        String name = scanner.nextLine();
        studentUI.promptSurname();
        String surname = scanner.nextLine();
        studentUI.promptPromotionYear();
        int year = getIntInput();
        scanner.nextLine();

        Student student = new Student(id, name, surname, year);
        manager.addStudent(student);
        studentUI.showSuccess("Student added successfully");
    }

    private void assignSubject() {
        studentUI.promptId();
        String id = scanner.nextLine();
        Student student = manager.findStudentById(id);

        if (student == null) {
            studentUI.showError("Student not found");
            return;
        }

        studentUI.promptSubjectName();
        String name = scanner.nextLine();
        studentUI.promptSubjectGrade();
        float grade = getFloatInput();
        scanner.nextLine();

        RequiredSubject subject = new RequiredSubject(name, grade);
        manager.assignSubjectToStudent(subject, student);
        studentUI.showSuccess("Subject assigned successfully");
    }

    private void viewInternshipDetails() {
        studentUI.promptId();
        String id = scanner.nextLine();
        Student student = manager.findStudentById(id);

        if (student == null) {
            studentUI.showError("Student not found");
            return;
        }

        String details = manager.getInternshipDetails(student);
        studentUI.showDetails(details);
    }

    private void handleSupervisorMenu() {
        boolean inMenu = true;
        while (inMenu) {
            supervisorUI.display();
            int choice = getIntInput();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addSupervisor();
                case 2 -> assignStudentToSupervisor();
                case 3 -> inMenu = false;
                default -> mainMenuUI.showInvalidOption();
            }
        }
    }

    private void addSupervisor() {
        supervisorUI.promptId();
        String id = scanner.nextLine();
        supervisorUI.promptName();
        String name = scanner.nextLine();
        supervisorUI.promptSurname();
        String surname = scanner.nextLine();

        Supervisor supervisor = new Supervisor(id, name, surname);
        manager.addSupervisor(supervisor);
        supervisorUI.showSuccess("Supervisor added successfully");
    }

    private void assignStudentToSupervisor() {
        supervisorUI.promptStudentId();
        String studentId = scanner.nextLine();
        Student student = manager.findStudentById(studentId);

        if (student == null) {
            supervisorUI.showError("Student not found");
            return;
        }

        supervisorUI.promptId();
        String supervisorId = scanner.nextLine();
        Supervisor supervisor = manager.findSupervisorById(supervisorId);

        if (supervisor == null) {
            supervisorUI.showError("Supervisor not found");
            return;
        }

        manager.assignStudentToSupervisor(student, supervisor);
        supervisorUI.showSuccess("Student assigned to supervisor successfully");
    }

    private void handleInternshipMenu() {
        boolean inMenu = true;
        while (inMenu) {
            internshipUI.display();
            int choice = getIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addInternship();
                case 2 -> viewInternshipDetails();
                case 3 -> inMenu = false;
                default -> mainMenuUI.showInvalidOption();
            }
        }
    }

    private void addInternship() {
        internshipUI.displayTypeMenu();
        int typeChoice = getIntInput();
        scanner.nextLine();

        if (typeChoice == 3) return;

        internshipUI.promptStudentId();
        String studentId = scanner.nextLine();
        Student student = manager.findStudentById(studentId);

        if (student == null) {
            internshipUI.showError("Student not found");
            return;
        }

        internshipUI.promptSupervisorId();
        String supervisorId = scanner.nextLine();
        Supervisor supervisor = manager.findSupervisorById(supervisorId);

        if (supervisor == null) {
            internshipUI.showError("Supervisor not found");
            return;
        }

        internshipUI.promptCompany();
        String company = scanner.nextLine();

        if (typeChoice == 1) {
            internshipUI.displayNationalTypeMenu();
            int nationalType = getIntInput();
            scanner.nextLine();

            if (nationalType == 3) return;

            NationalInternship.Type type = nationalType == 1 ?
                    NationalInternship.Type.INTENSIVE : NationalInternship.Type.DUAL;

            NationalInternship internship = new NationalInternship(
                    student, supervisor, company, type);
            manager.addInternship(internship);
            internshipUI.showSuccess("National internship added successfully");
        }
        else if (typeChoice == 2) {
            internshipUI.promptCountry();
            String countryName = scanner.nextLine().toUpperCase();

            try {
                ErasmusCountry country = ErasmusCountry.valueOf(countryName);
                ErasmusInternship internship = new ErasmusInternship(
                        student, supervisor, company, country);
                manager.addInternship(internship);
                internshipUI.showSuccess("Erasmus internship added successfully");
            } catch (IllegalArgumentException e) {
                internshipUI.showError("Invalid country");
            }
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        return input;
    }

    private float getFloatInput() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        float input = scanner.nextFloat();
        return input;
    }

    public static void main(String[] args) {
        new MenuController().start();
    }
}