package chapter01.item05.singleton;

import java.util.List;

import chapter01.item05.DefaultDictionary;
import chapter01.item05.Dictionary;

public class SpellChecker {

	private final Dictionary dictionary = new DefaultDictionary();

	private SpellChecker() {
	}

	// 싱글톤이여도 해당 객체의 의존성을 해결하지는 못함
	public static final SpellChecker INSTANCE = new SpellChecker();

	public boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드
		return dictionary.contains(word);
	}

	public List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordsTo(typo);
	}

}
