package domain.ui.Components;

import domain.ui.UI;

public class SupervisorUI implements UI {
    @Override
    public void display() {
        System.out.println("\nSUPERVISOR MANAGEMENT");
        System.out.println("1. Add Supervisor");
        System.out.println("2. Assign Student to Supervisor");
        System.out.println("3. Back to Main Menu");
        System.out.print("Select an option: ");
    }

    public void promptId() { System.out.print("Enter supervisor ID: "); }
    public void promptName() { System.out.print("Enter supervisor name: "); }
    public void promptSurname() { System.out.print("Enter supervisor surname: "); }
    public void promptStudentId() { System.out.print("Enter student ID: "); }

    public void showSuccess(String message) { System.out.println("SUCCESS: " + message); }
    public void showError(String message) { System.out.println("ERROR: " + message); }
}