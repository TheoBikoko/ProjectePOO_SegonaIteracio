package UI.Components;

import UI.UI;

public class StudentUI implements UI {

    @Override
    public void mainDisplay() {
        System.out.println( """
                            \nStudent Management:
                            1. Add Student
                            2. Assign Subjects
                            3. Review Internship Details
                            4. Return
                            """);
    }

    public void requestID(){
        System.out.print("Enter student ID: ");
    }

    public void requestName(){
        System.out.print("Enter student name: ");
    }

    public void requestSurname(){
        System.out.print("Enter student surname: ");
    }

    public void studentAdded(){
        System.out.println("Student has been added.");
    }

    public void requestSubjectName(){
        System.out.print("Enter the subject name: ");
    }

    public void requestSubjectGrade(){
        System.out.print("Enter the subject grade: ");
    }

    public void subjectAdded(){
        System.out.println("Subject has been added.");
    }
}
