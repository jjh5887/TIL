package chapter01.item05.staticutils;

import java.util.List;

import chapter01.item05.DefaultDictionary;
import chapter01.item05.Dictionary;

public class SpellChecker {

	// 내부에서 객체를 직접 생성하면 해당 클래스는 다른 객체를 사용하지 못함
	private static final Dictionary dictionary = new DefaultDictionary();

	private SpellChecker() {
	}

	public static boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드
		return dictionary.contains(word);
	}

	public static List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordsTo(typo);
	}

}
