package com.kasina.makeitshort.auth;


import com.kasina.makeitshort.model.UrlErrorResponseDto;
import com.kasina.makeitshort.model.user.RegisterRequest;
import com.kasina.makeitshort.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        if (authenticationService.isUsernameTaken(request.getEmail())){
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setStatus("Email is already taken");
            urlErrorResponseDto.setError("403");
            return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(authenticationService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("hello")
    public ResponseEntity<String> sayHello(){
        return  ResponseEntity.ok("Hello from secure endpoint");
    }
}
