package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 管理者関連機能の業務処理を行うサービスです.
 */

@Service
@Transactional

public class AdministratorService {
    /**
     * 管理者情報を操作するリポジトリです.
     */
    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 管理者情報を新規登録します.
     *
     * @param administrator 登録する管理者情報。
     */
    public void insert(Administrator administrator) {
        administratorRepository.insert(administrator);
    }

    /**
     * メールアドレスとパスワードでログイン認証を行います.
     *
     * @param mailAddress メールアドレス。
     * @param password パスワード。
     * @return 認証に成功した管理者情報。失敗した場合はnull。
     */
    public Administrator login(String mailAddress, String password) {
        return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
    }


}
