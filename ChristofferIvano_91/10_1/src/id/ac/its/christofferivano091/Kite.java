package id.ac.its.christofferivano091;

import javax.swing.JOptionPane;

public class Kite extends Shape{
    public void Calculate()
    {
        String side1 = JOptionPane.showInputDialog("Enter Side 1");
        String side2 = JOptionPane.showInputDialog("Enter Side 2");
        String side3 = JOptionPane.showInputDialog("Enter Side 3");
        String side4 = JOptionPane.showInputDialog("Enter Side 4");
        String d1 = JOptionPane.showInputDialog("Enter Diagonal 1");
        String d2 = JOptionPane.showInputDialog("Enter Diagonal 2");

        int numSide1 = Integer.parseInt(side1);
        int numSide2 = Integer.parseInt(side2);
        int numSide3 = Integer.parseInt(side3);
        int numSide4 = Integer.parseInt(side4);
        int numD1 = Integer.parseInt(d1);
        int numD2 = Integer.parseInt(d2);

        double area = 0.5 * numD1 * numD2;
        double perimeter = numSide1 + numSide2 + numSide3 + numSide4;

        JOptionPane.showMessageDialog(null, "The Area is " + area +
            "\nThe Perimeter is " + perimeter, "Area and Perimeter of a Kite",
            JOptionPane.PLAIN_MESSAGE);
    }
}
