package me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after;

import me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after.security.LoginHandler;
import me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after.security.UserDetailsService;

public class App {

	public static void main(String[] args) {
		AccountService accountService = new AccountService();
		UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
		LoginHandler loginHandler = new LoginHandler(userDetailsService);
		String login = loginHandler.login("kwonho", "kwonho");
		System.out.println(login);
	}
}
