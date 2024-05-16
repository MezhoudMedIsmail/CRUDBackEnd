package org.example.backendamen.Service.Impl;


import lombok.RequiredArgsConstructor;
import org.example.backendamen.Entities.Auth.AuthenticationRequest;
import org.example.backendamen.Entities.Auth.AuthenticationResponse;
import org.example.backendamen.Entities.Auth.RegisterRequest;
import org.example.backendamen.Entities.Role;
import org.example.backendamen.Entities.User;
import org.example.backendamen.Repository.UserRepository;
import org.example.backendamen.config.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .email(registerRequest.getEmail())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .telephone(registerRequest.getTelephone())
                .status(true)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        User u = utilisateurRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword())
        );
        var user = utilisateurRepository.findByEmail(authenticationRequest.getEmail()).get();
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
}