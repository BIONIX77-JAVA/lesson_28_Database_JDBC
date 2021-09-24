import java.sql.*;
import java.util.Locale;


public class TableActions {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet cursor;
    public static PreparedStatement preparedStatement;

    // -------- DATABASE CONNECTION --------
    public static void setConnection() throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Table28Hillel.db");
        connection.setAutoCommit(false);

        System.out.println("The base is connected!");
    }

    // --------- CREATING A TABLE --------
    public static void CreateDB() throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'students' " +
                "(id INTEGER, name VARCHAR(100), secondName VARCHAR(100), squad INTEGER, age INTEGER, averageMark DOUBLE)");
        System.out.println("The table is created or already exists.");
    }

    // ------------DROP A TABLE-----------------
    public static void DropTable() throws SQLException {
        statement.executeUpdate("drop table if exists students;");
    }

    // -------- ENTERING DATA INTO TABLE --------
    public static void WriteStudent(int numOfStud) throws SQLException {
        for (int i = 0; i < numOfStud; i++) {
            statement.executeUpdate(StudentFactory.insertStudent());
            connection.commit();
        }
        System.out.println("The table is full.");
    }

    // -------------SORT A TABLE---------------
    public static void PrintSortedByNameTable() throws SQLException {
        cursor = statement.executeQuery("SELECT * FROM students order by name asc;");
        while (cursor.next()) {
            System.out.println(
                    "id = " + cursor.getInt("id") + " | " +
                            "name = " + cursor.getString("name") + " | " +
                            "secondName = " + cursor.getString("secondName") + " | " +
                            "squad number = " + cursor.getInt("squad") + " | " +
                            "age = " + cursor.getInt("age") + " | " +
                            "average mark = " + cursor.getInt("averageMark"));
        }
        connection.commit();
        System.out.println("----------YOUR TABLE SORTED AND PRINTED------------");
    }

    // -------- PRINT A TABLE--------
    public static void ReadTable() throws SQLException {
        cursor = statement.executeQuery("SELECT * FROM 'students'");
        while (cursor.next()) {
            System.out.println(
                    "id = " + cursor.getInt("id") + " | " +
                            "name = " + cursor.getString("name") + " | " +
                            "secondName = " + cursor.getString("secondName") + " | " +
                            "squad number = " + cursor.getInt("squad") + " | " +
                            "age = " + cursor.getInt("age") + " | " +
                            "average mark = " + cursor.getInt("averageMark"));
        }
        System.out.println("Table printed");
    }

    //------CHANGE INFORMATION ABOUT STUDENT(only averageMark)--------------
    public static void ChangeAverageMark(String name, double averageMark) throws SQLException {
        statement.executeUpdate("UPDATE 'students' set averageMark= "+" "+averageMark+" "+"where name like '"+name+"';");
        connection.commit();
    }

    // delete INFORMATION ABOUT STUDENT
    public static void DeleteStudent(String name) throws SQLException {
        {
            statement.executeUpdate("DELETE from students where name=" +"'"+ name+"';");
            connection.commit();
        }
    }
    //------- add random students--------------

    public static void WriteRandom(int numRandomStud) {
        StudentFactory newStudent = new StudentFactory();
        Student[] student = new Student[numRandomStud];
        for (
                int i = 0;
                i < student.length; i++) {
            student[i] = newStudent.toCreateStudent();
            String cadet = String.format(Locale.ROOT, "INSERT INTO 'students' VALUES(%d, '%s', '%s', %d, %d, %f)",
                    student[i].id, student[i].name, student[i].secondName, student[i].squad, student[i].age, student[i].averageMark);
            try {
                statement.executeUpdate(cadet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    // --------CLOSE--------
    public static void CloseDB() throws SQLException {
        connection.close();
        statement.close();
        cursor.close();

        System.out.println("Connections closed.");
    }
}