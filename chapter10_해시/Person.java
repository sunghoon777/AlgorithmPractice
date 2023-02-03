package chapter10_해시;

public class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person)obj;
        return (this.age == person.getAge() && this.name.equals(person.getName()))?true:false;
    }

    @Override
    public String toString() {
        return "이름 "+name+" 나이 "+age;
    }
}
