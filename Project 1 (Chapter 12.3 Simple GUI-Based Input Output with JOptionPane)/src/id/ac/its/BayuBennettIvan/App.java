package id.ac.its.BayuBennettIvan;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String Schoice = JOptionPane.showInputDialog("Input your choice\n(1) Square\n(2) Rectangle\n(3) Triangle\n(4) Circle");
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
            case 3:
            	Triangle triangle = new Triangle();
            	triangle.Calculate();
            	break;
            case 4:
            	Circle circle = new Circle();
            	circle.Calculate();
            	break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Choice", "Please input a valid choice",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
