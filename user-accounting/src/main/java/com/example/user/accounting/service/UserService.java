package com.example.user.accounting.service;

import com.example.user.accounting.models.RoleProfil;
import com.example.user.accounting.models.User;
import com.example.user.accounting.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(String.format("Пользователь '%s' не найден", username));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
                );
    }


    public void saveUser(User user) {

        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User findUserById(Long id) {
        return userRepository.getOne(id);

    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public boolean existUser(User user){
        return userRepository.existsByUsername(user.getUsername());
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


}













//private final RoleRepository roleRepository;
    /*
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    */
    /*
    public void add(){
        User user = new User();
        user.setName("asd");
        user.setEmail("asda@mail.ru");
        user.setUsername("user");
        user.setPassword("user");
        user.setSurname("use");

        user.setRoles(Collections.singleton(new Role()));
        userRepository.save(user);
        System.out.println("Пользователь создан!");
    }

     *///private final RoleRepository roleRepository;
    /*
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    */
    /*
    public void add(){
        User user = new User();
        user.setName("asd");
        user.setEmail("asda@mail.ru");
        user.setUsername("user");
        user.setPassword("user");
        user.setSurname("use");

        user.setRoles(Collections.singleton(new Role()));
        userRepository.save(user);
        System.out.println("Пользователь создан!");
    }

     */