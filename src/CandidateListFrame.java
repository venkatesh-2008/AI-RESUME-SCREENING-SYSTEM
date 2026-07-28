import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CandidateListFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public CandidateListFrame() {

        setTitle("Candidate List");
        setSize(900, 450);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Phone");
        model.addColumn("Skills");
        model.addColumn("Experience");

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        loadCandidates();
    }

    private void loadCandidates() {

        CandidateDAO dao = new CandidateDAO();

        ArrayList<Candidate> list = dao.getAllCandidates();

        for (Candidate c : list) {

            model.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getEmail(),
                    c.getPhone(),
                    c.getSkills(),
                    c.getExperience()
            });

        }

    }

}