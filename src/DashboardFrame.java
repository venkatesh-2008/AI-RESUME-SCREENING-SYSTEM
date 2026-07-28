import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardFrame extends JFrame implements ActionListener {

    JButton btnCandidate;
    JButton btnJob;
    JButton btnUpload;
    JButton btnScreen;
    JButton btnRanking;
    JButton btnReport;
    JButton btnLogout;

    public DashboardFrame() {

        setTitle("Dashboard");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 2, 15, 15));

        btnCandidate = new JButton("Candidates");
        btnJob = new JButton("Job Description");
        btnUpload = new JButton("Upload Resume");
        btnScreen = new JButton("AI Screening");
        btnRanking = new JButton("Candidate Ranking");
        btnReport = new JButton("Generate Report");
        btnLogout = new JButton("Logout");

        add(btnCandidate);
        add(btnJob);
        add(btnUpload);
        add(btnScreen);
        add(btnRanking);
        add(btnReport);
        add(btnLogout);

        btnCandidate.addActionListener(this);
        btnJob.addActionListener(this);
        btnUpload.addActionListener(this);
        btnScreen.addActionListener(this);
        btnRanking.addActionListener(this);
        btnReport.addActionListener(this);
        btnLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCandidate) {

            new CandidateListFrame().setVisible(true);

        } else if (e.getSource() == btnJob) {

            new JobDescriptionFrame().setVisible(true);

        } else if (e.getSource() == btnUpload) {

            new UploadResumeFrame().setVisible(true);

        } else if (e.getSource() == btnScreen) {

            new ScreeningFrame().setVisible(true);

        } else if (e.getSource() == btnRanking) {

            new RankingFrame().setVisible(true);

        } else if (e.getSource() == btnReport) {

            JOptionPane.showMessageDialog(this,
                    "Report generation coming soon.");

        } else if (e.getSource() == btnLogout) {

            dispose();
            new LoginFrame().setVisible(true);
        }

    }
}