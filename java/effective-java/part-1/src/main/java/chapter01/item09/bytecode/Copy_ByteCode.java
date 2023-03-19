package chapter01.item09.bytecode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy_ByteCode {

	// try-with-resources 의 구현 형태(바이트 코드)
	static void copy(String src, String dst) throws IOException {
		FileInputStream in = new FileInputStream(src);

		try {
			FileOutputStream out = new FileOutputStream(dst);

			try {
				byte[] buf = new byte[8192];

				int n;
				while ((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
			} catch (Throwable var8) {
				try {
					out.close();
				} catch (Throwable var7) {
					// 앞에서 발생한 Exception을 추가하여 전체 Exception을 확인 할 수 있음
					var8.addSuppressed(var7);
				}

				throw var8;
			}

			out.close();
		} catch (Throwable var9) {
			try {
				in.close();
			} catch (Throwable var6) {
				var9.addSuppressed(var6);
			}

			throw var9;
		}

		in.close();
	}
}
