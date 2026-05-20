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
 * 管理者の登録・ログインに関するリクエストを処理するコントローラです.
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
    /**
     * 管理者情報の登録およびログイン処理を行うサービスです.
     */
    @Autowired
    private AdministratorService administratorService;
    /**
     * ログイン中の管理者情報を保持するセッションです.
     */
    @Autowired
    HttpSession session;

    /**
     * 管理者登録画面を表示します.
     *
     * @param form 管理者登録フォーム。
     * @return 管理者登録画面。
     */
    @GetMapping("/to-insert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    /**
     * 入力された管理者情報を登録します.
     *
     * @param form 管理者登録フォーム。
     * @return ログイン画面へリダイレクト。
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/";
    }

    /**
     * ログイン画面を表示します.
     *
     * @param form ログインフォーム。
     * @return ログイン画面。
     */
    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }

    /**
     * 入力されたメールアドレスとパスワードでログイン認証を行います.
     *
     * @param form ログインフォーム。
     * @param model 画面に表示するメッセージを保持するモデル。
     * @return 認証に成功した場合は従業員一覧画面へリダイレクト、失敗した場合はログイン画面。
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

    /**
     * ログアウト処理を行います.
     *
     * @param session 現在のセッション情報。
     * @return ログイン画面へリダイレクト。
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
