package application;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddNewButtonActionListener extends ListTableActionListener {

    public void actionPerformed(ActionEvent e) {
        JOptionPane optn = new JOptionPane();
        String name = JOptionPane.showInputDialog(optn, "Buddy Name");
        String address = JOptionPane.showInputDialog(optn, "Address");
        String phoneNum = JOptionPane.showInputDialog(optn, "PhoneNumber");
        BuddyInfo b = new BuddyInfo(name, address, phoneNum);
        list.add(b);
        table.revalidate();
    }
}
