/*
package com.example.user.accounting.service;

import com.example.user.accounting.models.User;
import com.example.user.accounting.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class NewUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public NewUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(String.format("Пользователь '%s' не найден", username));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
*/