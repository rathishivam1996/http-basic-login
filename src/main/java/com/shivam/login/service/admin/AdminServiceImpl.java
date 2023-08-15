package com.shivam.login.service.admin;

import com.shivam.login.model.JpaUser;
import com.shivam.login.repository.GenericSpecification;
import com.shivam.login.repository.UserRepository;
import com.shivam.login.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.List;

@Slf4j
public class AdminServiceImpl extends UserServiceImpl implements IAdminService {
    private final UserRepository userRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<JpaUser> saveAllUser(Iterable<JpaUser> users) {
        return null;
    }

    @Override
    public List<JpaUser> findByEmailLike(String email) {
        Specification<JpaUser> emailLikeSpec = GenericSpecification.attributeContains("email", email);
        return userRepository.findAll(emailLikeSpec);
    }

    @Override
    public List<JpaUser> findByCreatedAtBetween(Instant from, Instant to) {
        log.info("find by createdAtBetween: from {} to {}", from, to);
        Specification<JpaUser> createdBetweenSpec = GenericSpecification.attributeBetween("createdAt", from, to);
        List<JpaUser> found = userRepository.findAll(createdBetweenSpec);
        log.info("found: {}", found);

        return found;
    }

    @Override
    public List<JpaUser> findByUpdatedAtBetween(Instant from, Instant to) {
        log.info("find by updatedAtBetween: from {} to {}", from, to);
        Specification<JpaUser> updatedBetweenSpec = GenericSpecification.attributeBetween("updatedAt", from, to);
        List<JpaUser> found = userRepository.findAll(updatedBetweenSpec);
        log.info("found: {}", found);

        return found;
    }

    @Override
    public List<JpaUser> findAll() {
        log.info("find all");
        List<JpaUser> found = userRepository.findAll();
        log.info("found: {}", found);

        return found;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    //    public JpaUser updateUserById(String uuid, JpaUser user) {
//        Optional<JpaUser> found = userRepository.findById(uuid);
//        if (found.isPresent()) {
//            found.get().setEmail(user.getEmail());
//            found.get().setPassword(user.getPassword());
//            found.get().setCreatedAt(user.getCreatedAt());
//            found.get().setUpdatedAt(user.getUpdatedAt());
//            found.get().setEnabled(user.isEnabled());
//            found.get().setAccountNonExpired(user.isAccountNonExpired());
//            found.get().setAccountNonLocked(user.isAccountNonLocked());
//            found.get().setCredentialsNonExpired(user.isCredentialsNonExpired());
//
//            return userRepository.save(found.get());
//        } else {
//            return userRepository.save(user);
//        }
//        return null;
//    }

//    public JpaUser updateUserByEmail(String email, JpaUser user) {
//        Specification<JpaUser> emailEqualSpec = GenericSpecification.attributeEqual("email", email);
//        Optional<JpaUser> found = userRepository.findOne(emailEqualSpec);
//        if (found.isPresent()) {
//            found.get().setEmail(user.getEmail());
//            found.get().setPassword(user.getPassword());
//            found.get().setCreatedAt(user.getCreatedAt());
//            found.get().setUpdatedAt(user.getUpdatedAt());
//            found.get().setEnabled(user.isEnabled());
//            found.get().setAccountNonExpired(user.isAccountNonExpired());
//            found.get().setAccountNonLocked(user.isAccountNonLocked());
//            found.get().setCredentialsNonExpired(user.isCredentialsNonExpired());
//
//            return saveUser(found.get());
//        } else {
//            return saveUser(user);
//        }
//        return null;
//    }
}
