package Pertemuan6_Tugas.Listener;

import Pertemuan6_Tugas.GUI.FormPanel;
import Pertemuan6_Tugas.Interface.MChangeListener;

import javax.swing.event.ChangeEvent;

public class ChangeHandler implements MChangeListener {
    private FormPanel formPanel;

    public ChangeHandler(FormPanel formPanel) {
        this.formPanel = formPanel;
    }

    @Override
    public void handleChange(ChangeEvent e) {
        int sliderValue = formPanel.slider.getValue();
        System.out.println("Nilai Dipilih : " + sliderValue + " Juta");
    }
}
