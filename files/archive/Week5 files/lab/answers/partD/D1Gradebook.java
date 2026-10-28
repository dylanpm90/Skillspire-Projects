package week5.lab.answers.partD;

import java.util.ArrayList;

// D1 answer. A gradebook: a Course holds a list of encapsulated Student objects.
class Student {
    private String name;
    private int score;

    Student(String name, int score) {
        this.name = name;           // set first: setScore's message uses the name
        setScore(score);            // the constructor reuses the setter's check
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("Invalid score for " + name + ": " + score);
        }
    }
}

class Course {
    private String title;
    private ArrayList<Student> students = new ArrayList<>();   // create the list, or add() throws NullPointerException

    Course(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public int size() {
        return students.size();
    }

    public double average() {
        if (students.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (Student s : students) {
            total += s.getScore();
        }
        return (double) total / students.size();
    }

    public Student topStudent() {
        // assumes at least one student: on an empty course, get(0) throws IndexOutOfBoundsException
        Student best = students.get(0);
        for (Student s : students) {
            if (s.getScore() > best.getScore()) {
                best = s;
            }
        }
        return best;
    }

    public int countPassing(int passMark) {
        int count = 0;
        for (Student s : students) {
            if (s.getScore() >= passMark) {
                count++;
            }
        }
        return count;
    }
}

public class D1Gradebook {
    public static void main(String[] args) {
        Course course = new Course("Java 101");
        course.addStudent(new Student("Ana", 88));
        course.addStudent(new Student("Ben", 72));
        course.addStudent(new Student("Cy", 95));
        course.addStudent(new Student("Dee", 64));
        course.addStudent(new Student("Eve", 105));

        System.out.println(course.getTitle() + ": " + course.size() + " students");
        System.out.println("Average: " + course.average());
        Student top = course.topStudent();
        System.out.println("Top: " + top.getName() + " (" + top.getScore() + ")");
        System.out.println("Passing (70 or more): " + course.countPassing(70));
    }
}

// The two questions:
// 1. Eve's score of 105 was refused, so her score stayed at the default, 0. She is still in
//    the list, though, so the average is (88 + 72 + 95 + 64 + 0) / 5 = 63.8. Refusing a bad
//    value does not remove the object that holds it.
// 2. The field holds null until something creates the list, so the first addStudent crashes:
//    NullPointerException: Cannot invoke "java.util.ArrayList.add(Object)" because
//    "this.students" is null
//    It is the same mistake as the LMS Cart example from Friday's lesson, which never
//    creates its array.
