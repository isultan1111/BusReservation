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

public class User extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldUser;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User frame = new User();
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
    public User() {
        setFont(new Font("Dialog", Font.BOLD, 17));
        setTitle("IrfanBusService");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 733, 388);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("UserLogIn");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setToolTipText("");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(144, 63, 320, 45);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("UserName");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_1.setBounds(20, 118, 151, 39);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_1_1.setBounds(20, 193, 151, 39);
        contentPane.add(lblNewLabel_1_1);

        textFieldUser = new JTextField();
        textFieldUser.setBounds(236, 129, 228, 28);
        contentPane.add(textFieldUser);
        textFieldUser.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(236, 193, 228, 28);
        contentPane.add(passwordField);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldUser.setText("");
                passwordField.setText("");
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnReset.setBounds(412, 254, 85, 39);
        contentPane.add(btnReset);

        JLabel lblNewLabel_2 = new JLabel("_____WelcomeToIrfanBusService______");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2.setBounds(92, 10, 457, 13);
        contentPane.add(lblNewLabel_2);
        
        JButton btnAdminLogIn = new JButton("AdminLogIn");
        btnAdminLogIn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                AdminLogin adminFrame = new AdminLogin();
                adminFrame.setVisible(true);
            }
        });
        btnAdminLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAdminLogIn.setBounds(20, 254, 151, 39);
        contentPane.add(btnAdminLogIn);
        //logIn//
        JButton btnLogIn = new JButton("LogIn");
        btnLogIn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                    String username = textFieldUser.getText();
                    String password = new String(passwordField.getPassword());

                    if (username.equals("user1") && password.equals("****")) {
                    	 System.out.println(" login successful");
                        BusSearch busSearchFrame = new BusSearch();
                        busSearchFrame.setVisible(true);
                        dispose();
                    } else {
                    	System.out.println(" Invailid UserName or Password");
                    }
                }
        	
        		
        		
        		
        	
        });
        btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogIn.setBounds(271, 254, 85, 39);
        contentPane.add(btnLogIn);
    }
}
