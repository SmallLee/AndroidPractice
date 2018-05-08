package practice.lxn.cn.androidpractice.pojo;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/5/3
 */
public class Person/* implements Comparable<Person>*/{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        return age;
    }

   /* @Override
    public int compareTo(@NonNull Person o) {
        return this.getAge() - o.getAge();
    }*/
}
