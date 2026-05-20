package com.example.form;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class InsertAdministratorForm {
    private String name;
    private String mailAddress;
    private String password;
}
