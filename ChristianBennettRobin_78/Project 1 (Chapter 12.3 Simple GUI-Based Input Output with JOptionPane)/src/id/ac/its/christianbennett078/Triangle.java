package id.ac.its.christianbennett078;

import javax.swing.JOptionPane;
import java.lang.Math;

public class Triangle extends Shapes {

    public void Calculate() {
        String base = JOptionPane.showInputDialog("Enter triangle base");
        String height = JOptionPane.showInputDialog("Enter triangle height");
        int numlength = Integer.parseInt(base);
        int numheight = Integer.parseInt(height);
        int area = numlength * numheight / 2;
        double c = Math.sqrt((Math.pow(numlength, 2))+(Math.pow(numheight, 2)));
        double perimeter = numlength+ numheight + c;
        JOptionPane.showMessageDialog(null, "The area is " + area + "\nThe perimeter is " + perimeter,
                "Area and perimeter of a triangle", JOptionPane.PLAIN_MESSAGE);
    }
}