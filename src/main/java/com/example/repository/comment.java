//package com.example.repository;
//
//import com.example.domain.Administrator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
/// **
// * administratorsテーブルを操作するリポジトリクラス.
// * * 管理者情報の登録や、メールアドレスとパスワードによる検索機能を提供します。
// *
// * @author あなたの名前（必要であれば）
// */
//@Repository
//public class AdministratorRepository {
//
//    /** NamedParameterJdbcTemplateのインスタンス */
//    @Autowired
//    private NamedParameterJdbcTemplate template;
//
//    /** administratorsテーブルの結果をAdministratorドメインにマッピングするRowMapper */
//    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER =
//            new BeanPropertyRowMapper<>(Administrator.class);
//
//    /**
//     * 管理者情報をデータベースに登録します.
//     * * @param administrator 登録する管理者情報
//     */
//    public void insert(Administrator administrator) {
//        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
//        String sql = """
//                INSERT INTO administrators (name, mailAddress, password)
//                VALUES (:name, :mailAddress, :password);
//                """;
//        template.update(sql, param);
//    }
//
//    /**
//     * メールアドレスとパスワードから管理者情報を取得します.
//     * * 該当する管理者が存在しない場合は null を返します。
//     * * @param mailAddress メールアドレス
//     * @param password パスワード
//     * @return 該当する管理者情報（存在しない場合は null）
//     */
//    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
//        String sql = """
//                SELECT id, name, mailAddress, password
//                FROM administrators
//                WHERE mailAddress = :mailAddress AND password = :password
//                """;
//        SqlParameterSource param = new MapSqlParameterSource()
//                .addValue("mailAddress", mailAddress)
//                .addValue("password", password);
//
//        List<Administrator> administrator = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
//
//        if (administrator.isEmpty()) {
//            return null;
//        }
//
//        return administrator.getFirst();
//    }
//}