public class PersonComposition {
    class Person{
        void introduce(){
            System.out.println("Hi");
        }
    }

    class Student extends Person{
        void study(){
            System.out.println("I am studying");
        }
    }

    class Teacher extends Person{
        void teach(){
            System.out.println("I am teaching");
        }
    }

    void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.introduce();
        t1.teach();
    }
}
