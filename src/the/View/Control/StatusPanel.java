package the.View.Control;

import javax.swing.*;
import java.awt.*;


public class StatusPanel extends JPanel {
    public static  StatusPanel S ;
    public StatusPanel(){
        S=this;
        setPreferredSize(new Dimension(-1,20));
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.RIGHT);
        setLayout(fl);
    }
}
