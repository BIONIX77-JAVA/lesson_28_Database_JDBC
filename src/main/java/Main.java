import java.sql.*;
public class Main {


    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void run() throws SQLException, ClassNotFoundException {
        TableActions.setConnection();
        Console.RunConsole();
    }
}