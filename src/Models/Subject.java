package Models;

public class Subject {
    private String name;
    private float grade;

    public Subject(String name, float grade) {
        this.name = name;
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Classes.Subject{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
