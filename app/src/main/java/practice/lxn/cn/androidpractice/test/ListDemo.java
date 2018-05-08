package practice.lxn.cn.androidpractice.test;

import java.util.Comparator;
import java.util.TreeSet;

import practice.lxn.cn.androidpractice.pojo.Person;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/5/4
 */
public class ListDemo {
    public static void main(String[] args) {
        //第一种，元素必须实现Comparable接口，并且实现compareTo方法
      /*  TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("a",2));
        treeSet.add(new Person("b",1));
        treeSet.add(new Person("c",3));
        treeSet.add(new Person("d",4));
        for(Person i : treeSet) {
            System.out.println(i.getAge());
        }*/
      //第二种，TreeSet的构造方法中传入Comparator实现类，实现compare方法排序
        TreeSet<Person> treeSet2 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }
}
