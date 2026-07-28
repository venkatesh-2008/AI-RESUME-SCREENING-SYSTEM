import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class RankingFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public RankingFrame() {

        setTitle("Candidate Ranking");
        setSize(800,500);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Candidate ID");
        model.addColumn("Job ID");
        model.addColumn("Score");
        model.addColumn("Remarks");

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        loadRanking();
    }

    private void loadRanking() {

        String sql =
                "SELECT candidateId,jobId,score,remarks " +
                "FROM screening_results ORDER BY score DESC";

        try (Connection con = Database.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("candidateId"),
                        rs.getInt("jobId"),
                        rs.getDouble("score"),
                        rs.getString("remarks")

                });

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}