//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Person {
    String name;
    int age;
    void introduction(){
        System.out.printf("Hello, my name is %s and I'm %d years old", name, age);
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

}

void main() {
    Person p1 = new Person("Bill", 31);
    p1.introduction();
}
