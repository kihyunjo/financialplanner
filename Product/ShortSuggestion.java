//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ShortSuggestion extends JFrame implements ActionListener
{

    //constants declaration
    private final int FRAME_X = 400;
    private final int FRAME_Y = 10;
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 500;
    private final java.net.URL LEFT_PATH = getClass().getResource("left.png");
    private final java.net.URL RIGHT_PATH = getClass().getResource("right.png");
    private final int FONT_T1 = 32;
    private final int FONT_S1 = 25;
    private final int COLOR_SR = 0;
    private final int COLOR_SG = 167;
    private final int COLOR_SB = 210;
    private final int COLOR_OR = 255;
    private final int COLOR_OG = 128;
    private final int COLOR_OB = 81;
    private final int COLOR_BR = 247;
    private final int COLOR_BG = 226;
    private final int COLOR_BB = 219;
    private final int COLOR_CR = 185;
    private final int COLOR_CG = 151;
    private final int COLOR_CB = 130;
    private final int COLOR_GR = 60;
    private final int COLOR_GG = 59;
    private final int COLOR_GB = 70;
    private final java.net.URL suggestPath = getClass().getResource("suggestion1.png");

    //String
    private String name;
    
    //JPanel
    private JPanel buttonPane;
    private JPanel topPane;
    private JPanel midPane;
    private JPanel underPane;
    private JPanel insPane1;
    private JPanel insPane2;

    //JLabel
    private JLabel goal;
    private JLabel goalValue;
    private JLabel instruction1;
    private JLabel instruction2;
    private JLabel or;
    private JLabel revenueValue;
    private JLabel costValue;
    private JLabel suggestPic;

    //Color
    private Color sky;
    private Color orange;
    private Color beige;
    private Color coffee;
    private Color grey;

    //JButton
    private JButton leftButton;
    private JButton rightButton;

    //Font
    private Font timesRoman1;
    private Font serif1;

    //Border
    private Border firstBorder1;
    private Border firstBorder2;
    private Border firstBorder;

    //Constructor
    public ShortSuggestion(double gpm, double x, double y, String pName)
    {
        super();
        
        name = pName;
        
        //JPanel
        buttonPane = new JPanel(new BorderLayout());
        topPane = new JPanel(new FlowLayout());
        midPane = new JPanel(new BorderLayout());
        underPane = new JPanel(new BorderLayout());
        insPane1 = new JPanel(new FlowLayout());
        insPane2 = new JPanel(new FlowLayout());

        //JLabel
        goal = new JLabel("Goal Gross Profit Margin : ");
        goalValue = new JLabel(Double.toString((Math.round(gpm*100.0)/100.0)));
        instruction1 = new JLabel("You should increase Sales Revenue by ");
        instruction2 = new JLabel("You should decrease Cost of Goods Sold by ");
        or = new JLabel("OR");
        suggestPic = new JLabel(new ImageIcon(suggestPath));

        //Color
        sky = new Color(COLOR_SR, COLOR_SG, COLOR_SB);
        orange = new Color(COLOR_OR, COLOR_OG, COLOR_OB);
        beige = new Color(COLOR_BR, COLOR_BG, COLOR_BB);
        coffee = new Color(COLOR_CR, COLOR_CG, COLOR_CB);
        grey = new Color(COLOR_GR, COLOR_GG, COLOR_GB);

        //JButton
        leftButton = new JButton(new ImageIcon(LEFT_PATH));
        rightButton = new JButton(new ImageIcon(RIGHT_PATH));

        //Font
        timesRoman1 = new Font("TimesRoman", Font.BOLD, FONT_T1);
        serif1 = new Font("Serif", Font.BOLD, FONT_S1);

        //Border
        firstBorder1 = new LineBorder(Color.BLACK, 3);
        firstBorder2 = new TitledBorder(firstBorder1);
        firstBorder = new TitledBorder(firstBorder2,
                "Methods", TitledBorder.LEFT, TitledBorder.TOP, serif1);

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(topPane, BorderLayout.NORTH);
        this.add(underPane, BorderLayout.CENTER);
        this.setVisible(true);

        //JLabel
        goal.setFont(timesRoman1);
        goal.setForeground(grey);
        goalValue.setFont(timesRoman1);
        goalValue.setForeground(grey);
        suggestPic.setBorder(firstBorder);
        instruction1.setHorizontalAlignment(JLabel.CENTER);
        instruction1.setFont(serif1);
        instruction2.setHorizontalAlignment(JLabel.CENTER);
        instruction2.setFont(serif1);

        revenueValue = new JLabel("$ " + Double.toString((Math.round(x*100.0)/100.0)));
        revenueValue.setFont(serif1);
        revenueValue.setForeground(Color.RED);
        costValue = new JLabel("$ " + Double.toString((Math.round(y*100.0)/100.0)));
        costValue.setFont(serif1);
        costValue.setForeground(Color.RED);
        or.setHorizontalAlignment(JLabel.CENTER);
        or.setFont(serif1);
        
        //JPanel
        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.add(rightButton, BorderLayout.EAST);
        buttonPane.setBackground(coffee);

        insPane1.add(instruction1);
        insPane1.add(revenueValue);

        insPane2.add(instruction2);
        insPane2.add(costValue);

        topPane.add(goal);
        topPane.add(goalValue);
        topPane.setBackground(orange);
        midPane.add(insPane1, BorderLayout.NORTH);
        midPane.add(or, BorderLayout.CENTER);
        midPane.add(insPane2, BorderLayout.SOUTH);
        midPane.setBackground(sky);
        underPane.add(midPane, BorderLayout.NORTH);
        underPane.add(suggestPic, BorderLayout.CENTER);
        underPane.add(buttonPane, BorderLayout.SOUTH);
        underPane.setBackground(beige);
       
        //JButton
        leftButton.addActionListener(this);
        leftButton.setActionCommand("left");
        rightButton.addActionListener(this);
        rightButton.setActionCommand("right");
    }

    //actionPerformed
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();
        if (buttonCommand.equals("left"))
        {
            this.dispose();
            try
            {
                Aim aimObj = new Aim(name);
            } catch (SQLException ex)
            {
                Logger.getLogger(ShortSuggestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (buttonCommand.equals("right"))
        {
            this.dispose();
            Home homeObj = new Home();
        }
    }
}