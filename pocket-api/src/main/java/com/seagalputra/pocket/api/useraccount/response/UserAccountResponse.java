package com.seagalputra.pocket.api.useraccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserAccountResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
