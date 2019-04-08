package jdbcExample1;

import java.sql.*;

// wczesniej wlaczyc xampp
public class JdbcMain {
// serverTimezone- wymusza zgodnosc z baza danych pomiedzy strefami czasowymi
    public static final String URL = "jdbc:mysql://localhost:3306/tarr4_db?serverTimezone=UTC";     // adres do tabeli w bazie danych  // ctrl+alt+c
    public static final String USER = "klient";     // nzwa user - dostep do bazy danych sql
    public static final String PASSWORD = "123";   // hasło do bazy danych sql
    public static final String SQL = "select * from zawodnicy where nazwisko = 'MALYSZ'";
// prepare statment - jest zabezpieczony na ataki sql injection-wstrzykiwanie sql
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            DatabaseMetaData metaData = connection.getMetaData();  // zczytuje dane  informacje o danych, np, wersja bazy danych, informacje ,werjse driverowi itp
            if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE))
                System.out.println("kotek");

            //CONCUR_READ_ONLY,ResultSet.CONCUR_UPDATABLE - pytamy czy jest tego typu
            // _FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE - ustawienie defualt, jak bedziemy przegladac wyniki to bedziemy mogli je przesuwac tlyko w jednoa storne do przodu,/ ca - oprucz przeczytania wynikow z sql, bedziemy mogli etez zmieniac dane w bazie danych/ // var. - wyciaga zmienna,generuje
            ResultSet resultSet = statement.executeQuery(SQL);         // executequery - do bazy danych wysle zapytanie sql, do bazy sql / executeUpdate- inser,update,delete-zrob cos w bazie danych w rekordzie
            while (resultSet.next()){
                String imie = resultSet.getString("imie");
                String nazwisko = resultSet.getString("nazwisko");
                int wzrost = resultSet.getInt("wzrost");
                System.out.println(imie + " " + nazwisko +" " + wzrost);
             //   resultSet.updateString("imie","Marcin");
                System.out.println(imie + " " + nazwisko +" " + wzrost);
            }
            ResultSet tables = metaData.getTables(null, null, "zawodnicy", null);// jesli jest null to pobierane sa wszystkie tablice ze wszystkich baz danych,jakie sa.
            while (tables.next()){
                String BazaDanych = tables.getString(1);
                String TableName = tables.getString(3);
                System.out.println(BazaDanych + " " + TableName);
            }
// ctrl + alt+v
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
