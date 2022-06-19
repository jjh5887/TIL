package me.powerarc.designpatterns.structural_patterns.adapter_pattern._03_java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class AdapterInJava {

	public static void main(String[] args) {
		// array -> list
		List<String> strings = Arrays.asList("a", "b", "c");

		// list -> enumeration
		Enumeration<String> enumeration = Collections.enumeration(strings);

		// enumeration -> list
		ArrayList<String> list = Collections.list(enumeration);

		// io
		try (InputStream is = new FileInputStream("input.txt")) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			while (reader.ready()) {
				System.out.println(reader.readLine());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
