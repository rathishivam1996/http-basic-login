package com.shivam.login.model;

import com.shivam.login.model.constant.RoleEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@ToString
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Serial
    private static final long serialVersionUID = 3150925864178103846L;

    @Getter
    @Id
    @Column(name = "uuid")
    private final String uuid;

    @Getter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_authorities", joinColumns = @JoinColumn(name = "role_uuid", referencedColumnName = "uuid"), inverseJoinColumns = @JoinColumn(name = "authority_uuid", referencedColumnName = "uuid"))
    @Column(name = "allowedAuthorities", nullable = true)
    private final Set<Authority> allowedAuthorities;

    @Getter
    @Column(name = "create_on", nullable = false)
    private final Timestamp createdOn;

    @Setter(AccessLevel.NONE)
    @Version
    @Column(name = "optLock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private int optLock;

    @Column(name = "authority")
    private String authority;

    public Role() {
        this.uuid = UUID.randomUUID().toString();
        allowedAuthorities = new HashSet<>();
        this.createdOn = Timestamp.from(Instant.now());
    }

    public Role(RoleEnum authority) {
        this();
        this.authority = authority.name();
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return uuid.equals(role.uuid)
                && authority.equals(role.authority)
                && allowedAuthorities.equals(role.allowedAuthorities)
                && createdOn.equals(role.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, allowedAuthorities, createdOn, authority);
    }
}
