package id.ac.its.BayuBennettIvan;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
    private final JLabel label;
    private final JLabel nrp;

    public LabelFrame() {
        nrp = new JLabel();
        nrp.setText("05111940000187");
        add(nrp);
        Icon foto = new ImageIcon(getClass().getResource("536558.jpg"));
        setLayout(new FlowLayout());
        label = new JLabel();
        label.setText("Gerald Elroy Van Ryan");
        label.setIcon(foto); // add icon to JLabel
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setToolTipText("This is label3");
        add(label);
    }

}