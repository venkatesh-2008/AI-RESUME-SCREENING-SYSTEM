import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel lblTitle, lblUser, lblPass;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin, btnExit;

    public LoginFrame() {

        setTitle("AI Resume Screening System - Login");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblTitle = new JLabel("AI Resume Screening System");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(70, 20, 300, 30);
        add(lblTitle);

        lblUser = new JLabel("Username:");
        lblUser.setBounds(50, 80, 100, 25);
        add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(150, 80, 200, 25);
        add(txtUser);

        lblPass = new JLabel("Password:");
        lblPass.setBounds(50, 120, 100, 25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(150, 120, 200, 25);
        add(txtPass);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(90, 180, 100, 35);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnExit = new JButton("Exit");
        btnExit.setBounds(220, 180, 100, 35);
        btnExit.addActionListener(this);
        add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLogin) {

            login();

        } else if (e.getSource() == btnExit) {

            System.exit(0);
        }
    }

    private void login() {

        String username = txtUser.getText();
        String password = String.valueOf(txtPass.getPassword());

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection con = Database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(this, "Login Successful");

                new DashboardFrame().setVisible(true);

                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");

            }

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(this,
                    "Database Connection Error");

        }

    }
}