package domain.model;

public abstract class Internship {
    protected Student student;
    protected Supervisor supervisor;
    protected String company;

    public Internship(Student student, Supervisor supervisor, String company) {
        this.student = student;
        this.supervisor = supervisor;
        this.company = company;
    }

    public abstract String getDetails();
    public Student getStudent() { return student; }
    public Supervisor getSupervisor() { return supervisor; }
    public String getCompany() { return company; }
}