import java.util.*;

public class School {
    List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : members) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }
}
