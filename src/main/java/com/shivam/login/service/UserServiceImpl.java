package com.shivam.login.service;

import com.shivam.login.model.JpaUser;
import com.shivam.login.repository.UserRepository;
import com.shivam.login.repository.UserSpecifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public JpaUser saveUser(JpaUser user) {
        log.info("save user: " + user);
        JpaUser found = userRepository.save(user);
        log.info("saved: " + user);

        return found;
    }

    @Override
    public Iterable<JpaUser> saveAll(Iterable<JpaUser> users) {
        log.info("Save users: {}", users);
        Iterable<JpaUser> saved = userRepository.saveAll(users);
        log.info("saved users: {}", saved);

        return saved;
    }

    @Override
    public Optional<JpaUser> findById(String uuid) {
        log.info("find by id: " + uuid);
        Optional<JpaUser> found = userRepository.findById(uuid);
        log.info("found: " + found);

        return found;
    }

    @Override
    public Optional<JpaUser> findByUsername(String username) {
        log.info("find by username: " + username);
        Optional<JpaUser> found = userRepository.findOne(new UserSpecifications.NameEqualSpec(username));
        log.info("found: " + found);

        return found;
    }

    @Override
    public List<JpaUser> findByUsernameLike(String username) {
        log.info("find by usernameLike: " + "%" + username + "%");
        List<JpaUser> found = userRepository.findAll(new UserSpecifications.NameLikeSpec("Shivam"));
        log.info("found: {}", found);

        return found;
    }

    @Override
    public List<JpaUser> findByCreatedAtBetween(Instant from, Instant to) {
        return userRepository.findAll(new UserSpecifications.CreatedAtBetweenSpec(from, to));
    }

    @Override
    public List<JpaUser> findByUpdatedAtBetween(Instant from, Instant to) {
        return userRepository.findAll(new UserSpecifications.UpdatedAtBetweenSpec(from, to));
    }

    @Override
    public List<JpaUser> findAll() {
        log.info("UserServiceImpl find all");
        List<JpaUser> found = userRepository.findAll();
        log.info("UserServiceImpl found: {}", found);

        return found;
    }

    @Override
    public JpaUser updateUserById(String uuid, JpaUser user) {
        Optional<JpaUser> found = userRepository.findById(uuid);
        if (found.isPresent()) {
            found.get().setUsername(user.getUsername());
            found.get().setPassword(user.getPassword());
            found.get().setCreatedAt(user.getCreatedAt());
            found.get().setUpdatedAt(user.getUpdatedAt());
            found.get().setEnabled(user.isEnabled());
            found.get().setAccountNonExpired(user.isAccountNonExpired());
            found.get().setAccountNonLocked(user.isAccountNonLocked());
            found.get().setCredentialsNonExpired(user.isCredentialsNonExpired());

            return userRepository.save(found.get());
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public JpaUser updateUserByUsername(String username, JpaUser user) {
        Optional<JpaUser> found = userRepository.findOne(new UserSpecifications.NameEqualSpec(username));
        if (found.isPresent()) {
            found.get().setUsername(user.getUsername());
            found.get().setPassword(user.getPassword());
            found.get().setCreatedAt(user.getCreatedAt());
            found.get().setUpdatedAt(user.getUpdatedAt());
            found.get().setEnabled(user.isEnabled());
            found.get().setAccountNonExpired(user.isAccountNonExpired());
            found.get().setAccountNonLocked(user.isAccountNonLocked());
            found.get().setCredentialsNonExpired(user.isCredentialsNonExpired());

            return saveUser(found.get());
        } else {
            return saveUser(user);
        }
    }

    @Override
    public void deleteById(String uuid) {
        userRepository.deleteById(uuid);
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.delete(new UserSpecifications.DeleteByUsernameSpec(username));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
