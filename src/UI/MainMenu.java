package UI;

public class MainMenu implements UI {

    @Override
    public void mainDisplay() {
        System.out.println( """
                            \nMain menu:
                            1. Student Manager
                            2. Supervisor Manager
                            3. Internship Manager
                            4. Exit
                            """);
    }

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
        System.out.println("Exiting the menu...");
    }
}
