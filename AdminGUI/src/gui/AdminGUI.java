package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminGUI extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField staffIdField;
    private JPasswordField passwordField;
    private Connection connection;
    private JPanel dashboardPanel;

    public AdminGUI() {
        setTitle("Admin Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridLayout(4, 2));

        JLabel staffIdLabel = new JLabel("Staff ID:");
        staffIdField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        loginPanel.add(staffIdLabel);
        loginPanel.add(staffIdField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel);
        setVisible(true);

        // Connect to the database
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            String staffId = staffIdField.getText();
            char[] password = passwordField.getPassword();
            // Example: add login validation here
            if (isValidLogin(staffId, new String(password))) {
                showDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
            }
        }
    }

    private boolean isValidLogin(String staffId, String password) {
        // Example: perform login validation against the database
        // You need to implement your own logic here
        return true; // Dummy return value for demonstration
    }

    private void showDashboard() {
        getContentPane().removeAll(); // Clear the login panel
        setTitle("Dashboard");

        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new GridLayout(5, 1));

        JButton addHaulageButton = new JButton("Add Haulage/Delivery Request");
        addHaulageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHaulageRequest();
            }
        });
        dashboardPanel.add(addHaulageButton);

        JButton addStaffButton = new JButton("Add Staff Record");
        addStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStaffRecord();
            }
        });
        dashboardPanel.add(addStaffButton);

        JButton addCustomerButton = new JButton("Add Customer Record");
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomerRecord();
            }
        });
        dashboardPanel.add(addCustomerButton);

        JButton generateReportsButton = new JButton("Generate Reports");
        generateReportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReports();
            }
        });
        dashboardPanel.add(generateReportsButton);

        JButton realTimeChatButton = new JButton("Real-Time/Live Chat");
        realTimeChatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRealTimeChat();
            }
        });
        dashboardPanel.add(realTimeChatButton);

        add(dashboardPanel);
        revalidate(); // Refresh the frame
    }

    private void addHaulageRequest() {
        // Implement functionality to add haulage/delivery request
        JOptionPane.showMessageDialog(this, "Functionality to add haulage/delivery request");
    }

    private void addStaffRecord() {
        // Implement functionality to add staff record
        JOptionPane.showMessageDialog(this, "Functionality to add staff record");
    }

    private void addCustomerRecord() {
        // Implement functionality to add customer record
        JOptionPane.showMessageDialog(this, "Functionality to add customer record");
    }

    private void generateReports() {
        // Implement functionality to generate reports based on specific requirements
        JOptionPane.showMessageDialog(this, "Functionality to generate reports");
    }

    private void openRealTimeChat() {
        // Implement functionality to open real-time/live chat
        JOptionPane.showMessageDialog(this, "Functionality to open real-time/live chat");
    }

    
}