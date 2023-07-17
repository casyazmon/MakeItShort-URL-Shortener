package com.kasina.makeitshort.auth;


import com.kasina.makeitshort.model.user.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.registerUser(request));
    }

//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest registerRequest) {
//        User registeredUser = authenticationService.registerUser(registerRequest);
//        return ResponseEntity.ok(registeredUser);
//    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("hello")
    public ResponseEntity<String> sayHello(){
        return  ResponseEntity.ok("Hello from secure endpoint");
    }
}
