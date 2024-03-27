package com.hamza.Gestion_bank.controller;

import com.hamza.Gestion_bank.entities.UserInfo;
import com.hamza.Gestion_bank.services.userservices.JwtService;
import com.hamza.Gestion_bank.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;



import java.util.List;
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userInfoService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;



    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN_ROLES')")
    public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo userInfo){

        return ResponseEntity.ok(userInfoService.addUser(userInfo));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserInfo authRequest){
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getNom(), authRequest.getPassword()));
            if(authenticate.isAuthenticated()){
                return ResponseEntity.ok(jwtService.generateToken(authRequest.getNom()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user request");
        }
    }


    @GetMapping("/getUsers")
    @PreAuthorize("hasAuthority('ADMIN_ROLES')")
    public ResponseEntity<List<UserInfo>> getAllUsers(){
        return ResponseEntity.ok(userInfoService.getAllUser());
    }

    @GetMapping("/getUsers/{id}")
    @PreAuthorize("hasAuthority('USER_ROLES')")
    public ResponseEntity<UserInfo> getUser(@PathVariable Long id){
        UserInfo user = userInfoService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/getUser/{name}")
    @PreAuthorize("hasAuthority('USER_ROLES')")
    public ResponseEntity<UserInfo> getOneUser(@PathVariable String name){
        UserInfo user = userInfoService.getOneUser(name);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }}
