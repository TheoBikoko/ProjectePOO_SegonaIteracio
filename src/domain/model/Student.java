package domain.model;
import domain.enums.RequiredSubject;

import java.util.ArrayList;

import java.util.List;

public class Student extends Person {
    private List<RequiredSubject> subjects;
    private Internship currentInternship;
    private final int promotionYear;

    public Student(String id, String name, String surname, int promotionYear) {
        super(id, name, surname);
        this.promotionYear = promotionYear;
        this.subjects = new ArrayList<>();
    }

    public boolean isEligibleForInternship() {
        for (RequiredSubject subject : subjects) {
            if (subject.getGrade() < 5.0f) {
                return false;
            }
        }
        return true;
    }

    public void assignSubject(RequiredSubject subject) {
        subjects.add(subject);
    }

    public List<RequiredSubject> getSubjects() { return subjects; }
    public int getPromotionYear() { return promotionYear; }
    public Internship getCurrentInternship() { return currentInternship; }
    public void setCurrentInternship(Internship internship) { this.currentInternship = internship; }
}
