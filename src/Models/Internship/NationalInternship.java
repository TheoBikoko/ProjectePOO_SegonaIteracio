package Models.Internship;

import Models.Person.Supervisor;

public class NationalInternship extends Internship{
    public enum Type {INTENSIVE, DUAL}
    private Type type;
    private float totalHours;


    public NationalInternship(Supervisor supervisor, String company, Type type) {
        super(supervisor, company);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getDetails() {
        return "This internship is the " + type + "modality and has a duration of " + totalHours + " hours.";
    }
}
