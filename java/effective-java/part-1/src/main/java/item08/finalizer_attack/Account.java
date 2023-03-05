package item08.finalizer_attack;

import java.math.BigDecimal;

public class Account {
	private final String accountId;

	public Account(String accountId) {
		this.accountId = accountId;

		if (accountId.equals("푸틴")) {
			throw new IllegalArgumentException("푸틴은 계정을 막습니다.");
		}
	}

	public void transfer(BigDecimal amount, String to) {
		System.out.printf("transfer %f from %s to %s\n", amount, accountId, to);
	}

	// finalize 오버라이딩 못하게 막으면 해결
	@Override
	protected void finalize() throws Throwable {
	}
}
