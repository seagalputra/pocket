package com.seagalputra.pocket.domain.useraccount.repository;

import com.seagalputra.pocket.domain.useraccount.entity.UserAccount;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserAccountItemWriter implements ItemWriter<UserAccount> {

    private final UserAccountRepository userAccountRepository;

    @Override
    public void write(List<? extends UserAccount> list) throws Exception {
        userAccountRepository.saveAll(list);
    }
}
