package id.ac.its.BayuBennettIvan;

import javax.swing.JOptionPane;

public class Square extends Shapes {

    public void Calculate() {
        String side = JOptionPane.showInputDialog("Enter sides of the square");
        int numside = Integer.parseInt(side);
        int area = numside * numside;
        int perimeter = 4 * numside;
        JOptionPane.showMessageDialog(null, "The area is " + area + "\nThe perimeter is " + perimeter,
                "Area and perimeter of a square", JOptionPane.PLAIN_MESSAGE);
    }
}
