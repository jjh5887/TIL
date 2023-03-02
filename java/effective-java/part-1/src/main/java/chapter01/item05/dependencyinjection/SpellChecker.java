package chapter01.item05.dependencyinjection;

import java.util.List;
import java.util.function.Supplier;

import chapter01.item05.Dictionary;

public class SpellChecker {

	private final Dictionary dictionary;

	// 직접적으로 객체를 생성하지 않고 외부에서 주입 받아서 의존성 분리
	// 테스트 코드에서 Mocking 도 편리
	public SpellChecker(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	// 팩토리 메소드 패턴으로 한번더 추상화
	// 이렇게 되면 어떻게든 Dictionary 만 제공하는 함수형 인터페이스를 제공하면 됨
	public SpellChecker(Supplier<Dictionary> dictionarySupplier) {
		this.dictionary = dictionarySupplier.get();
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
