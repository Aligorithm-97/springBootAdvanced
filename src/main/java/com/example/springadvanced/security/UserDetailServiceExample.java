package com.example.springadvanced.security;


import com.example.springadvanced.dao.user.UserEntity;
import com.example.springadvanced.dao.user.data.IUserEntityDao;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceExample implements UserDetailsService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final IUserEntityDao userEntityDao;
    public UserDetailServiceExample(BCryptPasswordEncoder passwordEncoderParam,
                               final IUserEntityDao userEntityDaoParam) {
        passwordEncoder = passwordEncoderParam;
        userEntityDao   = userEntityDaoParam;
    }

    private UserDetails cloneUser(UserDetails userDetailsParam) {
        return User.builder()
                .username(userDetailsParam.getUsername())
                .password(userDetailsParam.getPassword())
                .authorities(userDetailsParam.getAuthorities())
                .build();
    }

    private UserDetails convertToUserDetails(UserEntity userDetailsParam) {
        return User.builder()
                .username(userDetailsParam.getUsername())
                .password(passwordEncoder.encode(userDetailsParam.getPassword()))
                .roles(userDetailsParam.getUserRole().name())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity  userDetailsLoc  = userEntityDao.findByUsername(username);
        if (userDetailsLoc == null) {
            throw new UsernameNotFoundException("Böyle bir user yok");
        }

        return convertToUserDetails(userDetailsLoc);
    }
}
