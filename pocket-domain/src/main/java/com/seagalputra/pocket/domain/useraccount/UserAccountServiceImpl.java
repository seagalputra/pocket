package com.seagalputra.pocket.domain.useraccount;

import com.seagalputra.pocket.api.exception.NotFoundException;
import com.seagalputra.pocket.api.useraccount.UserAccountService;
import com.seagalputra.pocket.api.useraccount.request.CreateUserRequest;
import com.seagalputra.pocket.api.useraccount.response.UserAccountResponse;
import com.seagalputra.pocket.domain.useraccount.entity.UserAccount;
import com.seagalputra.pocket.domain.useraccount.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void insertUserAccount(CreateUserRequest request) {

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        UserAccount userAccount = UserAccount.builder()
                .userId(request.getUserId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(encodedPassword)
                .build();

        userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccountResponse findUserById(String userId) {
        Optional<UserAccount> savedUserAccount = userAccountRepository.findByUserId(userId);

        UserAccount userAccount = savedUserAccount
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found!"));

        return UserAccountResponse.builder()
                .userId(userAccount.getUserId())
                .firstName(userAccount.getFirstName())
                .lastName(userAccount.getLastName())
                .email(userAccount.getEmail())
                .build();
    }
}
