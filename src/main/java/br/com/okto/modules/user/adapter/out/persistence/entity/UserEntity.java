package br.com.okto.modules.user.adapter.out.persistence.entity;

import br.com.okto.modules.account.adapter.out.persistence.entity.account.UserAccountEntity;
import br.com.okto.modules.account.domain.model.account.Account;
import br.com.okto.modules.user.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "hashed_password", nullable = false)
    private String hashedPassword;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserAccountEntity> accounts = new HashSet<>();
}
