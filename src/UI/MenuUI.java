package UI;

import Manager.MainManager;
import Manager.ManagerImplemented;
import Models.Internship.ErasmusInternship;
import Models.Internship.Internship;
import Models.Internship.NationalInternship;
import Models.Person.Student;
import Models.Person.Supervisor;
import Models.Subject;

import java.util.Scanner;

public class MenuUI {
    private MainMenu mainMenu;
    private InternshipUI internshipUI;
    private SupervisorUI supervisorUI;
    private StudentUI studentUI;
    static MainManager mainManager;
    static ManagerImplemented managerImplemented;

    public MenuUI() {
        mainMenu = new MainMenu();
        internshipUI = new InternshipUI();
        supervisorUI = new SupervisorUI();
        studentUI = new StudentUI();
    }

    public static void main(String[] args) {
        MenuUI menuUI = new MenuUI();
        boolean running = true;

        while (running){
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to our Internship Service for IES Poblenou. Please select one of the following options: ");
            menuUI.mainMenu.mainDisplay();
            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                    menuUI.mainMenu.studentManager();
                    menuUI.studentUI.mainDisplay();
                    switch (input.nextInt()){
                        case 1:
                            input.nextLine();
                            System.out.print("Enter student ID: ");
                            String id = input.nextLine();
                            System.out.print("Enter student name: ");
                            String name = input.nextLine();
                            System.out.print("Enter student surname: ");
                            String surname = input.nextLine();

                            managerImplemented.addStudent(new Student(id, name, surname));

                            System.out.println("Student has been added.");
                            break;

                        case 2:
                            input.nextLine();
                            System.out.print("Enter student ID: ");
                             id = input.nextLine();
                             managerImplemented.findStudentById(id);

                            System.out.print("Enter the subject name: ");
                             String subjectName = input.nextLine();
                            System.out.print("Enter the subject grade: ");
                            float subjectGrade = input.nextFloat();
                            input.nextLine();

                            managerImplemented.assignSubjectToStudent(new Subject(subjectName, subjectGrade), managerImplemented.findStudentById(id));
                            System.out.println("Subject has been added.");
                            break;

                        case 3:
                            input.nextLine();
                            System.out.print("Enter student ID: ");
                            id = input.nextLine();
                            managerImplemented.reviewInternshipDetails(managerImplemented.findStudentById(id));
                            break;

                        case 4:
                            input.nextLine();
                            System.out.println("Returning to the main menu...");
                            break;
                    }
                    break;

                case 2:
                    menuUI.mainMenu.supervisorManager();
                    menuUI.supervisorUI.mainDisplay();
                    switch (input.nextInt()){
                        case 1:
                            input.nextLine();
                            System.out.print("Enter supervisor ID: ");
                            String id = input.nextLine();
                            System.out.print("Enter supervisor name: ");
                            String name = input.nextLine();
                            System.out.print("Enter supervisor surname: ");
                            String surname = input.nextLine();

                            managerImplemented.addSupervisor(new Supervisor(id, name, surname));

                            System.out.println("Supervisor has been added.");
                            break;

                        case 2:
                            input.nextLine();
                            System.out.print("Enter student ID: ");
                            String idStudent = input.nextLine();
                            System.out.print("Enter supervisor ID: ");
                            String idSupervisor = input.nextLine();


                            managerImplemented.assignStudentToSupervisor(managerImplemented.findStudentById(idStudent), managerImplemented.findSupervisorById(idSupervisor));
                            System.out.println("The student has been assigned to the supervisor.");
                            break;

                        case 3:
                            input.nextLine();
                            System.out.println("Returning to the main menu...");
                            break;
                    }
                    break;

                case 3:
                    menuUI.mainMenu.internshipManager();
                    menuUI.internshipUI.mainDisplay();
                    switch (input.nextInt()){
                        case 1:
                            input.nextLine();
                            System.out.print("Enter student ID: ");
                            String idStudent = input.nextLine();
                            System.out.print("Enter supervisor ID: ");
                            String idSupervisor = input.nextLine();
                            System.out.print("Enter company name: ");
                            String company = input.nextLine();

                            Student student = managerImplemented.findStudentById(idStudent);
                            Supervisor supervisor = managerImplemented.findSupervisorById(idSupervisor);

                            menuUI.internshipUI.InternshipType();
                            switch (input.nextInt()){
                                case 1:
                                    menuUI.internshipUI.InternshipModality();
                                    switch (input.nextInt()){
                                        case 1:
                                            managerImplemented.addInternship(new NationalInternship(supervisor, company, NationalInternship.Type.INTENSIVE));
                                            break;
                                        case 2:
                                            managerImplemented.addInternship(new NationalInternship(supervisor, company, NationalInternship.Type.DUAL));
                                            break;
                                        case 3:
                                            System.out.println("Canceling operation...");
                                            break;
                                    }
                                case 2:
                                    System.out.println("Please indicate the country: ");
                                    String country = input.nextLine();

                                    managerImplemented.addInternship(new ErasmusInternship(supervisor, company, country));
                            }

                            System.out.println("Supervisor has been added.");
                            break;

                        case 2:
                            input.nextLine();
                            System.out.print("Enter student ID: ");
                             idStudent = input.nextLine();
                            System.out.print("Enter supervisor ID: ");
                             idSupervisor = input.nextLine();


                            managerImplemented.assignStudentToSupervisor(managerImplemented.findStudentById(idStudent), managerImplemented.findSupervisorById(idSupervisor));
                            System.out.println("The student has been assigned to the supervisor.");
                            break;

                        case 3:
                            input.nextLine();
                            System.out.println("Returning to the main menu...");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our services.");
                    running = false;
                    break;
            }
        }
    }
}
