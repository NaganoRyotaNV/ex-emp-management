package com.example.form;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class LoginForm {
    private String mailAddress;
    private String password;
}
