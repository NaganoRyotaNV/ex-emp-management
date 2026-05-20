package com.example.repository;

import com.example.domain.Administrator;
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
 * administratorsテーブルを操作するrepository.
 */
@Repository
public class AdministratorRepository {

    /**
     * SQLを実行するためのテンプレートです.
     */
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER =
            new BeanPropertyRowMapper<>(Administrator.class);

    /**
     * 管理者情報を新規登録します.
     *
     * @param administrator 登録する管理者情報。
     */
    public void insert(Administrator administrator) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        String sql = """
                INSERT INTO administrators (name, mail_address, password) VALUES (:name, :mailAddress, :password);
                """;
        template.update(sql, param);
    }

    /**
     * メールアドレスとパスワードに一致する管理者情報を取得します.
     *
     * @param mailAddress メールアドレス。
     * @param password パスワード。
     * @return 一致する管理者情報。存在しない場合はnull。
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        System.out.println(mailAddress + ":" + password);
        String sql = """
                SELECT id,name,mail_Address,password FROM administrators WHERE mail_Address = :mailAddress AND password = :password
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);

        List<Administrator> administrator = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);

        if (administrator.isEmpty()) {
            return null;
        }

        return administrator.getFirst();
    }

}
