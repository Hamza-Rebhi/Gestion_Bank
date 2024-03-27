package com.hamza.Gestion_bank.services.userservices;

import com.hamza.Gestion_bank.entities.UserInfo;
import com.hamza.Gestion_bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user=userRepository.findByNom(username);
        return user.map(UserInfoDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
    }
    public UserInfo getOneUser(String name)
    {
        return userRepository.findByNom(name).orElse(null);
    }
    public UserInfo addUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userRepository.save(userInfo);
    }
    public List<UserInfo> getAllUser(){
        return userRepository.findAll();
    }
    public UserInfo getUser(Long id){
        return userRepository.findById(id).get();
    }
}

