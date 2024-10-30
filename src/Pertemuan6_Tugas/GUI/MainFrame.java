package Pertemuan6_Tugas.GUI;

import Pertemuan6_Tugas.Listener.Handler;
import Pertemuan6_Tugas.Service.TableServices;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("MainFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Nama", "No HP", "Jenis Kelamin", "WNA", 
                        "Jenis Tabungan", "Frekuensi Transaksi", 
                        "Tanggal Lahir", "Pekerjaan", "Deskripsi"};

        // Create a single instance of DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        System.out.println("Model identity in MainFrame: " + System.identityHashCode(tableModel)); // Debug

        // Pass the same instance to FormPanel and TableServices
        FormPanel formPanel = new FormPanel(tableModel);
        // TableServices tableServices = new TableServices(tableModel, formPanel);

        // Set up CardLayout for the main panel
        JPanel mainPanel = new JPanel(new CardLayout());

        // Create and add panels
        JPanel loadPanel = createLoadPanel(); 
        mainPanel.add(loadPanel, "LoadPanel");
        mainPanel.add(formPanel, "FormPanel");

        // Set up the menu bar
        MenuBars menuBars = new MenuBars(mainPanel, formPanel, tableModel);
        setJMenuBar(menuBars.dapetinMenuBar());

        // Create the handler and pass required components
        Handler handler = new Handler(mainPanel, menuBars.getLoadItem(), menuBars.getSaveItem(),
                                      menuBars.getExitItem(), menuBars.getFormItem(), tableModel, formPanel);

        // Add action listeners
        addMenuListeners(menuBars, handler);

        // Add main panel to the frame
        add(mainPanel);

        // Set frame size and visibility
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createLoadPanel() {
        JPanel loadPanel = new JPanel();
        loadPanel.add(new JLabel("Load Page"));
        return loadPanel;
    }

    private void addMenuListeners(MenuBars menuBars, Handler handler) {
        menuBars.getLoadItem().addActionListener(handler::handleAction);
        menuBars.getSaveItem().addActionListener(handler::handleAction);
        menuBars.getExitItem().addActionListener(handler::handleAction);
        menuBars.getFormItem().addActionListener(handler::handleAction);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
