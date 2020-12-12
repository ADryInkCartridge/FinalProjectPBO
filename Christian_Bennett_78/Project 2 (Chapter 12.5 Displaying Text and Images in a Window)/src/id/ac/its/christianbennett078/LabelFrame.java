package id.ac.its.christianbennett078;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
    private final JLabel label;

    public LabelFrame() {
        Icon foto = new ImageIcon(getClass().getResource("rsz_cbr.png"));
        setLayout(new FlowLayout());
        label = new JLabel();
        label.setText("05111940000078 / Christian Bennett Robin");
        label.setIcon(foto);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(label);
    }

}