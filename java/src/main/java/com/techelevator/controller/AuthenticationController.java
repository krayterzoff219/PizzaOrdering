package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.login.UserDataDao;
import com.techelevator.model.login.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.dao.login.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;
    private UserDataDao userDataDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao, UserDataDao userDataDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
        this.userDataDao = userDataDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        
        User user = userDao.findByUsername(loginDto.getUsername());
        UserData userData = userDataDao.getUserData(user.getId());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponseDto(jwt, user, userData), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterUserDto newUser, Authentication authentication) {
        if(newUser.getRole().equalsIgnoreCase("ROLE_ADMIN") || newUser.getRole().equalsIgnoreCase("ROLE_EMPLOYEE")){
            if(authentication == null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only admin can add Employee");
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            boolean admin = false;
            for(GrantedAuthority eachAuthority : authorities){
                if(eachAuthority.getAuthority().equals("ROLE_ADMIN")){
                    admin = true;
                    try {
                        User user = userDao.findByUsername(newUser.getUsername());
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exists.");
                    } catch (UsernameNotFoundException e) {
                        userDao.create(newUser.getUsername().toLowerCase(),newUser.getPassword(), newUser.getRole());
                    }
                }
            }
            if(!admin){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only admin can add Employee");
            }
        }else {
            try {
                User user = userDao.findByUsername(newUser.getUsername());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exists.");
            } catch (UsernameNotFoundException e) {
                userDao.create(newUser.getUsername().toLowerCase(), newUser.getPassword(), newUser.getRole());
            }
        }
    }



}

