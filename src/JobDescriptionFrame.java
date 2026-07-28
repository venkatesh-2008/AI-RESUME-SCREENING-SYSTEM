import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JobDescriptionFrame extends JFrame implements ActionListener {

    JTextField txtTitle;

    JTextArea txtDescription;

    JButton btnSave;

    public JobDescriptionFrame() {

        setTitle("Job Description");

        setSize(600,500);

        setLocationRelativeTo(null);

        setLayout(null);

        JLabel lbl1 = new JLabel("Job Title");

        lbl1.setBounds(30,30,100,25);

        add(lbl1);

        txtTitle = new JTextField();

        txtTitle.setBounds(130,30,350,25);

        add(txtTitle);

        JLabel lbl2 = new JLabel("Description");

        lbl2.setBounds(30,80,100,25);

        add(lbl2);

        txtDescription = new JTextArea();

        JScrollPane sp = new JScrollPane(txtDescription);

        sp.setBounds(130,80,350,250);

        add(sp);

        btnSave = new JButton("Save");

        btnSave.setBounds(200,360,120,40);

        btnSave.addActionListener(this);

        add(btnSave);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Job job = new Job();

        job.setTitle(txtTitle.getText());

        job.setDescription(txtDescription.getText());

        JobDAO dao = new JobDAO();

        if(dao.saveJob(job)){

            JOptionPane.showMessageDialog(this,"Job Saved");

        }else{

            JOptionPane.showMessageDialog(this,"Failed");

        }

    }

}