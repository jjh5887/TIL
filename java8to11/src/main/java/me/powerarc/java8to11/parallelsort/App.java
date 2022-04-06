package me.powerarc.java8to11.parallelsort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
		int size = 1500;
		int[] nums = new int[size];
		Random random = new Random();

		IntStream.range(0, size).forEach(i -> nums[i] = random.nextInt());
		long start = System.nanoTime();
		Arrays.sort(nums);
		System.out.println("serial sorting took " + (System.nanoTime() - start));

		IntStream.range(0, size).forEach(i -> nums[i] = random.nextInt());
		start = System.nanoTime();
		Arrays.parallelSort(nums);
		System.out.println("parallel sorting took " + (System.nanoTime() - start));
	}
}
