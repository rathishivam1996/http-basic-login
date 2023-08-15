package com.shivam.login.service;

import com.shivam.login.model.JpaUser;
import com.shivam.login.repository.GenericSpecification;
import com.shivam.login.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JpaUser saveUser(JpaUser user) {
        log.info("save user: " + user);
        JpaUser found = userRepository.save(user);
        log.info("saved: {}", user);

        return found;
    }

    @Override
    public Optional<JpaUser> findById(String uuid) {
        log.info("find by id: " + uuid);
        Optional<JpaUser> found = userRepository.findById(uuid);
        log.info("found: {}", found);

        return found;
    }

    @Override
    public Optional<JpaUser> findByEmail(String email) {
        log.info("find by email: " + email);
        Specification<JpaUser> nameEqual = GenericSpecification.attributeEqual("email", email);
        Optional<JpaUser> found = userRepository.findOne(nameEqual);
        log.info("found: {}", found);

        return found;
    }

    @Override
    public JpaUser updatePasswordById(String uuid, String newPassword) {
        JpaUser found = userRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        JpaUser clone = new JpaUser.Builder(found).password(newPassword).lastLogin(Instant.now()).build();
        return userRepository.save(clone);
    }


    @Override
    public void deleteByUuid(String uuid) {
        userRepository.deleteById(uuid);
    }

//    @Override
//    public void deleteByEmail(String email) {
//        Specification<JpaUser> emailEqualSpec = GenericSpecification.attributeEqual("email", email);
//        userRepository.delete(emailEqualSpec);
//    }
}