package domain.ui.Components;

import domain.ui.UI;

public class StudentUI implements UI {
    @Override
    public void display() {
        System.out.println("\nSTUDENT MANAGEMENT");
        System.out.println("1. Add Student");
        System.out.println("2. Assign Subject");
        System.out.println("3. View Internship Details");
        System.out.println("4. Back to Main Menu");
        System.out.print("Select an option: ");
    }

    public void promptId() { System.out.print("Enter student ID: "); }
    public void promptName() { System.out.print("Enter student name: "); }
    public void promptSurname() { System.out.print("Enter student surname: "); }
    public void promptPromotionYear() { System.out.print("Enter promotion year: "); }
    public void promptSubjectName() { System.out.print("Enter subject name: "); }
    public void promptSubjectGrade() { System.out.print("Enter subject grade: "); }

    public void showSuccess(String message) { System.out.println("SUCCESS: " + message); }
    public void showError(String message) { System.out.println("ERROR: " + message); }
    public void showDetails(String details) { System.out.println("\nDETAILS:\n" + details); }
}