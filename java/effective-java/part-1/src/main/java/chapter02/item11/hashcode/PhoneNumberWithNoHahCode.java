package chapter02.item11.hashcode;

// equals를 재정의하면 hashCode로 재정의해야 함을 보여준다. (70-71쪽)
public final class PhoneNumberWithNoHahCode {
	private final short areaCode, prefix, lineNum;

	public PhoneNumberWithNoHahCode(int areaCode, int prefix, int lineNum) {
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
		if (!(o instanceof PhoneNumberWithNoHahCode))
			return false;
		PhoneNumberWithNoHahCode pn = (PhoneNumberWithNoHahCode)o;
		return pn.lineNum == lineNum && pn.prefix == prefix
			&& pn.areaCode == areaCode;
	}
}