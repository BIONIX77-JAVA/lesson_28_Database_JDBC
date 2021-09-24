public class print {
    public static void main(String[] args) {
        StudentFactory newStudent = new StudentFactory();
        Student student1 = new Student();
       student1 = newStudent.toCreateStudent();
        System.out.println(student1.id
        );

    }
}
