package chapter01.item01;

public class Settings {

	private boolean useAutoSteering;

	private boolean useABS;

	private Difficulty difficulty;

	// 객체 생성을 제한 가능
	private Settings() {};
	private static final Settings SETTINGS = new Settings();

	public static Settings newInstance() {
		return SETTINGS;
	}
}
