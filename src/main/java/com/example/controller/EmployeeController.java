package com.example.controller;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 従業員情報に関するリクエストを処理するコントローラです.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    /**
     * 従業員情報の取得や更新などを行うサービスです.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員一覧画面を表示します.
     *
     * @param model 画面に表示する従業員一覧を保持するモデル。
     * @return 従業員一覧画面。
     */
    @GetMapping("/show-list")
    public String showList(Model model) {
        model.addAttribute("employeeList", employeeService.showList());
        return "employee/list";
    }

    /**
     * 従業員詳細画面を表示します.
     *
     * @param id 従業員ID。
     * @param model 画面に表示する従業員情報を保持するモデル。
     * @param form 従業員情報更新フォーム。
     * @return 従業員詳細画面。
     */
    @GetMapping("/show-detail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        form.setId(id);
        form.setDependentsCount(String.valueOf(employee.getDependentsCount()));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    /**
     * 従業員の扶養人数を更新します.
     *
     * @param form 従業員情報更新フォーム。
     * @return 従業員一覧画面へリダイレクト。
     */
    @PostMapping("/update")
    public String update(UpdateEmployeeForm form) {
        employeeService.updateDependentsCount(
                Integer.parseInt(form.getId()),
                Integer.parseInt(form.getDependentsCount()));
        return "redirect:/employee/show-list";
    }

}
