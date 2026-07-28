import java.sql.*;
import java.util.ArrayList;

public class CandidateDAO {

    public boolean saveCandidate(Candidate candidate) {

        String sql = "INSERT INTO candidates(name,email,phone,skills,experience,resumePath) VALUES(?,?,?,?,?,?)";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, candidate.getName());
            ps.setString(2, candidate.getEmail());
            ps.setString(3, candidate.getPhone());
            ps.setString(4, candidate.getSkills());
            ps.setString(5, candidate.getExperience());
            ps.setString(6, candidate.getResumePath());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Candidate> getAllCandidates() {

        ArrayList<Candidate> list = new ArrayList<>();

        String sql = "SELECT * FROM candidates";

        try (Connection con = Database.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Candidate c = new Candidate();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setSkills(rs.getString("skills"));
                c.setExperience(rs.getString("experience"));
                c.setResumePath(rs.getString("resumePath"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}