package banking_software.banking_software.config;

import banking_software.banking_software.UserDetailsCreator;
import banking_software.banking_software.model.User;
import banking_software.banking_software.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


//Why implement UserDetailService
//because security requires a bean of userDetailService
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //fetch the user by userName
        User user = userRepository.findByUserName(username);
      //If person doesn't exist returning an exception
        if(user == null){
            throw new RuntimeException("User doesn't exist");
        }
        //Convert User to UserDetails by making UserDetailsCreator class
        return new UserDetailsCreator(user);
    }
}
