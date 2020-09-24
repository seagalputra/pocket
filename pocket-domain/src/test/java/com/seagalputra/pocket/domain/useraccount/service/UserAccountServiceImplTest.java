package com.seagalputra.pocket.domain.useraccount.service;

import com.seagalputra.pocket.api.useraccount.UserAccountService;
import com.seagalputra.pocket.api.useraccount.request.CreateUserRequest;
import com.seagalputra.pocket.api.useraccount.response.UserAccountResponse;
import com.seagalputra.pocket.domain.DomainConfiguration;
import com.seagalputra.pocket.domain.useraccount.entity.UserAccount;
import com.seagalputra.pocket.domain.useraccount.repository.UserAccountRepository;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestExecution;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DomainConfiguration.class)
@ActiveProfiles("test")
class UserAccountServiceImplTest {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldInsertedUserAccount() {

        String userId = "a5a30c2f-4acf-43e4-afc0-a8005c8cf959";
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@email.com";
        String password = "password";

        CreateUserRequest request = CreateUserRequest.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();

        userAccountService.insertUserAccount(request);
        UserAccount actual = userAccountRepository.findByUserId(userId)
                .orElseGet(() -> UserAccount.builder().build());

        assertEquals(firstName, actual.getFirstName());
        assertEquals(lastName, actual.getLastName());
        assertEquals(userId, actual.getUserId());
        assertEquals(email, actual.getEmail());
        assertTrue(passwordEncoder.matches(password, actual.getPassword()));
    }

    @Test
    void shouldFindUserByUserId() {

        String userId = "a5a30c2f-4acf-43e4-afc0-a8005c8cf959";

        UserAccountResponse actual = userAccountService.findUserById(userId);

        assertEquals(userId, actual.getUserId());
    }
}