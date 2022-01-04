package com.topmoviesapp.topmovies.service;


import com.topmoviesapp.topmovies.exception.InformationExistsException;
import com.topmoviesapp.topmovies.exception.InformationMissingException;
import com.topmoviesapp.topmovies.model.User;
import com.topmoviesapp.topmovies.model.UserProfile;
import com.topmoviesapp.topmovies.model.request.LoginRequest;
import com.topmoviesapp.topmovies.model.response.LoginResponse;
import com.topmoviesapp.topmovies.repository.UserProfileRepository;
import com.topmoviesapp.topmovies.repository.UserRepository;
import com.topmoviesapp.topmovies.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {this.userProfileRepository = userProfileRepository;}
    
    public User createUser(User userObject){
        if(!userRepository.existsByEmailAddress(userObject.getEmailAddress())){
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            UserProfile userProfile = new UserProfile(userObject.getId(),userObject);
            userObject.setUserProfile(userProfile);
            userRepository.save(userObject);
            userProfileRepository.save(userProfile);
            return userObject;
        } else {
            throw new InformationExistsException("a user account for " + userObject.getEmailAddress() + " already exists");
        }
    }

    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmailAddress(email);
    }


    // Authenticate user and generate a token
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(jwt));
    }
}
