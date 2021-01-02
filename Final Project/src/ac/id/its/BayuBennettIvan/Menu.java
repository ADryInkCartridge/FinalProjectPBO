package ac.id.its.BayuBennettIvan;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel implements ActionListener {

    int width, height;

    JButton play = new JButton("play");
    JButton settings = new JButton("settings");
    JButton exit = new JButton("exit");
    JButton mainMenu = new JButton("main menu");

    CardLayout layout = new CardLayout();

    JPanel panel = new JPanel();
    JPanel game = new JPanel();
    JPanel menu = new JPanel();
}