package tech.insight;

/**
 * @author Max
 * @description
 * @date 2025/6/18 19:28
 */
public class User {
    private String name;
    private int age;

    public User(String tom, int i) {
        this.name = tom;
        this.age = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
