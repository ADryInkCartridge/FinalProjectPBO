package id.ac.its.christianbennett078;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String Schoice = JOptionPane.showInputDialog("Input your choice\n(1) Triangle\n(2) Circle\n");
        int choice = Integer.parseInt(Schoice);
        switch (choice) {
            case 1:
            	Triangle triangle = new Triangle();
            	triangle.Calculate();
            	break;
            case 2:
                Circle circle = new Circle();
            	circle.Calculate();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Choice", "Please input a valid choice",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
