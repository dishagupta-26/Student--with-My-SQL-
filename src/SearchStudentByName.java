import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchStudentByName {
    public static void search() {
        try (Scanner sc = new Scanner(System.in);
                Connection con = DBConnection.getConnection()) {

            System.out.print("Enter name to search: ");
            String name = sc.nextLine();

            String query = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.printf("PRN: %s\tName: %s\tDepartment: %s\n",
                        rs.getString("prn"),
                        rs.getString("name"),
                        rs.getString("department"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
