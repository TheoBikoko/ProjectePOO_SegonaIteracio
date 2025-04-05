package domain.enums;

import domain.model.Subject;

public class RequiredSubject implements Subject{
    private final String name;
    private final float grade;

    public RequiredSubject(String name, float grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
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
