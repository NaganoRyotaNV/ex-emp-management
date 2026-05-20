package com.example.domain;

import lombok.*;

import java.util.Date;

/**
 * Employeeドメインの定義.
 * 従業員情報を示すドメインクラスemployeesテーブルに対応。
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Employee {
    private Integer id;
    private String name;
    private String image;
    private String gender;
    private Date hireDate;
    private String mailAddress;
    private String zipCode;
    private String telephone;
    private Integer salary;
    private String characteristics;
    private Integer dependentsCount;

}
