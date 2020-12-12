package id.ac.its.christofferivano091;

import javax.swing.JOptionPane;

public class MainApp {
    public static void main(String[] args) throws Exception {
        String Schoice = JOptionPane.showInputDialog("Input your choice\n(1) Trapezoid\n(2) Kite\n");
        int choice = Integer.parseInt(Schoice);
        switch (choice) {
            case 1:
                Trapezoid trapezoid = new Trapezoid();
                trapezoid.Calculate();
                break;
            case 2:
                Kite kite = new Kite();
                kite.Calculate();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Choice", "Please input a valid choice",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
