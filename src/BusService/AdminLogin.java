package BusService;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

 public class AdminLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldAdmin;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLogin frame = new AdminLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AdminLogin() {
        setFont(new Font("Dialog", Font.BOLD, 17));
        setTitle("Admin Login - IrfanBusService");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 733, 388);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Admin LogIn");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setToolTipText("");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(144, 63, 320, 45);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("AdminName");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_1.setBounds(20, 118, 151, 39);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_1_1.setBounds(20, 193, 151, 39);
        contentPane.add(lblNewLabel_1_1);

        textFieldAdmin = new JTextField();
        textFieldAdmin.setBounds(236, 129, 228, 28);
        contentPane.add(textFieldAdmin);
        textFieldAdmin.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(236, 193, 228, 28);
        contentPane.add(passwordField);

        JButton btnLogIn = new JButton("LogIn");
        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                String adminName = textFieldAdmin.getText();
                String password = new String(passwordField.getPassword());

                // Add your login logic here. For example:
                if(adminName.equals("Admin123") && password.equals("@Admin123")) {
                    // Display success message or navigate to the next screen
                    System.out.println("Admin login successful");

                    // Navigate to AdminDashboard frame
                    AdminDashboard adminDashboardFrame = new AdminDashboard();
                    adminDashboardFrame.setVisible(true);
                    dispose(); // Close the login frame
                } else {
                    // Display error message
                    System.out.println("Invalid admin name or password");
                }
            }
        });
        btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogIn.setBounds(205, 254, 85, 39);
        contentPane.add(btnLogIn);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldAdmin.setText("");
                passwordField.setText("");
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnReset.setBounds(412, 254, 85, 39);
        contentPane.add(btnReset);
    }}
