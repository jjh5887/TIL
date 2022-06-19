package me.powerarc.designpatterns.structural_patterns.adapter_pattern._02_after.security;

public interface UserDetailsService {

	UserDetails loadUser(String username);

}
