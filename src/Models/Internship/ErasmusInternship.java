package Models.Internship;
import Models.Person.Supervisor;

public class ErasmusInternship extends Internship{
    private Country country;
    private float totalHours;

    public ErasmusInternship(Supervisor supervisor, String company, Country country) {
        super(supervisor, company);
        this.country = country;
    }

    @Override
    public String getDetails() {
        return "This internship has been assigned in " + country + "and has a duration of " + totalHours + " hours.";
    }
}
