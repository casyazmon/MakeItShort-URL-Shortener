package com.kasina.makeitshort.controller;

import com.kasina.makeitshort.model.MakeItShort;
import com.kasina.makeitshort.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class Dashboard {
    private final UserService userService;
    @GetMapping
    public String dashboard(){
        return "User Dashboard";
    }

    @GetMapping("/user/urls")
    public ResponseEntity<List<MakeItShort>> getAllUrlsForCurrentUser() {
        List<MakeItShort> urls = userService.getAllUrlsForUser();
        return ResponseEntity.ok(urls);
    }

}
