package id.ac.its.BayuBennettIvan;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String Schoice = JOptionPane.showInputDialog("Input your choice\n1. Square\n2. Rectangle\n");
        int choice = Integer.parseInt(Schoice);
        switch (choice) {
            case 1:
                Square square = new Square();
                square.Calculate();
                break;
            case 2:
                Rectangle rectangle = new Rectangle();
                rectangle.Calculate();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Choice", "Please input a valid choice",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
