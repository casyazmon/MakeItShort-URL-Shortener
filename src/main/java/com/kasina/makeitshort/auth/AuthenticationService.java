package com.kasina.makeitshort.auth;

import com.kasina.makeitshort.model.user.RegisterRequest;
import com.kasina.makeitshort.model.user.Role;
import com.kasina.makeitshort.model.user.User;
import com.kasina.makeitshort.repository.RoleRepository;
import com.kasina.makeitshort.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;



    public  AuthenticationResponse registerUser(RegisterRequest registerRequest){
        Set<Role> roles = new HashSet<>();
        for (String roleName : registerRequest.getRoles()){
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new IllegalArgumentException("Role note found: " + roleName));
            roles.add(role);
        }
        var user = User.builder()
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .roles(roles)
                .build();
        userRepository.save(user);
        return null; // TODO return jwt token
    }

    public AuthenticationResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return null; // TODO return jwt token
    }
}
