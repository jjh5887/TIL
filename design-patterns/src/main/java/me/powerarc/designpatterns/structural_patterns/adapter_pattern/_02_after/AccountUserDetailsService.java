package me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after;

import me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after.security.UserDetails;
import me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

	AccountService accountService;

	public AccountUserDetailsService(
		AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public UserDetails loadUser(String username) {
		Account accountByUsername = accountService.findAccountByUsername(username);
		return new AccountUserDetails(accountByUsername);
	}
}
