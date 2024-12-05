package BusService;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusSearch extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldSource;
    private JTextField textFieldDestination;
    private JTextArea textAreaResults;
    private JTextArea textAreaSeats;
    private List<Bus> availableBuses;
    private JComboBox<String> comboBoxBuses;
    private JTextField textFieldSeats;
    private static final String PLACEHOLDER_TEXT = "Search results will appear here...";
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BusSearch frame = new BusSearch();
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
    public BusSearch() {
        setForeground(new Color(255, 0, 0));
        setFont(new Font("Dialog", Font.BOLD, 17));
        setTitle("Bus Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 0, 0));
        contentPane.setBackground(new Color(255, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Search for Buses");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(42, 21, 595, 87);
        contentPane.add(lblNewLabel);

        JLabel lblSource = new JLabel("Source");
        lblSource.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSource.setBounds(0, 118, 90, 39);
        contentPane.add(lblSource);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblDestination.setBounds(0, 167, 136, 39);
        contentPane.add(lblDestination);

        textFieldSource = new JTextField();
        textFieldSource.setBounds(147, 118, 166, 28);
        contentPane.add(textFieldSource);
        textFieldSource.setColumns(10);

        textFieldDestination = new JTextField();
        textFieldDestination.setBounds(146, 178, 172, 28);
        contentPane.add(textFieldDestination);
        textFieldDestination.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String source = textFieldSource.getText();
                String destination = textFieldDestination.getText();

                if (!source.isEmpty() && !destination.isEmpty()) {
                    availableBuses = searchBuses(source, destination);
                    displayBuses(availableBuses);
                    populateBusComboBox(availableBuses);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both source and destination", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSearch.setBounds(353, 179, 85, 21);
        contentPane.add(btnSearch);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldSource.setText("");
                textFieldDestination.setText("");
                textAreaResults.setText(PLACEHOLDER_TEXT);
                textAreaResults.setForeground(Color.GRAY);
                textAreaSeats.setText("");
                comboBoxBuses.removeAllItems();
                textFieldSeats.setText("");
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnReset.setBounds(453, 179, 85, 21);
        contentPane.add(btnReset);

        textAreaResults = new JTextArea();
        textAreaResults.setBounds(35, 265, 700, 100);
        textAreaResults.setText(PLACEHOLDER_TEXT);
        textAreaResults.setForeground(Color.GRAY);
        textAreaResults.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textAreaResults.getText().equals(PLACEHOLDER_TEXT)) {
                    textAreaResults.setText("");
                    textAreaResults.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textAreaResults.getText().isEmpty()) {
                    textAreaResults.setForeground(Color.GRAY);
                    textAreaResults.setText(PLACEHOLDER_TEXT);
                }
            }
        });
        contentPane.add(textAreaResults);

        textAreaSeats = new JTextArea();
        textAreaSeats.setBounds(35, 375, 700, 87);
        contentPane.add(textAreaSeats);

        comboBoxBuses = new JComboBox<>();
        comboBoxBuses.setBounds(35, 472, 200, 30);
        contentPane.add(comboBoxBuses);

        JLabel lblSeats = new JLabel("Seats");
        lblSeats.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSeats.setBounds(336, 470, 50, 30);
        contentPane.add(lblSeats);

        textFieldSeats = new JTextField();
        textFieldSeats.setBounds(415, 473, 50, 30);
        contentPane.add(textFieldSeats);
        textFieldSeats.setColumns(10);

        JButton btnBook = new JButton("Book Seat");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedBus = (String) comboBoxBuses.getSelectedItem();
                String seatsStr = textFieldSeats.getText();
                if (selectedBus != null && !seatsStr.isEmpty()) {
                    try {
                        int seats = Integer.parseInt(seatsStr);
                        bookSeats(selectedBus, seats);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid number of seats", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a bus and enter the number of seats", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBook.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnBook.setBounds(615, 470, 120, 30);
        contentPane.add(btnBook);
        
        lblNewLabel_1 = new JLabel(" busNumber,  source, destination, departure, arrival, totalSeats, availableSeats");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1.setBounds(42, 227, 693, 28);
        contentPane.add(lblNewLabel_1);
    }

    private List<Bus> searchBuses(String source, String destination) {
        List<Bus> buses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("buses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Bus bus = Bus.fromString(line);
                if (bus.getSource().equalsIgnoreCase(source) && bus.getDestination().equalsIgnoreCase(destination)) {
                    buses.add(bus);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading buses data", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return buses;
    }

    private void displayBuses(List<Bus> buses) {
        textAreaResults.setText("");
        for (Bus bus : buses) {
            textAreaResults.append(formatBusWithSeats(bus) + "\n");
        }
    }

    private String formatBusWithSeats(Bus bus) {
        StringBuilder sb = new StringBuilder();
        sb.append(bus.toString()).append(" [Seats: ");
        int totalSeats = bus.getTotalSeats();
        int availableSeats = bus.getAvailableSeats();
        for (int i = 1; i <= totalSeats; i++) {
            if (i <= availableSeats) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void populateBusComboBox(List<Bus> buses) {
        comboBoxBuses.removeAllItems();
        for (Bus bus : buses) {
            comboBoxBuses.addItem(bus.toString());
        }
    }

    private void bookSeats(String busDetails, int seats) {
        for (Bus bus : availableBuses) {
            if (bus.toString().equals(busDetails)) {
                if (bus.getAvailableSeats() >= seats) {
                    bus.setAvailableSeats(bus.getAvailableSeats() - seats);
                    updateBusInFile(bus);
                    updateSeatArrangement(bus);
                    JOptionPane.showMessageDialog(null, seats + " seat(s) booked successfully. Remaining seats: " + bus.getAvailableSeats(), "Booking Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough available seats.", "Booking Failed", JOptionPane.WARNING_MESSAGE);
                }
                break;
            }
        }
    }

    private void updateBusInFile(Bus updatedBus) {
        List<Bus> buses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("buses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Bus bus = Bus.fromString(line);
                if (bus.getBusNumber().equals(updatedBus.getBusNumber())) {
                    buses.add(updatedBus);
                } else {
                    buses.add(bus);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading buses data", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buses.txt"))) {
            for (Bus bus : buses) {
                bw.write(bus.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing buses data", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void updateSeatArrangement(Bus updatedBus) {
        textAreaSeats.setText("");
        textAreaSeats.append("Updated Seat Arrangement for " + updatedBus.toString() + ":\n");
        int totalSeats = updatedBus.getTotalSeats();
        int availableSeats = updatedBus.getAvailableSeats();
        for (int i = 1; i <= totalSeats; i++) {
            if (i <= availableSeats) {
                textAreaSeats.append("O ");
            } else {
                textAreaSeats.append("X ");
            }
            if (i % 25 == 0) {
                textAreaSeats.append("\n");
            }
        }
    }
}
