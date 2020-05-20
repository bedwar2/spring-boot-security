package com.brianedwards.springbootsecurity.Service;

import com.brianedwards.springbootsecurity.Repository.UserRepository;
import com.brianedwards.springbootsecurity.model.MdpUserDetails;
import com.brianedwards.springbootsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class MdpUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public User getMDPUserInfo(String eidmUserId)  throws UsernameNotFoundException {
        Optional<User> user =  this.userRepository.findByEidmUserIdIgnoreCase(eidmUserId);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + eidmUserId));

        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String eidmUserId) throws UsernameNotFoundException {
        Optional<User> user =  this.userRepository.findByEidmUserIdIgnoreCase(eidmUserId);

        //Remember .orElseThrow uses a lambda
        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + eidmUserId));

        //Same as return new MDPUserDetails(user.get())
        return user.map(MdpUserDetails::new).get();

        //Original more wordy code below
        /*
        if (user.isPresent()) {
            UserDetails userDetails =  new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

                    return authorities;
                }

                @Override
                public String getPassword() {
                    return "pass";
                }

                @Override
                public String getUsername() {
                    return user.get().getEidmUserId();
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
                    return user.get().getActvInd().equalsIgnoreCase("1");
                }
            };

            return userDetails;

        } else {
            throw new UsernameNotFoundException("Username or password is incorrect");
        }
        */


    }
}
