package Pertemuan6_Tugas.GUI;

import Pertemuan6_Tugas.Listener.Handler;
import Pertemuan6_Tugas.Service.TableServices;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuBars {

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    private JMenuItem loadItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;
    private JMenuItem formItem;

    public MenuBars(JPanel mainPanel, FormPanel formPanel, DefaultTableModel tableModel) {
        menuBar = new JMenuBar();

        // Initialize menus
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        // Initialize menu items
        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        formItem = new JMenuItem("Open Form");

        // Set mnemonics for accessibility
        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_H);
        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_X); // Changed for better clarity
        formItem.setMnemonic(KeyEvent.VK_O); // "O" for Open Form

         // Print model identity
         System.out.println("Model identity in MenuBar: " + System.identityHashCode(tableModel));

        // Create an instance of the handler and pass the necessary parameters
        Handler handler = new Handler(mainPanel, loadItem, saveItem, exitItem, formItem, tableModel, formPanel);

        // Add action listeners for each menu item
        loadItem.addActionListener(handler::handleAction);
        saveItem.addActionListener(handler::handleAction);
        exitItem.addActionListener(handler::handleAction);
        formItem.addActionListener(handler::handleAction);

        // Add menu items to the File menu
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        fileMenu.addSeparator();
        fileMenu.add(formItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
    }

    public JMenuBar dapetinMenuBar() {
        return menuBar;
    }
    public JMenuItem getLoadItem() {
        return loadItem;
    }

    public JMenuItem getSaveItem() {
        return saveItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public JMenuItem getFormItem() {
        return formItem;
    }
}
