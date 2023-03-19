package chapter02.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		this.s = Objects.requireNonNull(s);
	}

	// 문제 시연 (55쪽)
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String polish = "polish";
		// CaseInsensitiveString 에서는 String도 처리를 해주지만 반대는 X
		System.out.println(cis.equals(polish));

		List<CaseInsensitiveString> list = new ArrayList<>();
		list.add(cis);

		System.out.println(list.contains(polish));
	}

	//     대칭성 위배!
	@Override
	public boolean equals(Object o) {
		if (o instanceof CaseInsensitiveString)
			return s.equalsIgnoreCase(
				((CaseInsensitiveString)o).s);
		if (o instanceof String)  // 한 방향으로만 작동한다! (String에서 비교시 해당 타입 인지 못함)
			return s.equalsIgnoreCase((String)o);
		return false;
	}

	// 수정한 equals 메서드 (56쪽)
	//    @Override public boolean equals(Object o) {
	//        return o instanceof CaseInsensitiveString &&
	//                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
	//    }
}
