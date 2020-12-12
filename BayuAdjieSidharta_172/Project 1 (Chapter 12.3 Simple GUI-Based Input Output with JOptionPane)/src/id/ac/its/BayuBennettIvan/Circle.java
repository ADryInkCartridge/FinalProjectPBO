package id.ac.its.BayuBennettIvan;

import javax.swing.JOptionPane;
import java.lang.Math;

public class Circle extends Shapes {

    public void Calculate() {
        String radius = JOptionPane.showInputDialog("Enter circle radius");
        int numradius = Integer.parseInt(radius);
        double area = Math.PI * Math.pow(numradius, 2);
        double perimeter = Math.PI * 2 * numradius;
        JOptionPane.showMessageDialog(null, "The area is " + area + "\nThe perimeter is " + perimeter,
                "Area and perimeter of a circle", JOptionPane.PLAIN_MESSAGE);
    }
}