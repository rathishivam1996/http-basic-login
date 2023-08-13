package com.shivam.login.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(name = "unique_username", columnNames = "username"))
public class JpaUser {
    @Setter(AccessLevel.NONE)
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Setter(AccessLevel.NONE)
    @Version
    @Column(name = "optLock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private int optLock;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "isAccountNonExpired", nullable = false)
    private boolean isAccountNonExpired = true;

    @Column(name = "isAccountNonLocked", nullable = false)
    private boolean isAccountNonLocked = true;

    @Column(name = "isCredentialsNonExpired", nullable = false)
    private boolean isCredentialsNonExpired = true;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled = true;

    @Column(name = "createdAt", nullable = false)
    private Timestamp createdAt = Timestamp.from(Instant.now());

    @Column(name = "updatedAt", nullable = false)
    private Timestamp updatedAt = Timestamp.from(Instant.now());

    @Column(name = "roles", nullable = true)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_uuid", referencedColumnName = "uuid"), inverseJoinColumns = @JoinColumn(name = "role_uuid", referencedColumnName = "uuid"))
    private final Set<Role> roles = new HashSet<>();

    // required by hibernate
    public JpaUser() {
        this.uuid = UUID.randomUUID().toString();
    }

    public JpaUser(Builder builder) {
        this.uuid = UUID.randomUUID().toString();
        this.username = builder.username;
        this.password = builder.password;
        this.isEnabled = builder.isEnabled;
        this.isCredentialsNonExpired = builder.isCredentialsNonExpired;
        this.isAccountNonExpired = builder.isAccountNonExpired;
        this.isAccountNonLocked = builder.isAccountNonLocked;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.roles.addAll(builder.roles);
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = Timestamp.from(createdAt);
    }

    public Instant getCreatedAt() {
        return this.createdAt.toInstant();
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = Timestamp.from(updatedAt);
    }

    public Instant getUpdatedAt() {
        return this.updatedAt.toInstant();
    }

    @Override
    public String toString() {
        return "JpaUser{" +
                "uuid='" + uuid + '\'' +
                ", optLock=" + optLock +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
//                ", roles=" + (roles == null ? "null" : roles) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaUser user = (JpaUser) o;
        return uuid.equals(user.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    public static class Builder {
        // required
        private final String username;
        private final String password;
        private boolean isAccountNonExpired = true;
        private boolean isAccountNonLocked = true;
        private boolean isCredentialsNonExpired = true;
        private boolean isEnabled = true;
        private Timestamp createdAt = Timestamp.from(Instant.now());
        private Timestamp updatedAt = Timestamp.from(Instant.now());

        // optional
        private final Set<Role> roles = new HashSet<>();

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Builder isAccountNonExpired(boolean isAccountNonExpired) {
            this.isAccountNonExpired = isAccountNonExpired;
            return this;
        }

        public Builder isAccountNonLocked(boolean isAccountNonLocked) {
            this.isAccountNonLocked = isAccountNonLocked;
            return this;
        }

        public Builder isCredentialsNonExpired(boolean isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public Builder isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = Timestamp.from(createdAt);
            return this;
        }

        public Builder updatedAt(Instant updatedAt) {
            this.updatedAt = Timestamp.from(updatedAt);
            return this;
        }

        public Builder roles(HashSet<Role> roles) {
            this.roles.addAll(roles);
            return this;
        }

        public JpaUser build() {
            JpaUser user = new JpaUser(this);
            validateUserObject(user);
            return user;
        }

        private void validateUserObject(JpaUser user) {
            Assert.hasText(user.username, "username cant not be null or empty");
            Assert.hasText(user.password, "password cant not be null or empty");
        }
    }
}
