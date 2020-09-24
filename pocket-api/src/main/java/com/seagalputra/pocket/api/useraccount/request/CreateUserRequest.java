package com.seagalputra.pocket.api.useraccount.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateUserRequest {

    @JsonIgnore
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
