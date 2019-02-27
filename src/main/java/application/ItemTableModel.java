package application;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class ItemTableModel extends AbstractTableModel {
    List itemList;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public int getColumnCount(){
        return 1;
    }

    public String getColumnName(int column){
        return "Item";
    }

    public void setItemList(List itemList){
        this.itemList = itemList;
    }

    public int getRowCount(){
        return itemList.size();
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex){
        itemList.set(rowIndex, value);
    }

    public Object getValueAt(int rowIndex, int colIndex){
        return itemList.get(rowIndex);
    }
}

