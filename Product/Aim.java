//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Aim extends JFrame implements ActionListener
{
    //constants declaration
    private final int FRAME_X = 400;
    private final int FRAME_Y = 10;
    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 620;
    private final int TEXT_SIZE = 10;
    private final java.net.URL LEFT_PATH = getClass().getResource("left.png");
    private final java.net.URL RIGHT_PATH = getClass().getResource("right.png");
    private final int GRID_ROW = 2;
    private final int GRID_COL = 2;
    private final int GRID_HGAP = 1;
    private final int GRID_VGAP = 1;
    private final String[] shortArray =
    {
        "1%", "2%", "3%", "4%", "5%"
    };
    private final String[] midArray =
    {
        "6%", "7%", "8%", "9%", "10%"
    };
    private final int FONT_T = 25;
    private final int FONT_S1 = 25;
    private final int FONT_S2 = 20;
    private final int COLOR_NR = 0;
    private final int COLOR_NG = 72;
    private final int COLOR_NB = 142;
    private final int COLOR_AR = 69;
    private final int COLOR_AG = 136;
    private final int COLOR_AB = 165;
    private final int COLOR_YR = 251;
    private final int COLOR_YG = 213;
    private final int COLOR_YB = 62;
    private final int COLOR_BR = 215;
    private final int COLOR_BG = 174;
    private final int COLOR_BB = 144;
    private final int COLOR_SR = 132;
    private final int COLOR_SG = 216;
    private final int COLOR_SB = 226;
    private final int COLOR_PR = 255;
    private final int COLOR_PG = 104;
    private final int COLOR_PB = 98;
    private final java.net.URL INCREASE_PATH = getClass().getResource("increase.png");

    //JLabel
    private JLabel currentNpm;
    private JLabel currentGpm;
    private JLabel curNpmVal;
    private JLabel curGpmVal;
    private JLabel shortQuestion;
    private JLabel midQuestion;
    private JLabel shortAnswer;
    private JLabel midAnswer;

    private JLabel increase;

    //JPanel
    private JPanel buttonPane;
    private JPanel radioPane;
    private JPanel currentPane;
    private JPanel inputPane;
    private JPanel answerPane;
    private JPanel centerPane;

    //JButton
    private JButton leftButton;
    private JButton rightButton;

    //JRadioButton
    private JRadioButton shortTerm;
    private JRadioButton midTerm;

    //ButtonGroup
    private ButtonGroup radioGroup;

    //JComboBox
    private JComboBox<String> shortBox;
    private JComboBox<String> midBox;

    //Font
    private Font timesRoman;
    private Font serif1;
    private Font serif2;

    //Color
    private Color navy;
    private Color aqua;
    private Color yellow;
    private Color beige;
    private Color sky;
    private Color pink;

    //Border
    private Border firstBorder1;
    private Border firstBorder2;
    private Border firstBorder;

    //String & double
    private String name;
    private double revenueValue;
    private double costValue;
    private double expenseValue;
    private double idealGpm;
    private double idealNpm;

    private SQLStatement sqlObj;

    //Constructor
    public Aim(String pName) throws SQLException
    {
        super();
        
        sqlObj = new SQLStatement();

        //String
        name = pName;

        //JLabel
        currentNpm = new JLabel("Current Net Profit Margin : ");
        curNpmVal = new JLabel(Double.toString((Math.round(sqlObj.getNpm(name) * 100.0)) / 100.0) + "%");
        currentGpm = new JLabel("Current Gross Profit Margin : ");
        curGpmVal = new JLabel(Double.toString((Math.round(sqlObj.getGpm(name) * 100.0)) / 100.0) + "%");
        shortQuestion = new JLabel("What is your ideal gross profit margin?");
        midQuestion = new JLabel("What is your ideal net profit margin?");
        shortAnswer = new JLabel("Increase it by ");
        midAnswer = new JLabel("Increase it by ");
        increase = new JLabel(new ImageIcon(INCREASE_PATH));

        //JPanel
        buttonPane = new JPanel(new BorderLayout());
        radioPane = new JPanel(new FlowLayout());
        currentPane = new JPanel(new GridLayout(GRID_ROW, GRID_COL, GRID_HGAP, GRID_VGAP));
        inputPane = new JPanel(new BorderLayout());
        answerPane = new JPanel(new FlowLayout());
        centerPane = new JPanel(new BorderLayout());

        //JButton
        leftButton = new JButton(new ImageIcon(LEFT_PATH));
        rightButton = new JButton(new ImageIcon(RIGHT_PATH));

        //JRadioButton
        shortTerm = new JRadioButton("Short Term", true);
        midTerm = new JRadioButton("Mid Term");

        //ButtonGroup
        radioGroup = new ButtonGroup();

        //JComboBox
        shortBox = new JComboBox<>(shortArray);
        midBox = new JComboBox<>(midArray);

        //Font
        timesRoman = new Font("TimesRoman", Font.BOLD, FONT_T);
        serif1 = new Font("Serif", Font.BOLD, FONT_S1);
        serif2 = new Font("Serif", Font.PLAIN, FONT_S2);

        //Color
        navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);
        aqua = new Color(COLOR_AR, COLOR_AG, COLOR_AB);
        yellow = new Color(COLOR_YR, COLOR_YG, COLOR_YB);
        beige = new Color(COLOR_BR, COLOR_BG, COLOR_BB);
        sky = new Color(COLOR_SR, COLOR_SG, COLOR_SB);
        pink = new Color(COLOR_PR, COLOR_PG, COLOR_PB);

        //Border
        firstBorder1 = new LineBorder(aqua, 3);
        firstBorder2 = new TitledBorder(firstBorder1);
        firstBorder = new TitledBorder(firstBorder2,
                "Current Ratio", TitledBorder.CENTER, TitledBorder.TOP, serif1);

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(radioPane, BorderLayout.NORTH);
        this.add(centerPane, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
        this.setVisible(true);

        //JPanel
        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.add(rightButton, BorderLayout.EAST);
        buttonPane.setBackground(sky);
        radioPane.add(shortTerm);
        radioPane.add(midTerm);
        radioPane.setBackground(navy);
        currentPane.add(currentGpm);
        currentPane.add(curGpmVal);
        currentPane.add(currentNpm);
        currentPane.add(curNpmVal);
        currentPane.setBorder(firstBorder);
        currentPane.setBackground(yellow);
        answerPane.add(shortAnswer);
        answerPane.add(shortBox);
        answerPane.setBackground(beige);
        inputPane.add(shortQuestion, BorderLayout.NORTH);
        inputPane.add(answerPane, BorderLayout.SOUTH);
        inputPane.setBackground(pink);

        centerPane.add(currentPane, BorderLayout.NORTH);
        centerPane.add(increase, BorderLayout.CENTER);
        centerPane.add(inputPane, BorderLayout.SOUTH);
        centerPane.setBackground(yellow);

        //ButtonGroup
        radioGroup.add(shortTerm);
        radioGroup.add(midTerm);

        //JButton
        leftButton.addActionListener(this);
        leftButton.setActionCommand("left");
        rightButton.addActionListener(this);
        rightButton.setActionCommand("right");

        //JRadioButton
        shortTerm.addActionListener(this);
        shortTerm.setFont(timesRoman);
        midTerm.addActionListener(this);
        midTerm.setFont(timesRoman);

        //JLabel
        currentNpm.setHorizontalAlignment(JLabel.CENTER);
        currentNpm.setFont(serif1);
        currentGpm.setHorizontalAlignment(JLabel.CENTER);
        currentGpm.setFont(serif1);
        curNpmVal.setHorizontalAlignment(JLabel.CENTER);
        curNpmVal.setFont(serif1);
        curGpmVal.setHorizontalAlignment(JLabel.CENTER);
        curGpmVal.setFont(serif1);
        shortQuestion.setHorizontalAlignment(JLabel.CENTER);
        shortQuestion.setFont(timesRoman);
        midQuestion.setHorizontalAlignment(JLabel.CENTER);
        midQuestion.setFont(timesRoman);
        shortAnswer.setHorizontalAlignment(JLabel.CENTER);
        shortAnswer.setFont(timesRoman);
        midAnswer.setHorizontalAlignment(JLabel.CENTER);
        midAnswer.setFont(timesRoman);

        //JComboBox
        shortBox.setFont(serif2);
        shortBox.addActionListener(this);

        midBox.setFont(serif2);
        midBox.addActionListener(this);

    }

    //actionPerformed
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();
        int index = 0;

        if (shortTerm.isSelected())
        {
            answerPane.removeAll();
            inputPane.removeAll();
            answerPane.add(shortAnswer);
            answerPane.add(shortBox);
            inputPane.add(shortQuestion, BorderLayout.NORTH);
            inputPane.add(answerPane, BorderLayout.SOUTH);

            if (buttonCommand.equals("right"))
            {
                index = shortBox.getSelectedIndex();
                try
                {
                    if (index == 0)
                    {
                        idealGpm = sqlObj.getGpm(name) + 1.0;
                        revenueValue = sqlObj.getRevenueValue(name, idealGpm);
                        costValue = sqlObj.getCostValue(idealGpm);
                    } else if (index == 1)
                    {
                        idealGpm = sqlObj.getGpm(name) + 2.0;
                        revenueValue = sqlObj.getRevenueValue(name, idealGpm);
                        costValue = sqlObj.getCostValue(idealGpm);
                    } else if (index == 2)
                    {
                        idealGpm = sqlObj.getGpm(name) + 3.0;
                        revenueValue = sqlObj.getRevenueValue(name, idealGpm);
                        costValue = sqlObj.getCostValue(idealGpm);
                    } else if (index == 3)
                    {
                        idealGpm = sqlObj.getGpm(name) + 4.0;
                        revenueValue = sqlObj.getRevenueValue(name, idealGpm);
                        costValue = sqlObj.getCostValue(idealGpm);
                    } else if (index == 4)
                    {
                        idealGpm = sqlObj.getGpm(name) + 5.0;
                        revenueValue = sqlObj.getRevenueValue(name, idealGpm);
                        costValue = sqlObj.getCostValue(idealGpm);
                    }
                } catch (SQLException ex)
                {
                    String warning = "Ideal gross profit margin is not found.";
                    ErrorFrame errObj = new ErrorFrame(warning);
                }
                this.dispose();
                ShortSuggestion reader = new ShortSuggestion(idealGpm, revenueValue, costValue, name);
            }
        } else if (midTerm.isSelected())
        {
            answerPane.removeAll();
            inputPane.removeAll();
            answerPane.add(midAnswer);
            answerPane.add(midBox);
            inputPane.add(midQuestion, BorderLayout.NORTH);
            inputPane.add(answerPane, BorderLayout.SOUTH);
            if (buttonCommand.equals("right"))
            {
                index = midBox.getSelectedIndex();
                try
                {
                    if (index == 0)
                    {
                        idealNpm = sqlObj.getGpm(name) + 5.0;
                        expenseValue = sqlObj.getExpenseValue(name, idealNpm);
                    } else if (index == 1)
                    {
                        idealNpm = sqlObj.getGpm(name) + 6.0;
                        expenseValue = sqlObj.getExpenseValue(name, idealNpm);
                    } else if (index == 2)
                    {
                        idealNpm = sqlObj.getGpm(name) + 7.0;
                        expenseValue = sqlObj.getExpenseValue(name, idealNpm);
                    } else if (index == 3)
                    {
                        idealNpm = sqlObj.getGpm(name) + 8.0;
                        expenseValue = sqlObj.getExpenseValue(name, idealNpm);
                    } else if (index == 4)
                    {
                        idealNpm = sqlObj.getGpm(name) + 9.0;
                        expenseValue = sqlObj.getExpenseValue(name, idealNpm);
                    }
                } catch (SQLException ex)
                {
                    String warning = "Ideal net profit margin is not found.";
                    ErrorFrame errObj = new ErrorFrame(warning);
                }
                this.dispose();
                MidSuggestion reader = new MidSuggestion(idealNpm, expenseValue, name);
            }
        }
        if (buttonCommand.equals("left"))
        {
            this.dispose();
            PlanCompany planObj = new PlanCompany();
        }

        this.validate();
        this.repaint();
    }
}