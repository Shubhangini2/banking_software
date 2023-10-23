package banking_software.banking_software;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
public class UserDetailsCreator implements UserDetails {


    String username;
    String password;
    List<GrantedAuthority> authorities; //roles

    //make a constructor for user class
    public UserDetailsCreator(User user){

    }

    public UserDetailsCreator(banking_software.banking_software.model.User user) {

        this.username = user.getUserName();
        this.password = user.getPassword();

        String roles[] = user.getRoles().split(",");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //iterate over roles
        for(String role: roles){
            SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority(role);
            authorities.add(simpleGrantedAuthority);
            }
         this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}
