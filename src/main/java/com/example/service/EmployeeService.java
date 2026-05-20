package com.example.service;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 従業員関連機能の業務処理を行うサービスです.
 */
@Service
@Transactional
public class EmployeeService {
    /**
     * 従業員情報を操作するリポジトリです.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 従業員情報の一覧を取得します.
     *
     * @return 従業員情報のリスト。
     */
    public List<Employee> showList() {
        return employeeRepository.findAll();
    }

    /**
     * 指定されたIDに一致する従業員情報を取得します.
     *
     * @param id 従業員ID。
     * @return 一致する従業員情報。
     */
    public Employee showDetail(Integer id) {
        return employeeRepository.findById(id);
    }

    /**
     * 従業員の扶養人数を更新します.
     *
     * @param employeeId 従業員ID。
     * @param newCount 更新後の扶養人数。
     */
    public void updateDependentsCount(Integer employeeId, Integer newCount) {
        Employee employee = employeeRepository.findById(employeeId);
        employee.setDependentsCount(newCount);
        employeeRepository.update(employee);
    }

}
