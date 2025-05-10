package com.srinu.SpringBoot_RestAPI.service;

import com.srinu.SpringBoot_RestAPI.repo.UserRepo;

import com.srinu.SpringBoot_RestAPI.model.User;
import com.srinu.SpringBoot_RestAPI.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repo.findByUsername(username);
        if(user == null)
        {
            System.out.printf("user not found");
            throw new UsernameNotFoundException("user not found at db");
        }
        return new UserPrincipal(user);
    }
}
