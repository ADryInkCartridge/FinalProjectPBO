package id.ac.its.BayuBennettIvan;

import javax.swing.JOptionPane;

public class Rectangle extends Shapes {

    public void Calculate() {
        String length = JOptionPane.showInputDialog("Enter sides of the Length");
        String width = JOptionPane.showInputDialog("Enter sides of the width");
        int numlength = Integer.parseInt(length);
        int numwidth = Integer.parseInt(width);
        int area = numwidth * numlength;
        int perimeter = 2 * (numlength + numwidth);
        JOptionPane.showMessageDialog(null, "The area is " + area + "\nThe perimeter is " + perimeter,
                "Area and perimeter of a square", JOptionPane.PLAIN_MESSAGE);
    }
}
