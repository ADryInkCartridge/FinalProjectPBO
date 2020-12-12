package id.ac.its.BayuBennettIvan;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
    private final JLabel label;

    public LabelFrame() {
        Icon foto = new ImageIcon(getClass().getResource("Capture.png"));
        setLayout(new FlowLayout());
        label = new JLabel();
        label.setText("05111940000172 / Bayu Adjie Sidharta");
        label.setIcon(foto); // add icon to JLabel
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setToolTipText("This is label3");
        add(label);
    }

}