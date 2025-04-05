package domain.model;

public class NationalInternship extends Internship {
    public enum Type { INTENSIVE, DUAL }
    private final Type type;
    private final float totalHours;

    public NationalInternship(Student student, Supervisor supervisor, String company, Type type) {
        super(student, supervisor, company);
        this.type = type;
        this.totalHours = type == Type.DUAL ? 800 : 384;
    }

    @Override
    public String getDetails() {
        return String.format("National %s Internship at %s (%s hours)",
                type, company, totalHours);
    }
}
