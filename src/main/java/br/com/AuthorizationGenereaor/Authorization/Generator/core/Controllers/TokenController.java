package br.com.AuthorizationGenereaor.Authorization.Generator.core.Controllers;

import br.com.AuthorizationGenereaor.Authorization.Generator.core.DTOs.LoginRequest;
import br.com.AuthorizationGenereaor.Authorization.Generator.core.DTOs.LoginResponse;
import br.com.AuthorizationGenereaor.Authorization.Generator.core.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/token")
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        var user = userRepository.findByUsername(loginRequest.username());

        if(user.isEmpty()|| user.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("user or password is not valid");
        }

    }


}
