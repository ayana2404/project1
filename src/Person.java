public class Person {
    String name;
    String surname;
    int age;
    boolean gender;

    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        String genderStr = gender ? "Male" : "Female";
        return "Hi, I am " + name + " " + surname + ", a " + age + "-year-old " + genderStr + ".";
    }
}


