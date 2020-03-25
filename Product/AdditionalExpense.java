//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdditionalExpense extends JFrame implements ActionListener
{

    //constants declaration
    private final int FRAME_X = 180;
    private final int FRAME_Y = 10;
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 440;
    private final int TEXT_SIZE = 10;
    private final int FONT_T = 50;
    private final int FONT_S = 25;
    private final int COLOR_YR = 230;
    private final int COLOR_YG = 179;
    private final int COLOR_YB = 78;
    private final int COLOR_NR = 27;
    private final int COLOR_NG = 67;
    private final int COLOR_NB = 102;
    private final int COLOR_GR = 208;
    private final int COLOR_GG = 204;
    private final int COLOR_GB = 194;
    private final int COLOR_CR = 191;
    private final int COLOR_CG = 170;
    private final int COLOR_CB = 150;
    private final int COLOR_BR = 146;
    private final int COLOR_BG = 138;
    private final int COLOR_BB = 129;
    private final java.net.URL LEFT_PATH = getClass().getResource("left.png");
    private final java.net.URL RIGHT_PATH = getClass().getResource("right.png");
    private final int FONT_A = 17;

    //Integer
    private int counter;

    //JLabel
    private JLabel title;
    private JLabel description;
    private JLabel symbol;
    private JLabel warning;
    private JLabel moreSymbol1;
    private JLabel moreSymbol2;
    private JLabel moreSymbol3;
    private JLabel moreSymbol4;
    private JLabel moreSymbol5;

    //JPanel
    private JPanel topPane;
    private JPanel inputPane;
    private JPanel growPane;
    private JPanel midPane;
    private JPanel buttonPane;
    private JPanel morePane1;
    private JPanel morePane2;
    private JPanel morePane3;
    private JPanel morePane4;
    private JPanel morePane5;

    //JTextField
    private JTextField area;
    private JTextField value;
    private JTextField moreArea1;
    private JTextField moreValue1;
    private JTextField moreArea2;
    private JTextField moreValue2;
    private JTextField moreArea3;
    private JTextField moreValue3;
    private JTextField moreArea4;
    private JTextField moreValue4;
    private JTextField moreArea5;
    private JTextField moreValue5;

    //JButton
    private JButton plusButton;
    private JButton leftButton;
    private JButton rightButton;

    //Font
    private Font timesRoman;
    private Font serif1;
    private Font serif2;
    private Font arial;

    //Color
    private Color yellow;
    private Color navy;
    private Color grey;
    private Color coffee;
    private Color brown;

    //object
    private TradingAc tradingObj;
    private ProfitLossAc profitObj;

    //Constructor
    public AdditionalExpense(TradingAc x, ProfitLossAc y)
    {
        super();

        //Integer
        counter = 0;

        //JLabel
        title = new JLabel("Additional Expense");
        description = new JLabel("put name and value if you need");
        symbol = new JLabel(":");
        warning = new JLabel("You reached the limit for the additional expense.");
        moreSymbol1 = new JLabel(":");
        moreSymbol2 = new JLabel(":");
        moreSymbol3 = new JLabel(":");
        moreSymbol4 = new JLabel(":");
        moreSymbol5 = new JLabel(":");

        //JPanel
        topPane = new JPanel(new BorderLayout());
        inputPane = new JPanel(new BorderLayout());
        growPane = new JPanel();
        midPane = new JPanel(new BorderLayout());
        buttonPane = new JPanel(new BorderLayout());
        morePane1 = new JPanel(new BorderLayout());
        morePane2 = new JPanel(new BorderLayout());
        morePane3 = new JPanel(new BorderLayout());
        morePane4 = new JPanel(new BorderLayout());
        morePane5 = new JPanel(new BorderLayout());

        //JTextField
        area = new JTextField(TEXT_SIZE);
        value = new JTextField(TEXT_SIZE);
        moreArea1 = new JTextField(TEXT_SIZE);
        moreValue1 = new JTextField(TEXT_SIZE);
        moreArea2 = new JTextField(TEXT_SIZE);
        moreValue2 = new JTextField(TEXT_SIZE);
        moreArea3 = new JTextField(TEXT_SIZE);
        moreValue3 = new JTextField(TEXT_SIZE);
        moreArea4 = new JTextField(TEXT_SIZE);
        moreValue4 = new JTextField(TEXT_SIZE);
        moreArea5 = new JTextField(TEXT_SIZE);
        moreValue5 = new JTextField(TEXT_SIZE);

        //JButton
        plusButton = new JButton("+");
        leftButton = new JButton(new ImageIcon(LEFT_PATH));
        rightButton = new JButton(new ImageIcon(RIGHT_PATH));

        //Font
        timesRoman = new Font("TimesRoman", Font.BOLD, FONT_T);
        serif1 = new Font("Serif", Font.BOLD, FONT_S);
        serif2 = new Font("Serif", Font.PLAIN, FONT_S);
        arial = new Font("Arial", Font.BOLD, FONT_A);

        //Color
        yellow = new Color(COLOR_YR, COLOR_YG, COLOR_YB);
        navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);
        grey = new Color(COLOR_GR, COLOR_GG, COLOR_GB);
        coffee = new Color(COLOR_CR, COLOR_CG, COLOR_CB);
        brown = new Color(COLOR_BR, COLOR_BG, COLOR_BB);

        tradingObj = new TradingAc();
        profitObj = new ProfitLossAc();
        tradingObj = x;
        profitObj = y;

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(topPane, BorderLayout.NORTH);
        this.add(midPane, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
        this.getContentPane().setBackground(navy);
        this.setVisible(true);

        //JPanel
        topPane.add(title, BorderLayout.NORTH);
        topPane.add(description, BorderLayout.CENTER);
        topPane.setBackground(navy);
        inputPane.add(area, BorderLayout.WEST);
        inputPane.add(symbol, BorderLayout.CENTER);
        inputPane.add(value, BorderLayout.EAST);
        inputPane.setBackground(brown);
        growPane.setLayout(new BoxLayout(growPane, BoxLayout.Y_AXIS));
        growPane.add(inputPane);
        midPane.add(growPane, BorderLayout.NORTH);
        midPane.add(plusButton, BorderLayout.SOUTH);
        midPane.setBackground(coffee);
        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.add(rightButton, BorderLayout.EAST);
        buttonPane.setBackground(navy);

        //JLabel
        title.setFont(timesRoman);
        title.setForeground(yellow);
        description.setFont(serif1);
        description.setForeground(grey);
        symbol.setFont(serif2);
        warning.setFont(arial);
        warning.setForeground(Color.RED);

        //JTextField
        area.setFont(serif2);
        value.setFont(serif2);

        //JButton
        leftButton.addActionListener(this);
        leftButton.setActionCommand("left");
        rightButton.addActionListener(this);
        rightButton.setActionCommand("right");
        plusButton.addActionListener(this);

        counter++;
    }

    //actionPerformed
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();

        if (buttonCommand.equals("+"))
        {
            if (counter < 6)
            {
                if (counter == 1)
                {
                    moreSymbol1.setFont(serif2);
                    moreArea1.setFont(serif2);
                    moreValue1.setFont(serif2);
                    morePane1.setBackground(brown);
                    morePane1.add(moreArea1, BorderLayout.WEST);
                    morePane1.add(moreSymbol1, BorderLayout.CENTER);
                    morePane1.add(moreValue1, BorderLayout.EAST);
                    growPane.add(morePane1);
                    counter++;
                } else if (counter == 2)
                {
                    moreSymbol2.setFont(serif2);
                    moreArea2.setFont(serif2);
                    moreValue2.setFont(serif2);
                    morePane2.setBackground(brown);
                    morePane2.add(moreArea2, BorderLayout.WEST);
                    morePane2.add(moreSymbol2, BorderLayout.CENTER);
                    morePane2.add(moreValue2, BorderLayout.EAST);
                    growPane.add(morePane2);
                    counter++;
                } else if (counter == 3)
                {
                    moreSymbol3.setFont(serif2);
                    moreArea3.setFont(serif2);
                    moreValue3.setFont(serif2);
                    morePane3.setBackground(brown);
                    morePane3.add(moreArea3, BorderLayout.WEST);
                    morePane3.add(moreSymbol3, BorderLayout.CENTER);
                    morePane3.add(moreValue3, BorderLayout.EAST);
                    growPane.add(morePane3);
                    counter++;
                } else if (counter == 4)
                {
                    moreSymbol4.setFont(serif2);
                    moreArea4.setFont(serif2);
                    moreValue4.setFont(serif2);
                    morePane4.setBackground(brown);
                    morePane4.add(moreArea4, BorderLayout.WEST);
                    morePane4.add(moreSymbol4, BorderLayout.CENTER);
                    morePane4.add(moreValue4, BorderLayout.EAST);
                    growPane.add(morePane4);
                    counter++;
                } else if (counter == 5)
                {
                    moreSymbol5.setFont(serif2);
                    moreArea5.setFont(serif2);
                    moreValue5.setFont(serif2);
                    morePane5.setBackground(brown);
                    morePane5.add(moreArea5, BorderLayout.WEST);
                    morePane5.add(moreSymbol5, BorderLayout.CENTER);
                    morePane5.add(moreValue5, BorderLayout.EAST);
                    growPane.add(morePane5);
                    counter++;
                }
            } else
            {
                growPane.add(warning);
                plusButton.setEnabled(false);
            }
        }

        if (buttonCommand.equals("left"))
        {
            this.dispose();
            Registration reader = new Registration();
        } else if (buttonCommand.equals("right"))
        {
            try
            {
                double sum = 0;
                checkEmpty();

                //Check how many inputs there are
                switch (counter)
                {
                    case 0:
                        sum = Double.parseDouble(value.getText());
                        break;
                    case 1:
                        sum = Double.parseDouble(value.getText()) + Double.parseDouble(moreValue1.getText());
                        break;
                    case 2:
                        sum = Double.parseDouble(value.getText()) + Double.parseDouble(moreValue1.getText())
                                + Double.parseDouble(moreValue2.getText());
                        break;
                    case 3:
                        sum = Double.parseDouble(value.getText()) + Double.parseDouble(moreValue1.getText())
                                + Double.parseDouble(moreValue2.getText()) + Double.parseDouble(moreValue3.getText());
                        break;
                    case 4:
                        sum = Double.parseDouble(value.getText()) + Double.parseDouble(moreValue1.getText())
                                + Double.parseDouble(moreValue2.getText()) + Double.parseDouble(moreValue3.getText())
                                + Double.parseDouble(moreValue4.getText());
                        break;
                    case 5:
                        sum = Double.parseDouble(value.getText()) + Double.parseDouble(moreValue1.getText())
                                + Double.parseDouble(moreValue2.getText()) + Double.parseDouble(moreValue3.getText())
                                + Double.parseDouble(moreValue4.getText()) + Double.parseDouble(moreValue5.getText());
                        break;
                    default:
                        break;
                }
                profitObj.addExpense(sum);
                profitObj.setNetProfitBefore(profitObj.calculateNetProfitBefore(tradingObj.getGrossProfit()));
                profitObj.setNetProfitBfTax(profitObj.calculateNetProfitBfTax());

                //find tax and set both tax and net profit after
                profitObj.getNetProfitBfTax();
                try
                {
                    SQLStatement sqlObj = new SQLStatement();
                    profitObj.setTax(profitObj.calculateTax(sqlObj.getSupplementary(profitObj), sqlObj.getRate(profitObj)));
                } catch (SQLException ex)
                {
                    String warning = "Tax is not found.";
                    ErrorFrame errObj = new ErrorFrame(warning);
                }
                profitObj.setNetProfitAfter(profitObj.calculateNetProfitAfter());
                this.setEnabled(false);
                Confirm confirmObj = new Confirm(tradingObj, profitObj, this);
                
            } catch (NumberFormatException exc)
            {
                String warning = "Please write numerical values for expenses";
                ErrorFrame errObj = new ErrorFrame(warning);
            }
        }
        this.validate();
        this.repaint();
    }

    //Check if the JTextfield is empty or not
    public void checkEmpty()
    {
        if (moreValue5.getText().isEmpty())
        {
            moreValue5.setText("0");
        }
        if (moreValue4.getText().isEmpty())
        {
            moreValue4.setText("0");
        }
        if (moreValue3.getText().isEmpty())
        {
            moreValue3.setText("0");
        }
        if (moreValue2.getText().isEmpty())
        {
            moreValue2.setText("0");
        }
        if (moreValue1.getText().isEmpty())
        {
            moreValue1.setText("0");
        }
        if (value.getText().isEmpty())
        {
            value.setText("0");
        }
    }
}