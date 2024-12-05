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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminDashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldBusNumber;
    private JTextField textFieldSource;
    private JTextField textFieldDestination;
    private JTextField textFieldDeparture;
    private JTextField textFieldArrival;
    private JTextField textFieldTotalSeats;
    private JTextField textFieldAvailableSeats;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminDashboard frame = new AdminDashboard();
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
    public AdminDashboard() {
        setFont(new Font("Dialog", Font.BOLD, 17));
        setTitle("Admin Dashboard - IrfanBusService");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Admin Dashboard");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(144, 20, 500, 45);
        contentPane.add(lblNewLabel);

        JLabel lblBusNumber = new JLabel("Bus Number");
        lblBusNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblBusNumber.setBounds(20, 80, 151, 30);
        contentPane.add(lblBusNumber);

        textFieldBusNumber = new JTextField();
        textFieldBusNumber.setBounds(200, 80, 200, 30);
        contentPane.add(textFieldBusNumber);
        textFieldBusNumber.setColumns(10);

        JLabel lblSource = new JLabel("Source");
        lblSource.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSource.setBounds(20, 130, 151, 30);
        contentPane.add(lblSource);

        textFieldSource = new JTextField();
        textFieldSource.setBounds(200, 130, 200, 30);
        contentPane.add(textFieldSource);
        textFieldSource.setColumns(10);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDestination.setBounds(20, 180, 151, 30);
        contentPane.add(lblDestination);

        textFieldDestination = new JTextField();
        textFieldDestination.setBounds(200, 180, 200, 30);
        contentPane.add(textFieldDestination);
        textFieldDestination.setColumns(10);

        JLabel lblDeparture = new JLabel("Departure Time");
        lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDeparture.setBounds(20, 230, 151, 30);
        contentPane.add(lblDeparture);

        textFieldDeparture = new JTextField();
        textFieldDeparture.setBounds(200, 230, 200, 30);
        contentPane.add(textFieldDeparture);
        textFieldDeparture.setColumns(10);

        JLabel lblArrival = new JLabel("Arrival Time");
        lblArrival.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblArrival.setBounds(20, 280, 151, 30);
        contentPane.add(lblArrival);

        textFieldArrival = new JTextField();
        textFieldArrival.setBounds(200, 280, 200, 30);
        contentPane.add(textFieldArrival);
        textFieldArrival.setColumns(10);

        JLabel lblTotalSeats = new JLabel("Total Seats");
        lblTotalSeats.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTotalSeats.setBounds(20, 330, 151, 30);
        contentPane.add(lblTotalSeats);

        textFieldTotalSeats = new JTextField();
        textFieldTotalSeats.setBounds(200, 330, 200, 30);
        contentPane.add(textFieldTotalSeats);
        textFieldTotalSeats.setColumns(10);

        JLabel lblAvailableSeats = new JLabel("Available Seats");
        lblAvailableSeats.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblAvailableSeats.setBounds(20, 380, 151, 30);
        contentPane.add(lblAvailableSeats);

        textFieldAvailableSeats = new JTextField();
        textFieldAvailableSeats.setBounds(200, 380, 200, 30);
        contentPane.add(textFieldAvailableSeats);
        textFieldAvailableSeats.setColumns(10);

        JButton btnAddBus = new JButton("Add Bus");
        btnAddBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBus();
            }
        });
        btnAddBus.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAddBus.setBounds(50, 439, 150, 40);
        contentPane.add(btnAddBus);
        
        // Button to navigate to User frame
        JButton btnGoToUser = new JButton("Go to User");
        btnGoToUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User userFrame = new User();
                userFrame.setVisible(true);
            }
        });
        btnGoToUser.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnGoToUser.setBounds(302, 497, 150, 40);
        contentPane.add(btnGoToUser);
        
        JButton btnUpdateBus = new JButton("Update Bus");
        btnUpdateBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBus();
            }
        });
        btnUpdateBus.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnUpdateBus.setBounds(302, 439, 150, 40);
        contentPane.add(btnUpdateBus);
        
        JButton btnRemoveBus = new JButton("Remove Bus");
        btnRemoveBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeBus();
            }
        });
        btnRemoveBus.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRemoveBus.setBounds(569, 439, 150, 40);
        contentPane.add(btnRemoveBus);
    }

    private void addBus() {
        String busNumber = textFieldBusNumber.getText();
        String source = textFieldSource.getText();
        String destination = textFieldDestination.getText();
        String departure = textFieldDeparture.getText();
        String arrival = textFieldArrival.getText();
        int totalSeats = Integer.parseInt(textFieldTotalSeats.getText());
        int availableSeats = Integer.parseInt(textFieldAvailableSeats.getText());

        Bus bus = new Bus(busNumber, source, destination, departure, arrival, totalSeats, availableSeats);
        saveBusToFile(bus, true); // Append mode
    }

    private void saveBusToFile(Bus bus, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buses.txt", append))) {
            bw.write(bus.toString());
            bw.newLine();
            System.out.println("Bus details saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeBusFromFile(String busNumber) {
        List<Bus> buses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("buses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Bus bus = Bus.fromString(line);
                if (!bus.getBusNumber().equals(busNumber)) {
                    buses.add(bus);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buses.txt"))) {
            for (Bus bus : buses) {
                bw.write(bus.toString());
                bw.newLine();
            }
            System.out.println("Bus details removed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void removeBus() {
        String busNumber = textFieldBusNumber.getText();
        removeBusFromFile(busNumber);
    }
    
    private void updateBus() {
        String busNumber = textFieldBusNumber.getText();
        String source = textFieldSource.getText();
        String destination = textFieldDestination.getText();
        String departure = textFieldDeparture.getText();
        String arrival = textFieldArrival.getText();
        int totalSeats = Integer.parseInt(textFieldTotalSeats.getText());
        int availableSeats = Integer.parseInt(textFieldAvailableSeats.getText());

        List<Bus> buses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("buses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Bus bus = Bus.fromString(line);
                if (bus.getBusNumber().equals(busNumber)) {
                    // Update bus details
                    bus.setSource(source);
                    bus.setDestination(destination);
                    bus.setDeparture(departure);
                    bus.setArrival(arrival);
                    bus.setTotalSeats(totalSeats);
                    bus.setAvailableSeats(availableSeats);
                }
                buses.add(bus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buses.txt"))) {
            for (Bus bus : buses) {
                bw.write(bus.toString());
                bw.newLine();
            }
            System.out.println("Bus details updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
