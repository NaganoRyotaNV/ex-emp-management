package com.example.domain;

import lombok.*;

/**
 * Administratorドメインの定義.
 * 管理者情報を示すドメインクラスadministratorsテーブルに対応。
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Administrator {
    private Integer id;
    private String name;
    private String mailAddress;
    private String password;
}
