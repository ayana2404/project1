import java.io.*;
import java.util.*;

public class Main {

    public static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                List<Integer> grades = new ArrayList<>();
                for (int i = 4; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }
                Student student =  new Student(name, surname, age, gender);
                for (int grade : grades) {
                    student.addGrade(grade);
                }
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Teacher> readTeachersFromFile(String filename) {
        List<Teacher> teachers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                String subject = parts[4];
                int yearsOfExperience = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                teachers.add(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public static void main(String[] args) {
        List<Student> students = readStudentsFromFile("students.txt");
        List<Teacher> teachers = readTeachersFromFile("teachers.txt");

        School school = new School();

        for (Student student : students) {
            school.addMember(student);
        }
        for (Teacher teacher : teachers) {
            school.addMember(teacher);
        }

        System.out.println("School members:\n");
        System.out.println(school);

        System.out.println("\nGPA for students:");
        for (Student student : students) {
            System.out.println(student.name + " " + student.surname + " GPA: " + student.calculateGPA());
        }

        System.out.println("\nGiving raise to teachers with more than 10 years of experience:");
        for (Teacher teacher : teachers) {
            if (teacher.yearsOfExperience > 10) {
                teacher.giveRaise(10);
                System.out.println(teacher.name + " " + teacher.surname + " new salary: " + teacher.salary);
            }
        }
    }
}
