package UI.Components;

import UI.UI;

public class SupervisorUI implements UI {

    @Override
    public void mainDisplay() {
        System.out.println( """
                            \nSupervisor Management:
                            1. Add Supervisor
                            2. Assign student to supervisor
                            3. Return
                            """);
    }

    public void studentAssigned(){
        System.out.println("The student has been assigned to the supervisor.");

    }

    public void requestID(){
        System.out.print("Enter supervisor ID: ");
    }

    public void requestName(){
        System.out.print("Enter supervisor name: ");
    }

    public void requestSurname(){
        System.out.print("Enter supervisor surname: ");
    }

    public void supervisorAdded(){
        System.out.println("Supervisor has been added.");
    }
}
