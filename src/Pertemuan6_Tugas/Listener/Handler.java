package Pertemuan6_Tugas.Listener;

import Pertemuan6_Tugas.GUI.FormPanel;
import Pertemuan6_Tugas.Interface.MActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Handler implements MActionListener {
    private JPanel mainPanel;
    private JMenuItem loadItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;
    private JMenuItem formItem;
    private FormPanel formPanel;
    private DefaultTableModel tableModel;

    // Constructor with the required parameters
    public Handler(JPanel mainPanel, JMenuItem loadItem, JMenuItem saveItem, JMenuItem exitItem,
                   JMenuItem formItem, DefaultTableModel tableModel, FormPanel formPanel) {
        this.mainPanel = mainPanel;
        this.loadItem = loadItem;
        this.saveItem = saveItem;
        this.exitItem = exitItem;
        this.formItem = formItem;
        this.tableModel = tableModel;
        this.formPanel = formPanel;
    }

    @Override
    public void handleAction(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();

        if (e.getSource() == loadItem) {
            // Switch to Load Panel
            cardLayout.show(mainPanel, "LoadPanel");
        } else if (e.getSource() == saveItem) {
            // Handle saving logic
            SwingUtilities.invokeLater(() -> {
                System.out.println("Attempting to save data. Current row count: " + tableModel.getRowCount());
                System.out.println("Model identity during save: " + System.identityHashCode(tableModel)); // Debug

                if (tableModel.getRowCount() > 0) {
                    saveDataToFile();  // Call the save function
                    JOptionPane.showMessageDialog(mainPanel, "Data saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter data first.");
                }
                cardLayout.show(mainPanel, "FormPanel");
            });
        } else if (e.getSource() == exitItem) {
            System.exit(0); // Exit the application
        } else if (e.getSource() == formItem) {
            // Switch to Form Panel
            cardLayout.show(mainPanel, "FormPanel");
        }
    }
    private void saveDataToFile() {
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Tidak ada data untuk disimpan.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    row.append(tableModel.getValueAt(i, j)).append(", ");
                }
                writer.write(row.toString().replaceAll(", $", ""));
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e.getMessage());
        }
    }
}
