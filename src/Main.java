// Name: Disha Deepak Gupta
// PRN: 24070126513
// Batch: A2

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Student Data Entry System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> AddStudent.add();
                case 2 -> DisplayStudents.display();
                case 3 -> SearchStudentByPRN.search();
                case 4 -> SearchStudentByName.search();
                case 5 -> UpdateStudent.update();
                case 6 -> DeleteStudent.delete();
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid Choice.");
            }
        }
    }
}
