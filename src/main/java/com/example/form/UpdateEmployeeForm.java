package com.example.form;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateEmployeeForm {
    /**
     * 従業員ID
     */
    private String id;
    /**
     * 扶養人数
     */
    private String dependentsCount;
}
