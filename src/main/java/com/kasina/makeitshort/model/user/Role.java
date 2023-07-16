package com.kasina.makeitshort.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name="role_id")
    private Long id;
    @Column(unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
