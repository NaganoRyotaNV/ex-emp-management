package com.example.repository;

import com.example.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * employeesテーブルを操作するrepositoryです.
 */
@Repository
public class EmployeeRepository {
    /**
     * SQLを実行するためのテンプレートです.
     */
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);

    /**
     * 全ての従業員情報を入社日の降順で取得します.
     *
     * @return 従業員情報のリスト。存在しない場合はnull。
     */
    public List<Employee> findAll() {
        String sql = """
                SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees
                ORDER BY hire_date DESC;
                """;
        List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);

        if (employeeList.isEmpty()) {
            return null;
        }

        return employeeList;
    }

    /**
     * 指定されたIDに一致する従業員情報を取得します.
     *
     * @param id 従業員ID。
     * @return 一致する従業員情報。
     */
    public Employee findById(Integer id) {
        String sql = """
                SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees
                WHERE id = :id;
                """;

        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

        return employee;
    }

    /**
     * 従業員情報を更新します.
     *
     * @param employee 更新する従業員情報。
     */
    public void update(Employee employee) {

        SqlParameterSource param = new BeanPropertySqlParameterSource(employee);

        String updateSql = """
                UPDATE employees SET name = :name, image = :image, gender = :gender, hire_date = :hireDate, mail_address = :mailAddress, zip_code = :zipCode, address = :address, telephone = :telephone, salary = :salary, characteristics = :characteristics, dependents_count = :dependentsCount WHERE id = :id
                """;
        template.update(updateSql, param);
    }

}
