package domain.ui.Components;

import domain.ui.UI;

public class InternshipUI implements UI {
    @Override
    public void display() {
        System.out.println("\nINTERNSHIP MANAGEMENT");
        System.out.println("1. Add Internship");
        System.out.println("2. View Internship Details");
        System.out.println("3. Back to Main Menu");
        System.out.print("Select an option: ");
    }

    public void displayTypeMenu() {
        System.out.println("\nINTERNSHIP TYPE");
        System.out.println("1. National");
        System.out.println("2. International");
        System.out.println("3. Cancel");
        System.out.print("Select an option: ");
    }

    public void displayNationalTypeMenu() {
        System.out.println("\nNATIONAL INTERNSHIP TYPE");
        System.out.println("1. Intensive");
        System.out.println("2. Dual");
        System.out.println("3. Cancel");
        System.out.print("Select an option: ");
    }

    public void promptCompany() { System.out.print("Enter company name: "); }
    public void promptCountry() { System.out.print("Enter country: "); }
    public void promptStudentId() { System.out.print("Enter student ID: "); }
    public void promptSupervisorId() { System.out.print("Enter supervisor ID: "); }

    public void showSuccess(String message) { System.out.println("SUCCESS: " + message); }
    public void showError(String message) { System.out.println("ERROR: " + message); }
    public void showDetails(String details) { System.out.println("\nDETAILS:\n" + details); }
}