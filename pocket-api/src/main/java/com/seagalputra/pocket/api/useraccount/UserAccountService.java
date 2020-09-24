package com.seagalputra.pocket.api.useraccount;

import com.seagalputra.pocket.api.useraccount.request.CreateUserRequest;
import com.seagalputra.pocket.api.useraccount.response.UserAccountResponse;

public interface UserAccountService {
    void insertUserAccount(CreateUserRequest request);
    UserAccountResponse findUserById(String userId);
}
