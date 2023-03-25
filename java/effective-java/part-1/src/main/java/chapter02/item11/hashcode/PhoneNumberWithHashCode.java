package chapter02.item11.hashcode;

import lombok.EqualsAndHashCode;

// 사실 이게 제일 편함
// 추가적인 테스트 필요 X
@EqualsAndHashCode
public final class PhoneNumberWithHashCode {
	private final short areaCode, prefix, lineNum;

	public PhoneNumberWithHashCode(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 9999, "line num");
	}

	private static short rangeCheck(int val, int max, String arg) {
		if (val < 0 || val > max)
			throw new IllegalArgumentException(arg + ": " + val);
		return (short)val;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumberWithHashCode))
			return false;
		PhoneNumberWithHashCode pn = (PhoneNumberWithHashCode)o;
		return pn.lineNum == lineNum && pn.prefix == prefix
			&& pn.areaCode == areaCode;
	}

	// 코드 11-2 전형적인 hashCode 메서드 (70쪽)
	//    @Override public int hashCode() {
	//        int result = Short.hashCode(areaCode); // 1
	//		  // 31인 이유는 사전의 모든 단어를 했을 때 해시충돌이 가장 적어서
	//        result = 31 * result + Short.hashCode(prefix); // 2
	//        result = 31 * result + Short.hashCode(lineNum); // 3
	//        return result;
	//    }

	// 코드 11-3 한 줄짜리 hashCode 메서드 - 성능이 살짝 아쉽다. (71쪽)
	//    @Override public int hashCode() {
	//        return Objects.hash(lineNum, prefix, areaCode);
	//    }

	// 해시코드를 지연 초기화하는 hashCode 메서드
	// 캐싱을 해서 약간의 성능 최적화
	// but 스레드 안정성을 고려해야 한다!!! -> 여러 스레드에서 동시에 접근해서 같같 해싱을 별도로 해버리는 경우!
	private volatile int hashCode; // 자동으로 0으로 초기화된다.

	@Override
	public int hashCode() {
		if (this.hashCode != 0) {
			return hashCode;
		}

		synchronized (this) {
			int result = hashCode;
			if (result == 0) {
				result = Short.hashCode(areaCode);
				result = 31 * result + Short.hashCode(prefix);
				result = 31 * result + Short.hashCode(lineNum);
				this.hashCode = result;
			}
			return result;
		}
	}
}