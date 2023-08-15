package com.shivam.login;

import com.shivam.login.model.JpaUser;
import com.shivam.login.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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

//        Role roleAdmin = new Role(RoleEnum.ADMIN);
//        Authority authorityAdmin = new Authority(AuthorityEnum.AUTH_ADMIN);
//        Authority authorityCreate = new Authority(AuthorityEnum.AUTH_CREATE);
//        Authority authorityGrant = new Authority(AuthorityEnum.AUTH_GRANT);
//        roleAdmin.getAllowedAuthorities().addAll(List.of(authorityAdmin, authorityCreate, authorityGrant));
//        System.out.println("role: " + roleAdmin);
//
//        Role roleArchitect = new Role(RoleEnum.ARCHITECT);
//        Authority authorityAdmin1 = new Authority(AuthorityEnum.AUTH_ADMIN);
//        Authority authorityCreate1 = new Authority(AuthorityEnum.AUTH_CREATE);
//        roleAdmin.getAllowedAuthorities().addAll(List.of(authorityAdmin1, authorityCreate1));
//        System.out.println("role: " + roleArchitect);
//
//        JpaUser user = new JpaUser.Builder("user1", "Password").roles(new HashSet<>(List.of(roleAdmin, roleArchitect)))
//                .build();
//        userService.saveUser(user);
//        List<JpaUser> found = userService.findByUsernameLike("user1");
//
//        System.out.println("found user: " + user);
//
//        JpaUser user2 = new JpaUser.Builder("new username", "new password").build();
//
//        JpaUser updatedUser = userService.updateUserById(user.getUuid(), user2);
//
//        log.info("updated user: {}", user2);
//
//        List<JpaUser> users = userService.findAll();
//
//        log.info("all users: {}", users);

        JpaUser user1 = new JpaUser.Builder("user1", "pass").build();
        JpaUser user2 = new JpaUser.Builder("user2", "pass").build();

        System.out.println("saved user: " + userService.saveUser(user1));
        System.out.println("saved user: " + userService.saveUser(user2));

        System.out.println("find user1 by email: " + userService.findByEmail("user1"));
        System.out.println("find user1 by uuid: " + userService.findById(user1.getUuid()));

        System.out.println("update user1 pass by uuid: ");
        userService.updatePasswordById(user1.getUuid(), "passssssssssssss");
        System.out.println("update user2 pass by uuid: ");
        userService.updatePasswordById(user2.getUuid(), "xxxxxxxxxxxxxxxx");

        System.out.println("find updated user1 by uuid: " + userService.findById(user1.getUuid()));
        System.out.println("find updated user2 by uuid: " + userService.findById(user2.getUuid()));

        System.out.println("update user1 pass by uuid: ");
        userService.updatePasswordById(user1.getUuid(), "aaaaaaaaaaaaaaa");
    }


}
