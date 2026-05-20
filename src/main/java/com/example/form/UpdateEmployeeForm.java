package com.example.form;

import lombok.*;

/**
 * 従業員情報を更新する際に使用するフォームです.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateEmployeeForm {
    /**
     * 従業員ID.
     */
    private String id;
    /**
     * 扶養人数.
     */
    private String dependentsCount;
}
