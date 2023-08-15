//package com.shivam.login.service;
//
//import com.shivam.login.model.JpaUser;
//import com.shivam.login.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@DataJpaTest
//public class UserServiceTest {
//    @Mock
//    private UserRepository repository;
//
//    @InjectMocks
//    private UserServiceImpl service;
//
//    private JpaUser user;
//
//    @BeforeEach
//    public void assertSetUp() {
//        assertThat(repository).isNotNull();
//        assertThat(service).isNotNull();
//    }
//
//    @BeforeEach
//    public void initUser() {
//        user = new JpaUser.Builder("username", "password").build();
//    }
//
//    @DisplayName("UserService save test")
//    @Test
//    public void givenJpaUser_whenSaveJpaUser_thenReturnJpaUser() {
//        // given - precondition or setup
//        given(repository.save(user)).willReturn(user);
//
//        // when - action or the behavior that we are going test
//        JpaUser savedUser = service.saveUser(user);
//
//        assertThat(savedUser).isNotNull();
//        assertThat(savedUser.getEmail()).isEqualTo("username");
//    }
//
//    @DisplayName("UserService save existing username Exception test")
//    @Test
//    public void givenExistingUsername_whenSave_thenThrowException() {
//        // setup
//        given(repository.save(user)).willThrow(DataIntegrityViolationException.class);
//
//        // action
//        assertThatThrownBy(() -> service.saveUser(user)).isInstanceOf(DataIntegrityViolationException.class);
//
//        // verify
//        verify(repository, times(1)).save(Mockito.any(JpaUser.class));
//    }
//
//    @DisplayName("UserService save non null violation Exception test")
//    @Test
//    public void givenJpaUserWithNullUsername_whenSave_thenThrowException() {
//        JpaUser noUsernameUser = new JpaUser();
////        noUsernameUser.setPassword("password");
//        given(repository.save(noUsernameUser)).willThrow(DataIntegrityViolationException.class);
//
//        assertThatThrownBy(() -> {
//            service.saveUser(noUsernameUser);
//        }).isInstanceOf(DataIntegrityViolationException.class);
//
//        verify(repository, times(1)).save(noUsernameUser);
//    }
//
//    @Test
//    public void givenNullUser_whenSaveUser_thenNoOp() {
//        // given
//        JpaUser nullUser = null;
//        given(repository.save(nullUser)).willReturn(nullUser);
//
//        // when
//        JpaUser savedUser = service.saveUser(nullUser);
//
//        // Then
//        verify(repository).save(nullUser);
//        assertThat(savedUser).isNull();
//    }
//
//    @DisplayName("UserService save all")
//    @Test
//    public void givenUsers_whenSaveAll_thenReturnUsers() {
//        JpaUser user1 = new JpaUser.Builder("username1", "password1").build();
//        JpaUser user2 = new JpaUser.Builder("username2", "password2").build();
//        JpaUser user3 = new JpaUser.Builder("username3", "password3").build();
//        JpaUser user4 = new JpaUser.Builder("username4", "password4").build();
//
//        List<JpaUser> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//
//        given(repository.saveAll(ArgumentMatchers.<Iterable<JpaUser>>any()))
//                .willReturn(users);
//
//        List<JpaUser> saved = repository.saveAll(users);
//
//        for (int i = 0; i < saved.size(); i++) {
//            assertThat(saved.get(i)).isEqualTo(users.get(i));
//        }
//        verify(repository, times(1)).saveAll(users);
//    }
//
//    @DisplayName("UserService find by id")
//    @Test
//    public void givenUser_whenFindById_thenReturnUser() {
//        given(repository.findById(user.getUuid())).willReturn(Optional.of(user));
//
//        Optional<JpaUser> found = service.findById(user.getUuid());
//
//        assertThat(found.isPresent()).isEqualTo(true);
//        assertThat(found.isPresent() ? found.get() : Optional.empty()).isEqualTo(user);
//        verify(repository, times(1)).findById(user.getUuid());
//    }
//
//    @DisplayName("UserService findById not found test")
//    @Test
//    public void givenNoUser_whenFindById_thenReturnOptionalOfEmpty() {
//        given(repository.findById(anyString())).willReturn(Optional.empty());
//
//        Optional<JpaUser> found = service.findById(user.getUuid());
//
//        assertThat(found.isPresent()).isEqualTo(false);
//        assertThat(found.isPresent() ? found.get() : Optional.empty()).isEqualTo(Optional.empty());
//        verify(repository, times(1)).findById(user.getUuid());
//    }
//
//    @DisplayName("UserService findByUsername")
//    @Test
//    public void givenExistingUser_whenFind_thenReturnUser() {
////        given(repository.findOne(new UserSpecifications.NameEqualSpec(user.getUsername())))
////                .willReturn(Optional.of(user));
//        // setup
//        given(repository.findOne(ArgumentMatchers.<Specification<JpaUser>>any()))
//                .willReturn(Optional.of(user));
//
//        // action
//        Optional<JpaUser> foundUser = service.findByUsername(user.getEmail());
//
//        // verify
//        verify(repository, times(1)).findOne(ArgumentMatchers.<Specification<JpaUser>>any());
//        assertThat(foundUser.isPresent()).isEqualTo(true);
//        assertThat(foundUser.isPresent() ? foundUser.get() : Optional.empty()).isEqualTo(user);
//    }
//
//    @DisplayName("UserService findByUsername not found")
//    @Test
//    public void givenNoUser_whenFind_thenReturnOptionalEmpty() {
//        // setup
//        given(repository.findOne(ArgumentMatchers.<Specification<JpaUser>>any()))
//                .willReturn(Optional.empty());
//
//        // action
//        Optional<JpaUser> foundUser = service.findByUsername(user.getEmail());
//
//        // verify
//        verify(repository, times(1)).findOne(ArgumentMatchers.<Specification<JpaUser>>any());
//        assertThat(foundUser.isPresent()).isEqualTo(false);
//        assertThat(foundUser.isPresent() ? foundUser.get() : Optional.empty())
//                .isEqualTo(Optional.empty());
//    }
//
//    @DisplayName("UserService findByUsernameLike")
//    @Test
//    public void givenUser_whenFindByUsernameLike_thenReturnListUser() {
//        List<JpaUser> toSaveUsers = List.of(new JpaUser.Builder("username1", "password1").build(),
//                new JpaUser.Builder("2username", "password2").build(),
//                new JpaUser.Builder("3username3", "password3").build(),
//                new JpaUser.Builder("4user4name", "password4").build());
//
//        given(repository.saveAll(ArgumentMatchers.<Iterable<JpaUser>>any())).willReturn(toSaveUsers);
//    }
//}
