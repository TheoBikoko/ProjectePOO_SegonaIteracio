package domain.ui.Components;

import domain.ui.UI;

public class MainMenuUI implements UI {
    @Override
    public void display() {
        System.out.println("\nMAIN MENU");
        System.out.println("1. Student Management");
        System.out.println("2. Supervisor Management");
        System.out.println("3. Internship Management");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    public void showWelcome() {
        System.out.println("=== INTERNSHIP MANAGEMENT SYSTEM ===");
    }

    public void showExit() {
        System.out.println("Thank you for using our program. Goodbye!");
    }

    public void showInvalidOption() {
        System.out.println("Invalid option! Please try again.");
    }
}