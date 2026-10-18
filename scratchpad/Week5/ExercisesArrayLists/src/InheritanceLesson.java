public class InheritanceLesson {
    public class Person {
        String name;
        int age;

        void introduce() {
            System.out.println("Hi, I am " + name + " and I am "
                    + age + " years old.");
        }
    }

    public class Student extends Person {
        String course;

        void study() {
            System.out.println(name + " is studying " + course + ".");
        }
    }

    public class Teacher extends Person {
        String subject;

        void teach() {
            System.out.println(name + " is teaching " + subject + ".");
        }
    }

    public class Animal {
        void sound() {
            System.out.println("Some sound");
        }
    }

    public class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Bark");
        }
    }


    void main(String[] args) {
        Student s1 = new Student();
        // s1 elements
        {
            s1.name = "Jerry";
            s1.age = 21;
            s1.course = "Computer Science";
            s1.introduce();
            s1.study();
        }

        Teacher t1 = new Teacher();
        // t1 elements
        {
            t1.name = "Dr. Sikes";
            t1.age = 45;
            t1.subject = "Calculus";
            t1.introduce();
            t1.teach();
        }

        Animal a1 = new Animal();
        a1.sound();

        Dog d1 = new Dog();
        d1.sound();

    }


}


