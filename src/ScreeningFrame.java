import javax.swing.*;
import java.awt.event.*;

public class ScreeningFrame extends JFrame implements ActionListener {

    JTextArea txtJob;

    JTextArea txtResume;

    JTextArea txtResult;

    JButton btnAnalyze;

    public ScreeningFrame() {

        setTitle("AI Resume Screening");

        setSize(800,600);

        setLocationRelativeTo(null);

        setLayout(null);

        txtJob = new JTextArea();

        txtResume = new JTextArea();

        txtResult = new JTextArea();

        btnAnalyze = new JButton("Analyze");

        JScrollPane sp1 = new JScrollPane(txtJob);
        JScrollPane sp2 = new JScrollPane(txtResume);
        JScrollPane sp3 = new JScrollPane(txtResult);

        sp1.setBounds(20,20,350,180);
        sp2.setBounds(400,20,350,180);
        sp3.setBounds(20,250,730,250);

        btnAnalyze.setBounds(320,520,150,35);

        add(sp1);
        add(sp2);
        add(sp3);
        add(btnAnalyze);

        btnAnalyze.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ScreeningResult result =
                GeminiAPI.analyzeResume(
                        txtResume.getText(),
                        txtJob.getText());

        txtResult.setText(

                "Score : " + result.getScore()

                        + "\n\nRecommendation : "

                        + result.getRecommendation()

                        + "\n\nRemarks : "

                        + result.getRemarks()

        );

    }

}