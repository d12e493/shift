package com.davis.shift.authenticate;

import com.davis.shift.dao.UserRepository;
import com.davis.shift.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        System.out.println("loadUserByUsername user : "+user.getId());

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {

            JWTUser jwtUser = new JWTUser();

            jwtUser.setId(user.getId());
            jwtUser.setEmail(email);
            jwtUser.setName(user.getName());
            jwtUser.setPassword(user.getPassword());

            return jwtUser;
        }
    }
}
