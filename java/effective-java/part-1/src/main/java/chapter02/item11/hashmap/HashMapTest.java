package chapter02.item11.hashmap;

import java.util.HashMap;
import java.util.Map;

import chapter02.item11.hashcode.PhoneNumberWithNoHahCode;
import chapter02.item11.hashcode.PhoneNumberWithSameHahCode;

public class HashMapTest {
	public static void main(String[] args) {
		Map<PhoneNumberWithNoHahCode, String> map = new HashMap<>();

		PhoneNumberWithNoHahCode number1 = new PhoneNumberWithNoHahCode(123, 456, 7890);
		PhoneNumberWithNoHahCode number2 = new PhoneNumberWithNoHahCode(123, 456, 7890);

		// TODO 같은 인스턴스인데 다른 hashCode
		System.out.println(number1.equals(number2));
		System.out.println(number1.hashCode());
		System.out.println(number2.hashCode() + "\n");

		map.put(number1, "keesun");
		map.put(number2, "whiteship");

		// equals로 같아도 구분은 잘함(hashCode로 구분해서)
		System.out.println(map.get(number2));

		// 하지만 equals가 같아도 못찾는 경우가 존재 (hashCode로 구분하지만 객체를 만들때마다 hashCode가 다르니까!)
		System.out.println(map.get(new PhoneNumberWithNoHahCode(123, 456, 7890)));
		System.out.println("\n");


		// TODO 다른 인스턴스인데 같은 hashCode를 쓴다면?
		Map<PhoneNumberWithSameHahCode, String> map2 = new HashMap<>();

		PhoneNumberWithSameHahCode number3 = new PhoneNumberWithSameHahCode(123, 456, 7890);
		PhoneNumberWithSameHahCode number4 = new PhoneNumberWithSameHahCode(111, 222, 3333);

		System.out.println(number3.equals(number4));
		System.out.println(number3.hashCode());
		System.out.println(number4.hashCode() + "\n");

		map2.put(number3, "keesun");
		map2.put(number4, "whiteship");

		// 같은 hashCode 값이여도 구분해서 잘줌
		// 하지만 해시 충돌로 인해 성능 저하
		System.out.println(map2.get(number4));

		// 그래도 hashCode가 같으니 찾기는 잘찾음
		System.out.println(map2.get(new PhoneNumberWithSameHahCode(123, 456, 7890)));
	}
}
