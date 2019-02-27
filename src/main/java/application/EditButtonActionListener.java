package application;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditButtonActionListener extends ListTableActionListener {

    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            // if there is no selected row, don't do anything
            return;
        }

        if (table.isEditing()) {
            // if we are editing the table, don't do anything
            return;
        }

        JOptionPane optn = new JOptionPane();
        String name = JOptionPane.showInputDialog(optn, "New Buddy Name");
        String address = JOptionPane.showInputDialog(optn, "New Address");
        String phoneNum = JOptionPane.showInputDialog(optn, "New PhoneNumber");
        BuddyInfo b = new BuddyInfo(name, address, phoneNum);
        list.remove(selectedRow);
        list.add(selectedRow, b);
        table.revalidate();
    }
}
