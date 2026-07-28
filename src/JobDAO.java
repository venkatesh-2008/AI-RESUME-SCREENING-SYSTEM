import java.sql.*;
import java.util.ArrayList;

public class JobDAO {

    public boolean saveJob(Job job) {

        String sql = "INSERT INTO jobs(title,description) VALUES(?,?)";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getDescription());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Job> getAllJobs() {

        ArrayList<Job> list = new ArrayList<>();

        String sql = "SELECT * FROM jobs";

        try (Connection con = Database.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Job job = new Job();

                job.setId(rs.getInt("id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));

                list.add(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}