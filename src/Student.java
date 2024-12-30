import java.util.*;

public class Student extends Person {
    int studentID;
    List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = new Random().nextInt(9000) + 1000;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    @Override
    public String toString() {
        String genderStr = gender ? "Male" : "Female";
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}
