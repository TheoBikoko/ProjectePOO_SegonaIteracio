package UI;

import Manager.MainManager;
import Manager.ManagerHandler;
import Models.Internship.ErasmusCountry;
import Models.Internship.ErasmusInternship;
import Models.Internship.NationalInternship;
import Models.Person.Student;
import Models.Person.Supervisor;
import Models.Subject;
import UI.Components.InternshipUI;
import UI.Components.MainMenuUI;
import UI.Components.StudentUI;
import UI.Components.SupervisorUI;

import java.util.Scanner;

public class MenuUI {
    private final MainMenuUI mainMenuUI;
    private final InternshipUI internshipUI;
    private final SupervisorUI supervisorUI;
    private final StudentUI studentUI;

    public MenuUI() {
        mainMenuUI = new MainMenuUI();
        internshipUI = new InternshipUI();
        supervisorUI = new SupervisorUI();
        studentUI = new StudentUI();
    }

    public static void main(String[] args) {
        ManagerHandler managerHandler = new ManagerHandler(new MainManager());
        MenuUI menuUI = new MenuUI();
        boolean running = true;

        while (running){
            Scanner input = new Scanner(System.in);
            menuUI.mainMenuUI.welcome();
            menuUI.mainMenuUI.mainDisplay();

            Student student;
            Supervisor supervisor;
            String studentId;
            String supervisorId;
            String name;
            String surname;
            String company;
            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                    menuUI.mainMenuUI.studentManager();
                    menuUI.studentUI.mainDisplay();
                    option = input.nextInt();
                    input.nextLine();
                    switch (option){
                        case 1:
                            menuUI.studentUI.requestID();
                            studentId = input.nextLine();
                            menuUI.studentUI.requestName();
                            name = input.nextLine();
                            menuUI.studentUI.requestSurname();
                            surname = input.nextLine();

                            managerHandler.addStudent(new Student(studentId, name, surname));

                            menuUI.studentUI.studentAdded();
                            break;

                        case 2:
                            menuUI.studentUI.requestID();
                            studentId = input.nextLine();
                            managerHandler.findStudentById(studentId);

                            menuUI.studentUI.requestSubjectName();
                            String subjectName = input.nextLine();
                            menuUI.studentUI.requestSubjectGrade();
                            float subjectGrade = input.nextFloat();
                            input.nextLine();
                            student = managerHandler.findStudentById(studentId);

                            managerHandler.assignSubjectToStudent(new Subject(subjectName, subjectGrade), student);
                            menuUI.studentUI.subjectAdded();
                            break;

                        case 3:
                            menuUI.studentUI.requestID();
                            studentId = input.nextLine();
                            student = managerHandler.findStudentById(studentId);

                            System.out.println(managerHandler.reviewInternshipDetails(student));
                            break;

                        case 4:
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
                    option = input.nextInt();
                    input.nextLine();
                    switch (option){
                        case 1:
                            menuUI.supervisorUI.requestID();;
                            supervisorId = input.nextLine();
                            menuUI.supervisorUI.requestName();
                            name = input.nextLine();
                            menuUI.supervisorUI.requestSurname();
                            surname = input.nextLine();

                            managerHandler.addSupervisor(new Supervisor(supervisorId, name, surname));

                            menuUI.supervisorUI.supervisorAdded();
                            break;

                        case 2:
                            menuUI.studentUI.requestID();
                            studentId = input.nextLine();
                            menuUI.supervisorUI.requestID();
                            supervisorId = input.nextLine();
                            student = managerHandler.findStudentById(studentId);
                            supervisor = managerHandler.findSupervisorById(supervisorId);

                            managerHandler.assignStudentToSupervisor(student, supervisor);
                            menuUI.supervisorUI.studentAssigned();
                            break;

                        case 3:
                            menuUI.mainMenuUI.exit();
                            break;
                    }
                    break;

                case 3:
                    menuUI.mainMenuUI.internshipManager();
                    menuUI.internshipUI.mainDisplay();
                    option = input.nextInt();
                    input.nextLine();
                    switch (option){
                        case 1:
                            menuUI.supervisorUI.requestID();;
                            supervisorId = input.nextLine();
                            menuUI.internshipUI.requestCompany();
                            company = input.nextLine();

                            supervisor = managerHandler.findSupervisorById(supervisorId);

                            menuUI.internshipUI.InternshipType();
                            option = input.nextInt();
                            input.nextLine();
                            switch (option){
                                case 1:
                                    menuUI.internshipUI.InternshipModality();
                                    option = input.nextInt();
                                    input.nextLine();
                                    switch (option){
                                        case 1:
                                            managerHandler.addInternship(new NationalInternship(supervisor, company, NationalInternship.Type.INTENSIVE));
                                            menuUI.internshipUI.internshipAdded();
                                            break;
                                        case 2:
                                            managerHandler.addInternship(new NationalInternship(supervisor, company, NationalInternship.Type.DUAL));
                                            menuUI.internshipUI.internshipAdded();

                                            break;
                                        case 3:
                                            menuUI.mainMenuUI.cancelOperation();
                                            break;

                                        default:
                                            menuUI.mainMenuUI.wrongOption();
                                            break;
                                    }
                                case 2:
                                    menuUI.internshipUI.requestCountry();
                                    String inputCountry = input.nextLine().toUpperCase();
                                    ErasmusCountry erasmusCountry = ErasmusCountry.valueOf(inputCountry);
                                    managerHandler.addInternship(new ErasmusInternship(supervisor, company, erasmusCountry));
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
                                menuUI.studentUI.requestID();
                                String idStudent = input.nextLine();
                                student = managerHandler.findStudentById(idStudent);
                                menuUI.supervisorUI.requestID();
                                supervisorId = input.nextLine();
                                supervisor = managerHandler.findSupervisorById(supervisorId);

                                managerHandler.assignStudentToSupervisor(student, supervisor);
                                menuUI.supervisorUI.studentAssigned();
                                break;

                            case 3:
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
