package chapter01.item01;

/*
*  이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
*  @see #getINstance()
* */
public class Settings {

	private boolean useAutoSteering;

	private boolean useABS;

	private Difficulty difficulty;

	// 객체 생성을 제한 가능
	// 단점 1. 상속이 어렵다
	// 단점 2. javadoc 에서 읽는 방법이 어려움 (네이밍 컨벤션으로 어느정도 극복?, 가장 좋은 방법은 문서화)
	private Settings() {}
	private static final Settings SETTINGS = new Settings();

	public static Settings getInstance() {
		return SETTINGS;
	}
}
