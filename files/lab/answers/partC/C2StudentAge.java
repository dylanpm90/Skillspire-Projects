package week5.lab.answers.partC;

// C2 answer. A Student whose age cannot be negative or zero, and whose name cannot be empty
// (LMS Securing Data with Encapsulation, Part 12, exercise 2).
class Student {
    private String name = "Unknown";
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("Invalid name");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }
}

public class C2StudentAge {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Priya");
        s.setAge(29);
        s.setAge(-4);
        s.setName("");
        System.out.println(s.getName() + ", " + s.getAge());
    }
}
