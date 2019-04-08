package jdbcExample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// wczesniej wlaczyc xampp
public class JdbcMain {
// serverTimezone- wymusza zgodnosc z baza danych pomiedzy strefami czasowymi
    public static final String URL = "jdbc:mysql://localhost:3306/tarr4_db?serverTimezone=UTC";     // adres do tabeli w bazie danych  // ctrl+alt+c
    public static final String USER = "klient";     // nzwa user - dostep do bazy danych sql
    public static final String PASSWORD = "123";   // hasło do bazy danych sql

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
