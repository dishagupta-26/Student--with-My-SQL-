import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStudent {
    public static void add() {
        try (Scanner sc = new Scanner(System.in);
                Connection con = DBConnection.getConnection()) {

            System.out.print("Enter PRN: ");
            String prn = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            String query = "INSERT INTO students (prn, name, department) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, prn);
            pstmt.setString(2, name);
            pstmt.setString(3, dept);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Student added successfully!" : "Failed to add student.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
