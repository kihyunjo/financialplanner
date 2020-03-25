//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class IncomeStatement extends JFrame implements ActionListener
{

    //constants declaration
    private final int FRAME_X = 400;
    private final int FRAME_Y = 0;
    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 650;
    private final int TEXT_SIZE = 10;
    private final int GRID_ROW = 10;
    private final int GRID_COL = 2;
    private final int GRID_HGAP = 10;
    private final int GRID_VGAP = 30;
    private final java.net.URL LEFT_PATH = getClass().getResource("left.png");
    private final java.net.URL RIGHT_PATH = getClass().getResource("right.png");
    private final int FONT_T = 50;
    private final int FONT_S = 25;
    private final int COLOR_NR = 35;
    private final int COLOR_NG = 59;
    private final int COLOR_NB = 81;
    private final int COLOR_RR = 252;
    private final int COLOR_RG = 39;
    private final int COLOR_RB = 36;
    private final int COLOR_WR = 236;
    private final int COLOR_WG = 241;
    private final int COLOR_WB = 242;
    private final int COLOR_SR = 0;
    private final int COLOR_SG = 152;
    private final int COLOR_SB = 225;
    private final int COLOR_BR = 0;
    private final int COLOR_BG = 127;
    private final int COLOR_BB = 191;
    private final int LINE_SIZE = 5;

    //String
    private String name;

    //JLabel
    private JLabel title;
    private JLabel types;
    private JLabel dollar;
    private JLabel salesRevenue;
    private JLabel srValue;
    private JLabel costOfGoodsSold;
    private JLabel cogsValue;
    private JLabel grossProfit;
    private JLabel gpValue;
    private JLabel expenses;
    private JLabel expValue;
    private JLabel netProfitBf;
    private JLabel npBfValue;
    private JLabel interest;
    private JLabel intValue;
    private JLabel netProfitBfTax;
    private JLabel npBfTxValue;
    private JLabel tax;
    private JLabel txValue;
    private JLabel netProfitAf;
    private JLabel npAfValue;

    //JPanel
    private JPanel inputPane;
    private JPanel buttonPane;

    //JButton
    private JButton leftButton;
    private JButton rightButton;

    //Color
    private Color navy;
    private Color red;
    private Color white;
    private Color sky;
    private Color blue;

    //Font
    private Font timesRoman;
    private Font serif1;
    private Font serif2;

    //Border
    private Border mainBorder;

    private TradingAc tradingObj;

    //Constructor
    public IncomeStatement(String pName) throws SQLException
    {
        super();

        name = pName;

        //JLabel
        title = new JLabel(name + " Income Statement");
        types = new JLabel("Types");
        dollar = new JLabel("$");
        salesRevenue = new JLabel("Sales Revenue");
        costOfGoodsSold = new JLabel("Cost of Goods Sold");
        grossProfit = new JLabel("Gross Profit");
        expenses = new JLabel("Expenses");
        netProfitBf = new JLabel("Net Profit Before Interest + Tax");
        interest = new JLabel("Interest");
        netProfitBfTax = new JLabel("Net Profit Before Tax");
        tax = new JLabel("Tax");
        netProfitAf = new JLabel("Net Profit After Interest + Tax");

        //JPanel
        inputPane = new JPanel(new GridLayout(GRID_ROW, GRID_COL, GRID_HGAP, GRID_VGAP));
        buttonPane = new JPanel(new BorderLayout());

        //JButton
        leftButton = new JButton(new ImageIcon(LEFT_PATH));
        rightButton = new JButton(new ImageIcon(RIGHT_PATH));

        //Color
        navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);
        red = new Color(COLOR_RR, COLOR_RG, COLOR_RB);
        white = new Color(COLOR_WR, COLOR_WG, COLOR_WB);
        sky = new Color(COLOR_SR, COLOR_SG, COLOR_SB);
        blue = new Color(COLOR_BR, COLOR_BG, COLOR_BB);

        //Font
        timesRoman = new Font("TimesRoman", Font.BOLD, FONT_T);
        serif1 = new Font("Serif", Font.BOLD, FONT_S);
        serif2 = new Font("Serif", Font.BOLD, FONT_S);

        //Border
        mainBorder = new LineBorder(red, LINE_SIZE);

        //methods
        setValues();

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(navy);
        this.add(title, BorderLayout.NORTH);
        this.add(inputPane, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
        this.setVisible(true);

        //JPanel
        inputPane.add(types);
        inputPane.add(dollar);
        inputPane.add(salesRevenue);
        inputPane.add(srValue);
        inputPane.add(costOfGoodsSold);
        inputPane.add(cogsValue);
        inputPane.add(grossProfit);
        inputPane.add(gpValue);
        inputPane.add(expenses);
        inputPane.add(expValue);
        inputPane.add(netProfitBf);
        inputPane.add(npBfValue);
        inputPane.add(interest);
        inputPane.add(intValue);
        inputPane.add(netProfitBfTax);
        inputPane.add(npBfTxValue);
        inputPane.add(tax);
        inputPane.add(txValue);
        inputPane.add(netProfitAf);
        inputPane.add(npAfValue);
        inputPane.setBackground(white);
        inputPane.setBorder(mainBorder);
        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.add(rightButton, BorderLayout.EAST);
        buttonPane.setBackground(navy);

        //JLabel
        title.setFont(timesRoman);
        title.setForeground(red);
        title.setHorizontalAlignment(JLabel.CENTER);
        types.setFont(serif1);
        types.setForeground(navy);
        types.setHorizontalAlignment(JLabel.CENTER);
        dollar.setFont(serif1);
        dollar.setForeground(navy);
        dollar.setHorizontalAlignment(JLabel.CENTER);
        salesRevenue.setFont(serif2);
        salesRevenue.setForeground(blue);
        salesRevenue.setHorizontalAlignment(JLabel.CENTER);
        srValue.setFont(serif2);
        srValue.setForeground(blue);
        srValue.setHorizontalAlignment(JLabel.CENTER);
        costOfGoodsSold.setFont(serif2);
        costOfGoodsSold.setForeground(blue);
        costOfGoodsSold.setHorizontalAlignment(JLabel.CENTER);
        cogsValue.setFont(serif2);
        cogsValue.setForeground(blue);
        cogsValue.setHorizontalAlignment(JLabel.CENTER);
        grossProfit.setFont(serif2);
        grossProfit.setForeground(blue);
        grossProfit.setHorizontalAlignment(JLabel.CENTER);
        gpValue.setFont(serif2);
        gpValue.setForeground(blue);
        gpValue.setHorizontalAlignment(JLabel.CENTER);
        expenses.setFont(serif2);
        expenses.setForeground(blue);
        expenses.setHorizontalAlignment(JLabel.CENTER);
        expValue.setFont(serif2);
        expValue.setForeground(blue);
        expValue.setHorizontalAlignment(JLabel.CENTER);
        netProfitBf.setFont(serif2);
        netProfitBf.setForeground(blue);
        netProfitBf.setHorizontalAlignment(JLabel.CENTER);
        npBfValue.setFont(serif2);
        npBfValue.setForeground(blue);
        npBfValue.setHorizontalAlignment(JLabel.CENTER);
        interest.setFont(serif2);
        interest.setForeground(blue);
        interest.setHorizontalAlignment(JLabel.CENTER);
        intValue.setFont(serif2);
        intValue.setForeground(blue);
        intValue.setHorizontalAlignment(JLabel.CENTER);
        netProfitBfTax.setFont(serif2);
        netProfitBfTax.setForeground(blue);
        netProfitBfTax.setHorizontalAlignment(JLabel.CENTER);
        npBfTxValue.setFont(serif2);
        npBfTxValue.setForeground(blue);
        npBfTxValue.setHorizontalAlignment(JLabel.CENTER);
        tax.setFont(serif2);
        tax.setForeground(blue);
        tax.setHorizontalAlignment(JLabel.CENTER);
        txValue.setFont(serif2);
        txValue.setForeground(blue);
        txValue.setHorizontalAlignment(JLabel.CENTER);
        netProfitAf.setFont(serif2);
        netProfitAf.setForeground(blue);
        netProfitAf.setHorizontalAlignment(JLabel.CENTER);
        npAfValue.setFont(serif2);
        npAfValue.setForeground(blue);
        npAfValue.setHorizontalAlignment(JLabel.CENTER);

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
            StatementCompany reader = new StatementCompany();
        } else if (buttonCommand.equals("right"))
        {
            this.dispose();
            Home reader = new Home();
        }
    }

    //setValues
    public void setValues() throws SQLException
    {
        double[] valueArr;
        SQLStatement sqlObj = new SQLStatement();
        valueArr = sqlObj.getValues(name);
        srValue = new JLabel(Double.toString(valueArr[0]));
        cogsValue = new JLabel(Double.toString(valueArr[1]));
        gpValue = new JLabel(Double.toString(valueArr[2]));
        expValue = new JLabel(Double.toString(valueArr[3]));
        npBfValue = new JLabel(Double.toString(valueArr[4]));
        intValue = new JLabel(Double.toString(valueArr[5]));
        npBfTxValue = new JLabel(Double.toString(valueArr[6]));
        txValue = new JLabel(Double.toString(valueArr[7]));
        npAfValue = new JLabel(Double.toString(valueArr[8]));
    }
}