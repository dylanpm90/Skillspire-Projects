import java.util.ArrayList;

public class StudentRoster {
    static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 19));
        students.add(new Student("Beatrice", 21));

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).age);
        }
    }
}
class Student {
    String name;
    int age;

    Student(String n, int a) {
        this.name = n;
        this.age = a;
    }

    @Override
    public String toString() {
        return "Student: " + name + " (" + age + ")";
    }

}
