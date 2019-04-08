package jdbcExample1;

import java.sql.*;

// wczesniej wlaczyc xampp
public class JdbcMain {
// serverTimezone- wymusza zgodnosc z baza danych pomiedzy strefami czasowymi
    public static final String URL = "jdbc:mysql://localhost:3306/tarr4_db?serverTimezone=UTC";     // adres do tabeli w bazie danych  // ctrl+alt+c
    public static final String USER = "klient";     // nzwa user - dostep do bazy danych sql
    public static final String PASSWORD = "123";   // hasło do bazy danych sql
    public static final String SQL = "select * from trenerzy";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();  // var. - wyciaga zmienna,generuje
            ResultSet resultSet = statement.executeQuery(SQL);  // executequery - do bazy danych wysle zapytanie sql, do bazy sql / executeUpdate- inser,update,delete-zrob cos w bazie danych w rekordzie
            while (resultSet.next()){
                String imie_t = resultSet.getString("imie_t");
                String nazwisko_t = resultSet.getString("nazwisko_t");
                int l_zawodnikow = resultSet.getInt("l_zawodnikow");
                System.out.println(imie_t + " " +nazwisko_t +" " + l_zawodnikow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
