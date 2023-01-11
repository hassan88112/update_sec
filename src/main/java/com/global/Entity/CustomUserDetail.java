package com.global.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


public class CustomUserDetail  extends User implements UserDetails{
	
	

	public CustomUserDetail(User user) {
		super();
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities=new ArrayList<>();
		super.getRoles().forEach(role -> {
		authorities.add(new SimpleGrantedAuthority(role.getName()));	
			
		});
		
		return authorities;
				
		
	}

	@Override
	public String getUsername() {
		
		return super.getEmail();
	}
	
	@Override
	public String getPassword() {
		
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
