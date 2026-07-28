import java.sql.Connection;
import java.sql.PreparedStatement;

public class ScreeningDAO {

    public boolean saveResult(int candidateId,
                              int jobId,
                              ScreeningResult result) {

        String sql = "INSERT INTO screening_results(candidateId,jobId,score,remarks) VALUES(?,?,?,?)";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, candidateId);
            ps.setInt(2, jobId);
            ps.setDouble(3, result.getScore());
            ps.setString(4, result.getRemarks());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}