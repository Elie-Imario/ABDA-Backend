package com.core.appbackend.controller.Auth;

import com.core.appbackend.security.authResponse.authResponse;
import com.core.appbackend.security.jwt.JwtUtil;
import com.core.appbackend.security.model.UserDetailsImpl;
import com.core.appbackend.security.model.LoginRequest;
import com.core.appbackend.beans.User;
import com.core.appbackend.security.model.SignupRequest;
import com.core.appbackend.service.user.UserDetailServiceImpl;
import com.core.appbackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthControlller {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        try {
            UsernamePasswordAuthenticationToken loginCredentials =
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(), loginRequest.getPassword());

            Authentication authentication =
                    authenticationManager.authenticate(loginCredentials);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtil.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return new ResponseEntity(new authResponse(userDetails.getUsername(), userDetails.getAuthorities(), jwt, HttpStatus.OK), HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity(new authResponse(HttpStatus.FORBIDDEN, "Les informations saisies sont incorrectes"), HttpStatus.FORBIDDEN);
        }catch (Exception e){
            return new ResponseEntity(new authResponse(HttpStatus.INTERNAL_SERVER_ERROR, "une erreur s'est produite, veuillez réessayer ultérieurement"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        try {
            if (userService.existsByUsername(signUpRequest.getUserName())) {
                return new ResponseEntity<>(new authResponse(HttpStatus.BAD_REQUEST, "Ce compte existe déjà!"), HttpStatus.BAD_REQUEST);
            }
            User newUser = userService.createUser(new User(signUpRequest.getUserName(), encoder.encode(signUpRequest.getPassword()), signUpRequest.getRole()));
            return new ResponseEntity(newUser, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
