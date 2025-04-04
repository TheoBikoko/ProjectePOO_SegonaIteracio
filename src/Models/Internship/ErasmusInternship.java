package Models.Internship;
import Models.Person.Supervisor;

public class ErasmusInternship extends Internship{
    private ErasmusCountry erasmusCountry;
    private float totalHours;

    public ErasmusInternship(Supervisor supervisor, String company, ErasmusCountry erasmusCountry) {
        super(supervisor, company);
        this.erasmusCountry = erasmusCountry;
    }

    @Override
    public String getDetails() {
        return "This internship has been assigned in " + erasmusCountry + "and has a duration of " + totalHours + " hours.";
    }
}
