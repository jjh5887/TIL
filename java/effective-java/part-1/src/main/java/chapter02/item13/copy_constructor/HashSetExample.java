package chapter02.item13.copy_constructor;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("keesun");
        hashSet.add("whiteship");
        System.out.println("HashSet: " + hashSet);

        // 다른 타입으로도 변환도 가능!
        Set<String> treeSet = new TreeSet<>(hashSet);

        System.out.println("TreeSet: " + treeSet);
    }
}
