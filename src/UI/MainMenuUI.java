package UI;

public class MainMenuUI implements UI {

    @Override
    public void mainDisplay() {
        System.out.println( """
                            \n1. Student Manager
                            2. Supervisor Manager
                            3. Internship Manager
                            4. Exit
                            """);
    }

    public void welcome() {System.out.println("Welcome to our Internship Service for IES Poblenou. Please select one of the following options: ");}

    public void studentManager(){
        System.out.println("Entering the student manager...");
    }

    public void supervisorManager(){
        System.out.println("Entering the supervisor manager...");
    }

    public void internshipManager(){
        System.out.println("Entering the internship manager...");
    }

    public void exit(){
        System.out.println("Returning to the main menu...");
    }

    public void cancelOperation(){
        System.out.println("Canceling operation...");
    }

    public void close(){
        System.out.println("Thank you for using our services.");
    }

}
