package br.com.AuthorizationGenereaor.Authorization.Generator.core.Repositories;

import br.com.AuthorizationGenereaor.Authorization.Generator.core.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByName(String name);
}
