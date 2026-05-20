package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理者関連機能の処理の制御を行うコントローラ
 */

@Controller
@RequestMapping("/")

public class AdministratorController {
    /**
     * 管理者処理サービス
     */
    @Autowired
    private AdministratorService administratorService;
    /**
     * セッション情報
     */
    @Autowired
    HttpSession session;

    /**
     *
     * 管理者登録画面へ遷移します。
     */
    @GetMapping("/to-insert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    /**
     *
     * 管理者情報を登録します。
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/";
    }

    /**
     * ログイン画面に遷移します
     */
    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }

    /**
     * ログイン処理を行います
     */
    @PostMapping("/login")
    public String login(LoginForm form, Model model) {
        Administrator administratorName = administratorService.login(form.getMailAddress(), form.getPassword());

        if (administratorName == null) {
            String message = "メールアドレスまたはパスワードが不正です";
            model.addAttribute("message", message);
            return "administrator/login";
        }
        session.setAttribute("administratorName", administratorName);
        return "redirect:/employee/show-list";
    }
}