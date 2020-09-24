package com.seagalputra.pocket.domain.useraccount.processor;

import com.seagalputra.pocket.domain.useraccount.entity.UserAccount;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserAccountItemProcessor implements ItemProcessor<UserAccount, UserAccount> {
    @Override
    public UserAccount process(UserAccount userAccount) throws Exception {

        String userId = UUID.randomUUID().toString();

        return UserAccount.builder()
                .userId(userId)
                .firstName(userAccount.getFirstName())
                .lastName(userAccount.getLastName())
                .email(userAccount.getEmail())
                .password(userAccount.getPassword())
                .build();
    }
}
