import java.sql.SQLException;

public class DbTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        TableActions.setConnection();
        TableActions.CreateDB();
        TableActions.WriteStudent(1);
        TableActions.ReadTable();
        TableActions.WriteRandom(3);
        TableActions.ChangeAverageMark("Tom",3.0);
        TableActions.DeleteStudent("Tom");
        TableActions.DropTable();
        TableActions.PrintSortedByNameTable();
        TableActions.ReadTable();
        TableActions.CloseDB();
    }
}