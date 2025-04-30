package br.com.okto.modules.account.adapter.out.persistence.entity.account;

import br.com.okto.modules.user.adapter.out.persistence.entity.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountEntity extends AccountEntity{

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE }
    )
    @JoinTable(
            name = "user_account_users",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",    referencedColumnName = "id")
    )
    @Builder.Default
    private Set<UserEntity> users = new HashSet<>();
}
