package com.example.form;

import lombok.*;

/**
 * ログイン時に送信される情報を格納するフォームです.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class LoginForm {
    /**
     * メールアドレス.
     */
    private String mailAddress;
    /**
     * パスワード.
     */
    private String password;
}
