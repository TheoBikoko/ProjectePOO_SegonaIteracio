package UI;

public class InternshipUI implements UI{

    @Override
    public void mainDisplay() {
        System.out.println( """
                            \nStudent Management:
                            1. Add Internship
                            2. Review Internship Details
                            3. Return
                            """);
    }

    public void InternshipType() {
        System.out.println( """
                            \nSelect which internship type you wish to add:
                            1. National
                            2. International
                            3. Cancel
                            """);
    }

    public void InternshipModality() {
        System.out.println( """
                            \nSelect which national internship modality will be done:
                            1. Intensive
                            2. Dual
                            3. Cancel
                            """);
    }
}
