import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchStudentByPRN {
    public static void search() {
        try (Scanner sc = new Scanner(System.in);
                Connection con = DBConnection.getConnection()) {

            System.out.print("Enter PRN to search: ");
            String prn = sc.nextLine();

            String query = "SELECT * FROM students WHERE prn = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, prn);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.printf("PRN: %s\nName: %s\nDepartment: %s\n",
                        rs.getString("prn"),
                        rs.getString("name"),
                        rs.getString("department"));
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
