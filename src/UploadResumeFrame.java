import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class UploadResumeFrame extends JFrame implements ActionListener {

    JButton btnChoose;

    JTextField txtFile;

    public UploadResumeFrame() {

        setTitle("Upload Resume");

        setSize(600,180);

        setLocationRelativeTo(null);

        setLayout(null);

        txtFile = new JTextField();

        txtFile.setBounds(30,40,380,30);

        add(txtFile);

        btnChoose = new JButton("Browse");

        btnChoose.setBounds(430,40,100,30);

        btnChoose.addActionListener(this);

        add(btnChoose);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION){

            File file = chooser.getSelectedFile();

            txtFile.setText(file.getAbsolutePath());

            JOptionPane.showMessageDialog(this,
                    "Resume Selected Successfully");

        }

    }

}