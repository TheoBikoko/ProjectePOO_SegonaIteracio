package UI;

public class StudentUI implements UI{

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
}
