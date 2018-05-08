package practice.lxn.cn.androidpractice.test;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/5/4
 */
public class GenericDemo {
    public static void main(String[] args) {
//        Pair<Date> pair = new Info();
//        pair.setValue(new Date());
//        //将数组转化为集合，该集合是只读的
//        List<String> list = Arrays.asList("2", "3");
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("A");
//        arrayList.add("B");
//        arrayList.add("C");
//        //将ArrayList转化为数组，new String[0]代表默认0个元素
//        String[] strings = arrayList.toArray(new String[0]);
//        for (String string : strings) {
//            System.out.println(string);
//        }

        //======================================
//        CopyOnWriteArrayList<String> cpwList = new CopyOnWriteArrayList<>();
//        cpwList.add("A");
//        System.out.println(cpwList.get(0));
        //===================================
//        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
//        Set<Object> keySet = map.keySet();
//        synchronized (map) {//同步map，而不是keySet
//            for (Object next : keySet) {
//                System.out.println(next);
//            }
//        }
        //====================================================
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("A","北京");
        concurrentHashMap.put("B","西安");
        Set<Map.Entry<String, String>> entrySet = concurrentHashMap.entrySet();
        for(Map.Entry<String,String> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
/*
* 1.类型擦除和多态的冲突
* 类型擦除以后，我们如果调用pair.setValue这句，应该调用Info的setValue方法，可是Info此时
* 有两个setValue方法，
* setValue(Date date)//自身的
* setValue(Object obj)//继承自Pair<Date>
* 那么应该调用哪个方法？
*
* 此时就要引出桥方法。
* JVM工作原理如下：
* 1.变量pair声明为Pair<Date>类型，该类型只有一个setValue(Object obj)方法，所以用pair指向的实际对象
* 去调用setValue(Object obj)这个方法
* 2.pair引用的对象是Info,所以会调用Info的setValue(Object obj)方法，这个方法是桥方法
*3.这个桥方法会调用Info的setValue(Date date)方法
* */
