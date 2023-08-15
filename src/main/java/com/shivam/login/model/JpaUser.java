package com.shivam.login.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(name = "unique_email", columnNames = "email"))
public class JpaUser {
    // Non-nullable fields
    @Id
    @Column(name = "uuid", nullable = false)
    private final String uuid;

    @Version
    @Column(name = "optLock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private int optLock;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

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

    @Column(name = "lastLogin", nullable = false)
    private Timestamp lastLogin = Timestamp.from(Instant.now());

    @Column(name = "numLoginAttempts", nullable = false)
    private int numLoginAttempts = 0;

    // Nullable fields
    @Column(name = "roles")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_uuid", referencedColumnName = "uuid"), inverseJoinColumns = @JoinColumn(name = "role_uuid", referencedColumnName = "uuid"))
    private final Set<Role> roles = new HashSet<>();

    // required by hibernate
    public JpaUser() {
        this.uuid = UUID.randomUUID().toString();
    }

    public JpaUser(Builder builder) {
        this.uuid = builder.uuid != null ? builder.uuid : UUID.randomUUID().toString();
        this.email = builder.email;
        this.password = builder.password;
        this.optLock = builder.optLock;
        this.isEnabled = builder.isEnabled;
        this.isCredentialsNonExpired = builder.isCredentialsNonExpired;
        this.isAccountNonExpired = builder.isAccountNonExpired;
        this.isAccountNonLocked = builder.isAccountNonLocked;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.lastLogin = builder.lastLogin;
        this.numLoginAttempts = builder.numLoginAttempts;
        this.roles.addAll(builder.roles);
    }

    public Instant getCreatedAt() {
        return this.createdAt.toInstant();
    }

    public Instant getUpdatedAt() {
        return this.updatedAt.toInstant();
    }

    @Override
    public String toString() {
        return "JpaUser{" +
                "uuid='" + uuid + '\'' +
                ", optLock=" + optLock +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", lastLogin=" + lastLogin +
                ", numLoginAttempts=" + numLoginAttempts +
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
        private String uuid;
        // required
        private String email;
        private String password;

        private int optLock = 0;
        // default values
        private boolean isAccountNonExpired = true;
        private boolean isAccountNonLocked = true;
        private boolean isCredentialsNonExpired = true;
        private boolean isEnabled = true;
        private Timestamp createdAt = Timestamp.from(Instant.now());
        private Timestamp updatedAt = Timestamp.from(Instant.now());

        private Timestamp lastLogin = Timestamp.from(Instant.now());

        private int numLoginAttempts = 0;

        // optional
        private final Set<Role> roles = new HashSet<>();

        public Builder(JpaUser jpaUser) {
            this.uuid = jpaUser.uuid;
            this.email = jpaUser.email;
            this.optLock = jpaUser.optLock;
            this.password = jpaUser.password;
            this.isEnabled = jpaUser.isEnabled;
            this.isAccountNonExpired = jpaUser.isAccountNonExpired;
            this.isAccountNonLocked = jpaUser.isAccountNonLocked;
            this.isCredentialsNonExpired = jpaUser.isCredentialsNonExpired;
            this.createdAt = jpaUser.createdAt;
            this.updatedAt = jpaUser.updatedAt;
            this.lastLogin = jpaUser.lastLogin;
            this.numLoginAttempts = jpaUser.numLoginAttempts;
        }

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
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

        public Builder updatedAt(Instant updatedAt) {
            this.updatedAt = Timestamp.from(updatedAt);
            return this;
        }

        public Builder lastLogin(Instant lastLogin) {
            this.lastLogin = Timestamp.from(lastLogin);
            return this;
        }

        public Builder numLoginAttempts(int numLoginAttempts) {
            this.numLoginAttempts = numLoginAttempts;
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
            Assert.hasText(user.email, "email cant not be null or empty");
            Assert.hasText(user.password, "password cant not be null or empty");
        }
    }
}
