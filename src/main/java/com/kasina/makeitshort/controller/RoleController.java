package com.kasina.makeitshort.controller;

import com.kasina.makeitshort.model.user.Role;
import com.kasina.makeitshort.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    @PostMapping("/create")
    public ResponseEntity<Role> CreateRole(@RequestBody Role role){
        return ResponseEntity.ok(roleService.createRole(role));
    }


    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
}
