package chapter01.item01;

public class Product {

	public static void main(String[] args) {
		Settings settings1 = Settings.newInstance();
		Settings settings2 = Settings.newInstance();

		System.out.println(settings1);
		System.out.println(settings2);

		// Boolean이 이를 이용하는 형태
		Boolean.valueOf(false);
	}
}
