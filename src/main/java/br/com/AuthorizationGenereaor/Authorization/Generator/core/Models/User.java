package br.com.AuthorizationGenereaor.Authorization.Generator.core.Models;

import br.com.AuthorizationGenereaor.Authorization.Generator.core.DTOs.LoginRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String name;

    private String password;

    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;


    @ManyToMany
    @JoinTable(
            name= "user_institution",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "institutionId")
    )
    private Set<Institution> institutions;


    public boolean isLoginCorrect (LoginRequest loginRequest, PasswordEncoder passwordEncoder ){

       return passwordEncoder.matches(loginRequest.password(), this.password);


    }


}
