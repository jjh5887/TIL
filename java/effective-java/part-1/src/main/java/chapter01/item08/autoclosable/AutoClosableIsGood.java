package chapter01.item08.autoclosable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutoClosableIsGood implements AutoCloseable {

	private final BufferedReader reader;

	public AutoClosableIsGood(String path) {
		try {
			this.reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(path);
		}
	}

	// idempotent(멱등성) 유지 권장
	// AutoCloseable 하위 interface인 Closeable은 idempotent 거의 필수
	@Override
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			// 에러 처리를 클라이언트에게 전가하지 않는 형태
			throw new RuntimeException(e);
		}
	}
}
