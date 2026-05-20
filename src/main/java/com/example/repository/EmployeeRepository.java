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

@Repository


public class EmployeeRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);

    public List<Employee> findALL() {
        String sql = """
                SELECT id, name, image, gender, hire_date, mail_address, zip_code, telephone, salary, characteristics, dependents_count FROM employees 
                ORDER BY hire_date DESC;
                """;
        List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);

        if (employeeList.isEmpty()) {
            return null;
        }

        return employeeList;
    }

    public Employee findById(Integer id) {
        String sql = """
                SELECT id, name, image, gender, hire_date, mail_address, zip_code, telephone, salary, characteristics, dependents_count FROM employees 
                WHERE id = :id;
                """;

        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

        return employee;
    }

    public void update(Employee employee) {

        SqlParameterSource param = new BeanPropertySqlParameterSource(employee);

        String updateSql = """
                UPFATE employees SET name = :name, image = :image, gender = :gender, hire_date = :hire_date, mail_address = :mail_address, zip_code = :zip_code, telephone = :telephone, salary = :salary, characteristics = :characteristics, dependents_count = :dependents_count WEHERE id = :id
                """;
        template.update(updateSql, param);
    }

}
