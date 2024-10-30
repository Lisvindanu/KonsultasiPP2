package Pertemuan6_Tugas.Service;

import Pertemuan6_Tugas.GUI.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // FlatArcDarkOrangeIJTheme.setup(); // Uncomment if using this theme
            new MainFrame();  // Directly instantiate MainFrame
            
            
        });
    }
}
