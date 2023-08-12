package com.shivam.login.model;

import com.shivam.login.model.constant.AuthorityEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@ToString
@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Serial
    private static final long serialVersionUID = -5684691522053034674L;

    @Getter
    @Id
    @Column(name = "uuid")
    private final String uuid;
    @Getter
    @Column(name = "create_on", nullable = false)
    private final Timestamp createdOn;

    @Setter(AccessLevel.NONE)
    @Version
    @Column(name = "optLock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private int optLock;

    @Column(name = "authority", nullable = false)
    private String authority;

    public Authority() {
        this.uuid = UUID.randomUUID().toString();
        this.createdOn = Timestamp.from(Instant.now());
    }

    public Authority(AuthorityEnum authority) {
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
        Authority authority1 = (Authority) o;
        return Objects.equals(uuid, authority1.uuid)
                && Objects.equals(createdOn, authority1.createdOn)
                && Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, createdOn, authority);
    }
}
