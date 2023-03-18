package chapter01.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
	// 코드 9-1 try-finally - 더 이상 자원을 회수하는 최선의 방책이 아니다! (47쪽)
	static String firstLineOfFile(String path) throws IOException {
		BufferedReader br = new BadBufferedReader(new FileReader(path));
		try {
			// CharConversionException 발생
			return br.readLine();
		} finally {
			// StreamCorruptedException 발생
			br.close();
		}
	}

	static String firstLineOfFile_tryWithResource(String path) throws IOException {
		try (BufferedReader br = new BadBufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	public static void main(String[] args) throws IOException {
		// 어떤 예외가 나올까?
		// 놀랍게도 StreamCorruptedException이 나온다.
		// 이 경우 가장 나중에 발생한 예외가 나오지만 중요한건 가장 처음에 발생한 예외를 알아야 한다.
		System.out.println(firstLineOfFile("pom.xml"));

		// try-with-resource를 사용하면 가장 먼저 발생한 예외도 나오고 후속으로 발생한 예외도 나온다.
		// 문법이 간결해지는건 덤
		System.out.println(firstLineOfFile_tryWithResource("pom.xml"));
	}
}
