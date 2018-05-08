package practice.lxn.cn.androidpractice.test;

import java.util.HashSet;

import practice.lxn.cn.androidpractice.pojo.Person;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/5/3
 */
public class HashMapDemo {
    public static void main(String[] args) {
//        HashMap<String,Person> hashMap = new HashMap<>();
//        hashMap.put("1",new Person("a",20));
//        hashMap.put("2",new Person("a",30));
//        hashMap.put("2",new Person("b",30));
//        hashMap.put("4",new Person("c",20));
//
//        Set<Map.Entry<String,Person>> set = hashMap.entrySet();
//        Iterator<Map.Entry<String,Person>> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Person> next = iterator.next();
//            System.out.println(next.getKey());
//            Person person = next.getValue();
//            System.out.println(person.getName());
//        }
        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("1",11));
        hashSet.add(new Person("2",12));
        hashSet.add(new Person("3",12));
        hashSet.add(new Person("3",14));
        for (Person person : hashSet) {
            System.out.println(person.getName() + "--------" + person.getAge());
        }
    }
}
