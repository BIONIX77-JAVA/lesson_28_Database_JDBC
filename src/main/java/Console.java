import java.sql.SQLException;
import java.util.Scanner;

public class Console {

    public static void RunConsole(){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";

        while (!"9".equals(s)) {
            System.out.println();
            System.out.println("<<<<<<<<<Students console menu >>>>>>>>>>\n");
            System.out.println("1. To create new table 'students' enter -  1");
            System.out.println("2. To delete table 'students' enter -   2");
            System.out.println("3. To create student and full table enter -  3");
            System.out.println("4. To print sorted by name table enter -  4");
            System.out.println("5. Add to table 10 random students (only to test) enter -  5");
            System.out.println("6. To change average mark of student enter -  6");
            System.out.println("7. To delete student from a table enter  -  7");
            System.out.println("8. To print  table enter -  8");
            System.out.println("9. To finish enter -9");
            System.out.println("<<<<<<<<    make your choice   >>>>>>>>>>\n");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Wrong input information");
            }

            switch (x) {
                case 1:
                    try {
                        TableActions.CreateDB();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        TableActions.DropTable();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Enter num of students");
                    try {
                        TableActions.WriteStudent(scan.nextInt());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        TableActions.PrintSortedByNameTable();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Enter num of random students");
                    TableActions.WriteRandom(scan.nextInt());
                    break;
                case 6:
                    System.out.println("Enter name and new average mark of student");
                    try {
                        TableActions.ChangeAverageMark(scan.next(), scan.nextDouble());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Enter name  of student your want to delete");
                    try {
                        TableActions.DeleteStudent(scan.next());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 8:
                    try {
                        TableActions.ReadTable();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        TableActions.CloseDB();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("You insert incorrect data");
            }
        }
        System.out.println("Wish you luck!");

    }
}