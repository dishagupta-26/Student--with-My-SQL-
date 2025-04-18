import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {
    public static void update() {
        try (Scanner sc = new Scanner(System.in);
                Connection con = DBConnection.getConnection()) {

            System.out.print("Enter PRN to update: ");
            String prn = sc.nextLine();
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new department: ");
            String dept = sc.nextLine();

            String query = "UPDATE students SET name = ?, department = ? WHERE prn = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, dept);
            pstmt.setString(3, prn);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Student updated successfully!" : "Student not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
