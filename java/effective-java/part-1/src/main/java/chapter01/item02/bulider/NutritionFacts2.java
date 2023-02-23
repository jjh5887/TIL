package chapter01.item02.bulider;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder // Builder를 사용하게 되면 자동을 모든 필드를 받는 생성자가 생김, 대신 필수값은 여전히 불가능...
@AllArgsConstructor(access = AccessLevel.PRIVATE) // Builder로 인해 생기는 생성자에 대한 접근 제한
public class NutritionFacts2 {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

}
