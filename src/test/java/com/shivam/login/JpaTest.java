//package com.shivam.login;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.shivam.login.model.Role;
//import com.shivam.login.model.User;
//import com.shivam.login.repository.UserRepository;
//
//@SpringBootTest
//public class JpaTest {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Test
//	void saveUser() {
//		User user = new User();
////		user.setFirstName("ramesh");
////		user.setLastName("fadatare");
////		user.setEmail("ramesh@gmail.com");
//		user.setPassword("secrete");
//
//		Role admin = new Role();
//		admin.setName("ROLE_ADMIN");
//
//		Role customer = new Role();
//		customer.setName("ROLE_CUSTOMER");
//
//		user.getRoles().add(admin);
//		user.getRoles().add(customer);
//
//		userRepository.save(user);
//	}
//
//}
