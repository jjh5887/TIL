package me.powerarc.designpatterns.structural_patterns.adapter_pattern._01_before.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
