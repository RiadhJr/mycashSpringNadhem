package com.cash.mycash.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cash.mycash.entities.User;

public class MyUserDetails implements UserDetails {
private String username;
private String password;
private Boolean enabled;
private List<GrantedAuthority> authorities;
private User user;


public MyUserDetails() {
}


public MyUserDetails(String username) {
this.username = username;
}


public MyUserDetails(User user) {
this.username = user.getUsername();
this.password = user.getPassword();
this.enabled = user.getEnabled();
this.user = user;
}


@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
List<GrantedAuthority> auths = new ArrayList<>();

GrantedAuthority auhority = new SimpleGrantedAuthority("ROLE_"+this.user.getRole().getRole());
auths.add(auhority);
return auths;
}

/*//j'ai ajouté ça : ne pas faire attention ici 
public String getRoles() {
	
	return ("ROLE_"+ this.user.getRole().getRole());
}*/


@Override
public String getPassword() {
return this.password;
}
@Override
public String getUsername() {
return this.username;
}
@Override
public boolean isAccountNonExpired() {
return true;
}
@Override
public boolean isAccountNonLocked() {
return true;
}
@Override
public boolean isCredentialsNonExpired() {
return true;
}
@Override
public boolean isEnabled() {
	return this.enabled;
	}
}
