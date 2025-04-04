package UI.Components;

import UI.UI;

public class InternshipUI implements UI {

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

    public void requestCompany(){
        System.out.println("Enter company: ");
    }

    public void requestCountry(){
        System.out.println("Please indicate the country: ");
    }

    public void internshipAdded(){
        System.out.println("The internship has been added.");
    }
}
