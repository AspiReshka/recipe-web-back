package com.example.recipeWeb.services;

import com.example.recipeWeb.models.Role;
import com.example.recipeWeb.repositories.UserRepository;
import com.example.recipeWeb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserService implements UserDetailsService
{
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException
    {
        User user = userRepository.findByName(name);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                mapRolesToAthorities(user.getRoles()));
    }

    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles)
    {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
                .collect(Collectors.toList());
    }

    public void addUser(User user) throws Exception
    {
        User userFromDb = userRepository.findByName(user.getName());
        if (userFromDb != null)
        {
            throw new Exception("This user already exist");
        }
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
    }
}