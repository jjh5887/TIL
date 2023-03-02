package chapter01.item05.dependencyinjection;

import java.util.List;

import chapter01.item05.Dictionary;

public class SpellChecker {

	private final Dictionary dictionary;

	// 직접적으로 객체를 생성하지 않고 외부에서 주입 받아서 의존성 분리
	// 테스트 코드에서 Mocking 도 편리
	public SpellChecker(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드
		return dictionary.contains(word);
	}

	public List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordsTo(typo);
	}

}
