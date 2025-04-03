package UI;

import Manager.MainManager;
import Manager.ManagerImplemented;
import Models.Internship.Country;
import Models.Internship.ErasmusInternship;
import Models.Internship.NationalInternship;
import Models.Person.Student;
import Models.Person.Supervisor;
import Models.Subject;
import java.util.Scanner;

public class MenuUI {
    private MainMenuUI mainMenuUI;
    private InternshipUI internshipUI;
    private SupervisorUI supervisorUI;
    private StudentUI studentUI;

    public MenuUI() {
        mainMenuUI = new MainMenuUI();
        internshipUI = new InternshipUI();
        supervisorUI = new SupervisorUI();
        studentUI = new StudentUI();
    }

    public static void main(String[] args) {
        ManagerImplemented managerImplemented = new ManagerImplemented(new MainManager());
        MenuUI menuUI = new MenuUI();
        boolean running = true;

        while (running){
            Scanner input = new Scanner(System.in);
            menuUI.mainMenuUI.welcome();
            menuUI.mainMenuUI.mainDisplay();
            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                    menuUI.mainMenuUI.studentManager();
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
                            Student student = managerImplemented.findStudentById(id);

                            managerImplemented.assignSubjectToStudent(new Subject(subjectName, subjectGrade), student);
                            System.out.println("Subject has been added.");
                            break;

                        case 3:
                            input.nextLine();
                            System.out.print("Enter student ID: ");
                            id = input.nextLine();
                            student = managerImplemented.findStudentById(id);

                            System.out.println(managerImplemented.reviewInternshipDetails(student));
                            break;

                        case 4:
                            input.nextLine();
                            menuUI.mainMenuUI.exit();
                            break;

                        default:
                            menuUI.mainMenuUI.wrongOption();
                            break;
                    }
                    break;

                case 2:
                    menuUI.mainMenuUI.supervisorManager();
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
                            Student student = managerImplemented.findStudentById(idStudent);
                            Supervisor supervisor = managerImplemented.findSupervisorById(idSupervisor);

                            managerImplemented.assignStudentToSupervisor(student, supervisor);
                            System.out.println("The student has been assigned to the supervisor.");
                            break;

                        case 3:
                            input.nextLine();
                            menuUI.mainMenuUI.exit();
                            break;
                    }
                    break;

                case 3:
                    menuUI.mainMenuUI.internshipManager();
                    menuUI.internshipUI.mainDisplay();
                    switch (input.nextInt()){
                        case 1:
                            input.nextLine();
                            System.out.print("Enter supervisor ID: ");
                            String idSupervisor = input.nextLine();
                            System.out.print("Enter company name: ");
                            String company = input.nextLine();

                            Supervisor supervisor = managerImplemented.findSupervisorById(idSupervisor);

                            menuUI.internshipUI.InternshipType();
                            switch (input.nextInt()){
                                case 1:
                                    menuUI.internshipUI.InternshipModality();
                                    switch (input.nextInt()){
                                        case 1:
                                            managerImplemented.addInternship(new NationalInternship(supervisor, company, NationalInternship.Type.INTENSIVE));
                                            System.out.println("The internship has been added.");
                                            break;
                                        case 2:
                                            managerImplemented.addInternship(new NationalInternship(supervisor, company, NationalInternship.Type.DUAL));
                                            System.out.println("The internship has been added.");

                                            break;
                                        case 3:
                                            menuUI.mainMenuUI.cancelOperation();
                                            break;

                                        default:
                                            menuUI.mainMenuUI.wrongOption();
                                            break;
                                    }
                                case 2:
                                    System.out.println("Please indicate the country: ");
                                    String inputCountry = input.nextLine().toUpperCase();
                                    Country country = Country.valueOf(inputCountry);
                                    managerImplemented.addInternship(new ErasmusInternship(supervisor, company, country));
                                    System.out.println();

                                case 3:
                                    menuUI.mainMenuUI.cancelOperation();
                                    break;

                                default:
                                   menuUI.mainMenuUI.wrongOption();
                                    break;
                            }
                            break;

                            case 2:
                                input.nextLine();
                                System.out.print("Enter student ID: ");
                                String idStudent = input.nextLine();
                                Student student = managerImplemented.findStudentById(idStudent);
                                System.out.print("Enter supervisor ID: ");
                                 idSupervisor = input.nextLine();
                                 supervisor = managerImplemented.findSupervisorById(idSupervisor);

                                managerImplemented.assignStudentToSupervisor(student, supervisor);
                                System.out.println("The student has been assigned to the supervisor.");
                                break;

                            case 3:
                                input.nextLine();
                                menuUI.mainMenuUI.exit();
                                break;

                            default:
                                menuUI.mainMenuUI.wrongOption();
                                break;
                        }
                        break;

                case 4:
                    menuUI.mainMenuUI.close();
                    running = false;
                    break;

                default:
                    menuUI.mainMenuUI.wrongOption();
                    break;
            }
        }
    }
}
