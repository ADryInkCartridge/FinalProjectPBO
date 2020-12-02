package id.ac.its.BayuBennettIvan;

import javax.swing.JOptionPane;

public class Trapezoid extends Shapes{
    public void Calculate()
    {
        String base1 = JOptionPane.showInputDialog("Enter Base 1");
        String base2 = JOptionPane.showInputDialog("Enter Base 2");
        String base3 = JOptionPane.showInputDialog("Enter Base 3");
        String base4 = JOptionPane.showInputDialog("Enter Base 4");
        String height = JOptionPane.showInputDialog("Enter Height");
        
        int numBase1 = Integer.parseInt(base1);
        int numBase2 = Integer.parseInt(base2);
        int numBase3 = Integer.parseInt(base3);
        int numBase4 = Integer.parseInt(base4);
        int numHeight = Integer.parseInt(height);

        double area = 0.5 * numHeight * (numBase1 + numBase2);
        double perimeter = numBase1 + numBase2 + numBase3 + numBase4;

        JOptionPane.showMessageDialog(null, "The Area is " + area +
            "\nThe Perimeter is " + perimeter, "Area and Perimeter of a Trapezoid",
            JOptionPane.PLAIN_MESSAGE);
    }
}
