package com.shivam.login;

import com.shivam.login.model.Authority;
import com.shivam.login.model.JpaUser;
import com.shivam.login.model.Role;
import com.shivam.login.model.constant.AuthorityEnum;
import com.shivam.login.model.constant.RoleEnum;
import com.shivam.login.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class LoginApplication {
//	private final static Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LoginApplication.class, args);

//        UserRepository repository = context.getBean(UserRepository.class);
//
//        log.info("LoginApplication running.");
//
//        log.info("Creating user: user");
//        JpaUser jpaUser = new JpaUser();
//        jpaUser.setUsername("user@email.com");
//        jpaUser.setPassword("secrete");
//        jpaUser.setAccountNonExpired(true);
//        jpaUser.setAccountNonLocked(true);
//        jpaUser.setEnabled(true);
//        jpaUser.setCredentialsNonExpired(true);
//
//        Role userAdmin = new Role(RoleEnum.ADMIN);
//        jpaUser.getRoles().add(userAdmin);
//
//        userAdmin.getAllowedAuthorities().addAll(
//                Arrays.asList(new Authority(AuthorityEnum.AUTH_ADMIN), new Authority(AuthorityEnum.AUTH_GRANT)));
//        log.info("Saving user: user");
//        repository.save(jpaUser);
//
//        log.info("Creating user: user1");
//        JpaUser user1 = new JpaUser();
//        user1.setUsername("user1@email.com");
//        user1.setPassword("secrete");
//        user1.setAccountNonExpired(true);
//        user1.setAccountNonLocked(true);
//        user1.setEnabled(true);
//        user1.setCredentialsNonExpired(true);
//
//        Role user1Admin = new Role(RoleEnum.ADMIN);
//        user1.getRoles().add(user1Admin);
//
//        user1Admin.getAllowedAuthorities().addAll(
//                Arrays.asList(new Authority(AuthorityEnum.AUTH_ADMIN), new Authority(AuthorityEnum.AUTH_GRANT)));
//
//        log.info("Saving user: user1");
//        repository.save(user1);

//		User user = new User();
//		user.setUsername("user@email.com");
//		user.setPassword("secrete");
//		user.setAccountNonExpired(true);
//		user.setAccountNonLocked(true);
//		user.setEnabled(true);
//		user.setCredentialsNonExpired(true);
//
//		user.getRoles().add(new Role(RoleEnum.ADMIN));
//		user.getRoles().add(new Role(RoleEnum.ARCHITECT));

//		repository.save(user);

        IUserService userService = context.getBean(IUserService.class);

        Role roleAdmin = new Role(RoleEnum.ADMIN);
        Authority authorityAdmin = new Authority(AuthorityEnum.AUTH_ADMIN);
        Authority authorityCreate = new Authority(AuthorityEnum.AUTH_CREATE);
        Authority authorityGrant = new Authority(AuthorityEnum.AUTH_GRANT);
        roleAdmin.getAllowedAuthorities().addAll(List.of(authorityAdmin, authorityCreate, authorityGrant));
        System.out.println("role: " + roleAdmin);

        Role roleArchitect = new Role(RoleEnum.ARCHITECT);
        Authority authorityAdmin1 = new Authority(AuthorityEnum.AUTH_ADMIN);
        Authority authorityCreate1 = new Authority(AuthorityEnum.AUTH_CREATE);
        roleAdmin.getAllowedAuthorities().addAll(List.of(authorityAdmin1, authorityCreate1));
        System.out.println("role: " + roleArchitect);

        JpaUser user = new JpaUser.Builder("user1", "Password").roles(new HashSet<>(List.of(roleAdmin, roleArchitect)))
                .build();
        userService.saveUser(user);
        Optional<JpaUser> found = userService.findByUsername("user1");

        System.out.println("found user: " + user);
    }
}
