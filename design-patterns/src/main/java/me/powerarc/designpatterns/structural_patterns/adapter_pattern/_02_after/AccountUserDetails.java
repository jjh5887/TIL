package me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after;

import me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after.security.UserDetails;

public class AccountUserDetails implements UserDetails {

	private final Account account;

	public AccountUserDetails(Account account) {
		this.account = account;
	}

	@Override
	public String getUsername() {
		return account.getName();
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}
}
