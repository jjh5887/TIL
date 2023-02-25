package chapter01.item03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import chapter01.item03.enumtype.Elvis;

public class EnumElvisSerialization {

	public static void main(String[] args) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
			out.writeObject(Elvis.INSTANCE);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
			// 역직렬화도 알아서 방어
			Elvis elvis = (Elvis)in.readObject();
			System.out.println(elvis == Elvis.INSTANCE);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
