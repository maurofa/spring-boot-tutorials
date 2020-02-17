package com.sivalabs.myservice.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import com.sivalabs.myservice.common.PostgreSQLContainerInitializer;
import com.sivalabs.myservice.entities.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = {PostgreSQLContainerInitializer.class})
class UserRepositoryTest {

    @Autowired
	TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldReturnUserGivenValidCredentials() {
        User user = new User(null, "test@gmail.com", "test", "Test");
        entityManager.persist(user);
        Optional<User> userOptional = userRepository.login("test@gmail.com", "test");
        assertThat(userOptional).isNotEmpty();
    }
}
