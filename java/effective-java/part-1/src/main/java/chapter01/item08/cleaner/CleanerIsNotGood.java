package chapter01.item08.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {
	public static void main(String[] args) throws InterruptedException {
		Cleaner cleaner = Cleaner.create();

		List<Object> resourceToCleanUp = new ArrayList<>();
		BigObject bigObject = new BigObject(resourceToCleanUp);

		// cleaner에 clean 작업 등록
		cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));

		bigObject = null;
		System.gc();
		Thread.sleep(3000L);
	}
}
