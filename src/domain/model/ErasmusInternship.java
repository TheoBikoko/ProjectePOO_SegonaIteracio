package domain.model;

import domain.enums.ErasmusCountry;

public class ErasmusInternship extends Internship {
    private final ErasmusCountry country;
    private final float totalHours;

    public ErasmusInternship(Student student, Supervisor supervisor, String company, ErasmusCountry country) {
        super(student, supervisor, company);
        this.country = country;
        this.totalHours = 384;
    }

    @Override
    public String getDetails() {
        return String.format("Erasmus Internship in %s at %s (%s hours)",
                country, company, totalHours);
    }
}