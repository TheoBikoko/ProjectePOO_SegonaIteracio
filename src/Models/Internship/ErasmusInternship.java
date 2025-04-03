package Models.Internship;

import Models.Person.Supervisor;

public class ErasmusInternship extends Internship{
    private String country;
    private float totalHours;

    public ErasmusInternship(Supervisor supervisor, String company, String country) {
        super(supervisor, company);
        this.country = country;
    }

    @Override
    public String getDetails() {
        return "This internship has been assigned in " + country + "and has a duration of " + totalHours + " hours.";
    }
}
