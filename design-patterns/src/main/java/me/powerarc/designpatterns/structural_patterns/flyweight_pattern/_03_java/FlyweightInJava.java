package me.powerarc.designpatterns.structural_patterns.flyweight_pattern._03_java;

public class FlyweightInJava {

    public static void main(String[] args) {
        // -128 ~ 128 까지는 캐싱되어있음
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(10);
        System.out.println(i1 == i2);


        i1 = Integer.valueOf(1000);
        i2 = Integer.valueOf(1000);
        System.out.println(i1 == i2);
    }
}
