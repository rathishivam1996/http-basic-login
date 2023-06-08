package com.shivam.login;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.shivam.login.model.Authority;
import com.shivam.login.model.AuthorityEnum;
import com.shivam.login.model.Role;
import com.shivam.login.model.RoleEnum;
import com.shivam.login.model.User;
import com.shivam.login.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LoginApplication {
//	private final static Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(LoginApplication.class, args);

		UserRepository repository = context.getBean(UserRepository.class);

		log.info("LoginApplication running.");

		log.info("Creating user: user");
		User user = new User();
		user.setUsername("user@email.com");
		user.setPassword("secrete");
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setEnabled(true);
		user.setCredentialsNonExpired(true);

		Role userAdmin = new Role(RoleEnum.ADMIN);
		user.getRoles().add(userAdmin);

		userAdmin.getAllowedAuthorities().addAll(
				Arrays.asList(new Authority(AuthorityEnum.AUTH_ADMIN), new Authority(AuthorityEnum.AUTH_GRANT)));
		log.info("Saving user: user");
		repository.save(user);

		log.info("Creating user: user1");
		User user1 = new User();
		user1.setUsername("user1@email.com");
		user1.setPassword("secrete");
		user1.setAccountNonExpired(true);
		user1.setAccountNonLocked(true);
		user1.setEnabled(true);
		user1.setCredentialsNonExpired(true);

		Role user1Admin = new Role(RoleEnum.ADMIN);
		user1.getRoles().add(user1Admin);

		user1Admin.getAllowedAuthorities().addAll(
				Arrays.asList(new Authority(AuthorityEnum.AUTH_ADMIN), new Authority(AuthorityEnum.AUTH_GRANT)));

		log.info("Saving user: user1");
		repository.save(user1);

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
	}
}
