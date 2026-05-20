package com.example.form;


import lombok.*;

/**
 * 管理者を新規登録する際に使用するフォームです
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class InsertAdministratorForm {
    /**
     * 名前
     */
    private String name;
    /**
     * メールアドレス
     */
    private String mailAddress;
    /**
     * パスワード
     */
    private String password;
}
