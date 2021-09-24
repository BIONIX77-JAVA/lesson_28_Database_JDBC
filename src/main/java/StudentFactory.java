import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

class StudentFactory {

    final String[] studentsSecondName = new String[Surname.values().length];

    {
        for (int i = 0; i < Surname.values().length; i++)
            studentsSecondName[i] = Surname.values()[i].toString();
    }

    String[] studentsName = {"Mark", "Jennifer", "Fitch", "Tom", "Michel", "Kora", "Jessica", "Melania", "Donald",
            "Peter", "Poul", "George", "Dorothy", "Laurence", "Rosalinda", "Diana", "Timothy", "Hipster"};

    DecimalFormat df = new DecimalFormat("###.#");

    public Student toCreateStudent() {
        Student student = new Student();
        SecureRandom rnd = new SecureRandom();
        student.id = rnd.nextInt(2000000);
        student.name = studentsName[rnd.nextInt(studentsName.length)];
        student.secondName = studentsSecondName[rnd.nextInt(studentsSecondName.length)];
        student.age = rnd.nextInt(9) + 22;
        student.squad = rnd.nextInt(4) + 2;
        student.averageMark = ((3.00 + (12.00 - 3.00) * rnd.nextDouble()));
        return student;
    }
    public static String insertStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of the student");
        int id = sc.nextInt();
        System.out.println("Enter name of the student");
        String name = sc.next();
        System.out.println("Enter secondName of the student");
        String secondName = sc.next();
        System.out.println("Enter squad of the student");
        int squad = sc.nextInt();
        System.out.println("Enter age of the student");
        int age = sc.nextInt();
        System.out.println("Enter averageMark of the student");
        double averageMark = sc.nextDouble();
        return String.format(Locale.ROOT, "INSERT INTO 'students' VALUES(%d, '%s', '%s', %d, %d, %f)", id, name, secondName, squad, age, averageMark);
    }
}
enum Surname {
    Smith,
    Johnson,
    Williams,
    Jones,
    Brown,
    Davis,
    Miller,
    Wilson,
    Moore,
    Taylor,
    Anderson,
    Thomas,
    Jackson,
    White,
    Harris,
    Martin,
    Thompson,
    Wood,
    Lewis,
    Scott,
    Cooper,
    King
}