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

public class MidSuggestion extends JFrame implements ActionListener
{

    //constants declaration
    private final int FRAME_X = 400;
    private final int FRAME_Y = 10;
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 400;
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
    private final java.net.URL suggestPath = getClass().getResource("suggestion2.png");

    //String
    private String name;

    //JPanel
    private JPanel buttonPane;
    private JPanel topPane;
    private JPanel underPane;
    private JPanel insPane;

    //JLabel
    private JLabel goal;
    private JLabel goalValue;
    private JLabel expenseValue;
    private JLabel instruction;
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
    public MidSuggestion(double npm, double x, String pName)
    {
        super();
        
        //String
        name = pName;

        //JPanel
        buttonPane = new JPanel(new BorderLayout());
        topPane = new JPanel(new FlowLayout());
        underPane = new JPanel(new BorderLayout());
        insPane = new JPanel(new FlowLayout());

        //Font
        timesRoman1 = new Font("TimesRoman", Font.BOLD, FONT_T1);
        serif1 = new Font("Serif", Font.BOLD, FONT_S1);
        
        //JLabel
        goal = new JLabel("Goal Net Profit Margin : ");
        goalValue = new JLabel(Double.toString((Math.round(npm*100.0)/100.0)));
        instruction = new JLabel("You should decrease expense by ");
        suggestPic = new JLabel(new ImageIcon(suggestPath));
        goal.setFont(timesRoman1);
        goal.setForeground(grey);
        goalValue.setFont(timesRoman1);
        goalValue.setForeground(grey);
        suggestPic.setBorder(firstBorder);
        instruction.setHorizontalAlignment(JLabel.CENTER);
        instruction.setFont(serif1);
        expenseValue = new JLabel("$ " + Double.toString((Math.round(x*100.0)/100.0)));
        expenseValue.setFont(serif1);
        expenseValue.setForeground(Color.RED);

        //Color
        sky = new Color(COLOR_SR, COLOR_SG, COLOR_SB);
        orange = new Color(COLOR_OR, COLOR_OG, COLOR_OB);
        beige = new Color(COLOR_BR, COLOR_BG, COLOR_BB);
        coffee = new Color(COLOR_CR, COLOR_CG, COLOR_CB);
        grey = new Color(COLOR_GR, COLOR_GG, COLOR_GB);

        //JButton
        leftButton = new JButton(new ImageIcon(LEFT_PATH));
        rightButton = new JButton(new ImageIcon(RIGHT_PATH));

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

        //JPanel
        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.add(rightButton, BorderLayout.EAST);
        buttonPane.setBackground(coffee);

        insPane.add(instruction);
        insPane.add(expenseValue);

        topPane.add(goal);
        topPane.add(goalValue);
        topPane.setBackground(orange);

        underPane.add(insPane, BorderLayout.NORTH);
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
                Logger.getLogger(MidSuggestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (buttonCommand.equals("right"))
        {
            this.dispose();
            Home homeObj = new Home();
        }
    }
}