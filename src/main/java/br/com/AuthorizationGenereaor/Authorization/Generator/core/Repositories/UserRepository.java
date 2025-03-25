package br.com.AuthorizationGenereaor.Authorization.Generator.core.Repositories;

import br.com.AuthorizationGenereaor.Authorization.Generator.core.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String name);
}
