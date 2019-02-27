package application;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class BoxLayoutPanel extends JPanel {

    private List panelComponents;
    private int axis;

    public void setAxis(int axis){
        this.axis = axis;
    }

    public void setPanelComponents(List panelComponents){
        this.panelComponents = panelComponents;
    }

    public void init(){
        setLayout(new BoxLayout(this, axis));

        for(Iterator iter = panelComponents.iterator(); iter.hasNext();){
            Component comp = (Component) iter.next();
            add(comp);
        }
    }
}
