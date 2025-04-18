import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudents {
    public static void display() {
        try (Connection con = DBConnection.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("PRN\t\tName\t\tDepartment");
            while (rs.next()) {
                System.out.printf("%s\t%s\t%s\n",
                        rs.getString("prn"),
                        rs.getString("name"),
                        rs.getString("department"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
