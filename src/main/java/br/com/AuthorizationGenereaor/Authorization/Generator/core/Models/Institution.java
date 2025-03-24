package br.com.AuthorizationGenereaor.Authorization.Generator.core.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID institutionId;

    private String name;

    private String cnpj;

    @ManyToMany(mappedBy = "institutions")
    private Set<User> users;
}
