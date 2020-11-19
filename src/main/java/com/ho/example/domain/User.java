package com.ho.example.domain;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String username;	
	private String password;		
	private String uName;		
	private String	uAge;
	private String uEmail;
	private String uPhone1;
	private String uPhone2;
	private String uPhone3;
	
	
	//security 관련
	private Collection<? extends GrantedAuthority> authorities;
	
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	
	public String getuAge() {
		return uAge;
	}

	public void setuAge(String uAge) {
		this.uAge = uAge;
	}

	
	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhone1() {
		return uPhone1;
	}

	public void setuPhone1(String uPhone1) {
		this.uPhone1 = uPhone1;
	}

	public String getuPhone2() {
		return uPhone2;
	}

	public void setuPhone2(String uPhone2) {
		this.uPhone2 = uPhone2;
	}

	public String getuPhone3() {
		return uPhone3;
	}

	public void setuPhone3(String uPhone3) {
		this.uPhone3 = uPhone3;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", uName=" + uName + ", uAge=" + uAge
				+ ", uEmail=" + uEmail + ", uPhone1=" + uPhone1 + ", uPhone2=" + uPhone2
				+ ", uPhone3=" + uPhone3 + ", authorities=" + authorities + ", isAccountNonExpired="
				+ isAccountNonExpired + ", isAccountNonLocked=" + isAccountNonLocked + ", isCredentialsNonExpired="
				+ isCredentialsNonExpired + ", isEnabled=" + isEnabled + "]";
	}

		
}
	
