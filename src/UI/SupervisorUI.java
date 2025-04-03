package UI;

public class SupervisorUI implements UI{

    @Override
    public void mainDisplay() {
        System.out.println( """
                            \nSupervisor Management:
                            1. Add Supervisor
                            2. Assign student to supervisor
                            3. Return
                            """);
    }
}
