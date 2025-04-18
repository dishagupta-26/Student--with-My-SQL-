import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {
    public static void delete() {
        try (Scanner sc = new Scanner(System.in);
                Connection con = DBConnection.getConnection()) {

            System.out.print("Enter PRN to delete: ");
            String prn = sc.nextLine();

            String query = "DELETE FROM students WHERE prn = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, prn);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted successfully!" : "Student not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
