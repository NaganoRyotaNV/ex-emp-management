package com.example.domain;

import lombok.*;

import java.util.Date;

/**
 * Employeeドメインの定義.
 * 従業員情報を示すドメインクラスで、employeesテーブルに対応。
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Employee {
    /**
     * 主キー.
     */
    private Integer id;
    /**
     * 従業員名.
     */
    private String name;
    /**
     * 画像.
     */
    private String image;
    /**
     * 性別.
     */
    private String gender;
    /**
     * 入社日.
     */
    private Date hireDate;
    /**
     * メールアドレス.
     */
    private String mailAddress;
    /**
     * 郵便番号.
     */
    private String zipCode;
    /**
     * 住所.
     */
    private String address;
    /**
     * 電話番号.
     */
    private String telephone;
    /**
     * 給料.
     */
    private Integer salary;
    /**
     * 特性.
     */
    private String characteristics;
    /**
     * 扶養人数.
     */
    private Integer dependentsCount;
}
