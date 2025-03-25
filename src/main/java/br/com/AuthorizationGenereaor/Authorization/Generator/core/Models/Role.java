package br.com.AuthorizationGenereaor.Authorization.Generator.core.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "tb_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String name;

    public Long getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public enum Values {

        ADMIN(1L),
        PROFESSOR(2L),
        SECRETARIO(3L),
        ALUNO(4L);


        long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }

        public long getRoleId() {
            return roleId;
        }
    }
}
