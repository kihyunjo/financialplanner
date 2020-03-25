//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Registration extends JFrame implements ActionListener
{

    //constants declaration
    private final int FRAME_X = 180;
    private final int FRAME_Y = 30;
    private final int FRAME_WIDTH = 960;
    private final int FRAME_HEIGHT = 540;
    private final int COLOR_BR = 88;
    private final int COLOR_BG = 75;
    private final int COLOR_BB = 77;
    private final int COLOR_PR = 213;
    private final int COLOR_PG = 149;
    private final int COLOR_PB = 123;
    private final int COLOR_IR = 239;
    private final int COLOR_IG = 223;
    private final int COLOR_IB = 205;
    private final int COLOR_SR = 146;
    private final int COLOR_SG = 191;
    private final int COLOR_SB = 218;
    private final int COLOR_NR = 59;
    private final int COLOR_NG = 71;
    private final int COLOR_NB = 103;
    private final int FONT_T = 50;
    private final int FONT_S1 = 25;
    private final int FONT_S2 = 20;
    private final int TEXT_SIZE = 10;
    private final int GRID_ROW = 6;
    private final int GRID_COL = 2;
    private final int GRID_HGAP = 10;
    private final int GRID_VGAP = 30;
    private final java.net.URL LEFT_PATH = getClass().getResource("left.png");
    private final java.net.URL RIGHT_PATH = getClass().getResource("right.png");

    //JLabel
    private JLabel title;
    private JLabel name;
    private JLabel quantity;
    private JLabel price;
    private JLabel open;
    private JLabel purchase;
    private JLabel close;
    private JLabel rent;
    private JLabel electricity;
    private JLabel water;
    private JLabel internet;
    private JLabel insurance;
    private JLabel salary;
    private JLabel interest;

    //JTextField
    private JTextField nameText;
    private JTextField quantityText;
    private JTextField priceText;
    private JTextField openText;
    private JTextField purchaseText;
    private JTextField closeText;
    private JTextField rentText;
    private JTextField electricityText;
    private JTextField waterText;
    private JTextField internetText;
    private JTextField insuranceText;
    private JTextField salaryText;
    private JTextField interestText;

    //JPanel
    private JPanel inputPane1;
    private JPanel inputPane2;
    private JPanel midPane;
    private JPanel buttonPane;
    private JPanel namePane;
    private JPanel centerPane;

    //JButton
    private JButton submit;
    private JButton leftButton;
    private JButton rightButton;

    //Color
    private Color brown;
    private Color plum;
    private Color ivory;
    private Color sky;
    private Color navy;

    //Font
    private Font timesRoman;
    private Font serif1;
    private Font serif2;

    //Border
    private Border firstBorder1;
    private Border firstBorder2;
    private Border firstBorder;
    private Border secondBorder1;
    private Border secondBorder2;
    private Border secondBorder;

    //object
    ProfitLossAc profitObj = new ProfitLossAc();
    TradingAc tradingObj = new TradingAc();

    public Registration()
    {
        super();

        //JLabel
        title = new JLabel("Registration");
        name = new JLabel("Company Name : ");
        quantity = new JLabel("Quantity : ");
        price = new JLabel("Price : ");
        open = new JLabel("Opening Stock : ");
        purchase = new JLabel("Purchases : ");
        close = new JLabel("Closing Stock : ");
        rent = new JLabel("Rent : ");
        electricity = new JLabel("Electricity : ");
        water = new JLabel("Water : ");
        internet = new JLabel("Phone/Internet : ");
        insurance = new JLabel("Insurance : ");
        salary = new JLabel("Salary : ");
        interest = new JLabel("Interest : ");

        //JTextField
        nameText = new JTextField(TEXT_SIZE);
        quantityText = new JTextField(TEXT_SIZE);
        priceText = new JTextField(TEXT_SIZE);
        openText = new JTextField(TEXT_SIZE);
        purchaseText = new JTextField(TEXT_SIZE);
        closeText = new JTextField(TEXT_SIZE);
        rentText = new JTextField(TEXT_SIZE);
        electricityText = new JTextField(TEXT_SIZE);
        waterText = new JTextField(TEXT_SIZE);
        internetText = new JTextField(TEXT_SIZE);
        insuranceText = new JTextField(TEXT_SIZE);
        salaryText = new JTextField(TEXT_SIZE);
        interestText = new JTextField(TEXT_SIZE);

        //JPanel
        inputPane1 = new JPanel(new GridLayout(GRID_ROW, GRID_COL, GRID_HGAP, GRID_VGAP));
        inputPane2 = new JPanel(new GridLayout(GRID_ROW, GRID_COL, GRID_HGAP, GRID_VGAP));
        midPane = new JPanel(new FlowLayout());
        buttonPane = new JPanel(new BorderLayout());
        namePane = new JPanel(new FlowLayout());
        centerPane = new JPanel(new BorderLayout());

        //JButton
        submit = new JButton("SUBMIT");
        leftButton = new JButton(new ImageIcon(LEFT_PATH));
        rightButton = new JButton(new ImageIcon(RIGHT_PATH));

        //Color
        brown = new Color(COLOR_BR, COLOR_BG, COLOR_BB);
        plum = new Color(COLOR_PR, COLOR_PG, COLOR_PB);
        ivory = new Color(COLOR_IR, COLOR_IG, COLOR_IB);
        sky = new Color(COLOR_SR, COLOR_SG, COLOR_SB);
        navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);

        //Font
        timesRoman = new Font("TimesRoman", Font.BOLD, FONT_T);
        serif1 = new Font("Serif", Font.BOLD, FONT_S1);
        serif2 = new Font("Serif", Font.PLAIN, FONT_S2);

        //Border
        firstBorder1 = new LineBorder(plum, 3);
        firstBorder2 = new TitledBorder(firstBorder1);
        firstBorder = new TitledBorder(firstBorder2,
                "Trading Account", TitledBorder.CENTER, TitledBorder.TOP, serif1);
        secondBorder1 = new LineBorder(plum, 3);
        secondBorder2 = new TitledBorder(secondBorder1);
        secondBorder = new TitledBorder(secondBorder2,
                "Profit & Loss Account", TitledBorder.CENTER, TitledBorder.TOP, serif1);

        //object
        profitObj = new ProfitLossAc();
        tradingObj = new TradingAc();

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(brown);
        this.add(title, BorderLayout.NORTH);
        this.add(centerPane, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
        this.setVisible(true);

        //JLabel + JTextField
        name.setFont(serif1);
        name.setForeground(sky);
        nameText.setFont(serif2);
        title.setForeground(ivory);
        title.setFont(timesRoman);
        title.setHorizontalAlignment(JLabel.CENTER);
        quantity.setFont(serif1);
        quantity.setForeground(sky);
        quantityText.setFont(serif2);
        price.setFont(serif1);
        price.setForeground(sky);
        priceText.setFont(serif2);
        open.setFont(serif1);
        open.setForeground(sky);
        openText.setFont(serif2);
        purchase.setFont(serif1);
        purchase.setForeground(sky);
        purchaseText.setFont(serif2);
        close.setFont(serif1);
        close.setForeground(sky);
        closeText.setFont(serif2);
        rent.setFont(serif1);
        rent.setForeground(sky);
        rentText.setFont(serif2);
        electricity.setFont(serif1);
        electricity.setForeground(sky);
        electricityText.setFont(serif2);
        water.setFont(serif1);
        water.setForeground(sky);
        waterText.setFont(serif2);
        internet.setFont(serif1);
        internet.setForeground(sky);
        internetText.setFont(serif2);
        insurance.setFont(serif1);
        insurance.setForeground(sky);
        insuranceText.setFont(serif2);
        salary.setFont(serif1);
        salary.setForeground(sky);
        salaryText.setFont(serif2);
        interest.setFont(serif1);
        interest.setForeground(sky);
        interestText.setFont(serif2);

        //JPanel
        namePane.add(name);
        namePane.add(nameText);
        namePane.setBackground(navy);

        centerPane.add(namePane, BorderLayout.NORTH);
        centerPane.add(midPane, BorderLayout.CENTER);

        inputPane1.add(quantity);
        inputPane1.add(quantityText);
        inputPane1.add(price);
        inputPane1.add(priceText);
        inputPane1.add(open);
        inputPane1.add(openText);
        inputPane1.add(purchase);
        inputPane1.add(purchaseText);
        inputPane1.add(close);
        inputPane1.add(closeText);
        inputPane1.add(interest);
        inputPane1.add(interestText);
        inputPane1.setBackground(navy);
        inputPane1.setBorder(firstBorder);

        inputPane2.add(rent);
        inputPane2.add(rentText);
        inputPane2.add(electricity);
        inputPane2.add(electricityText);
        inputPane2.add(water);
        inputPane2.add(waterText);
        inputPane2.add(internet);
        inputPane2.add(internetText);
        inputPane2.add(insurance);
        inputPane2.add(insuranceText);
        inputPane2.add(salary);
        inputPane2.add(salaryText);
        inputPane2.setBackground(navy);
        inputPane2.setBorder(secondBorder);

        midPane.add(inputPane1);
        midPane.add(inputPane2);
        midPane.setBackground(navy);

        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.add(rightButton, BorderLayout.EAST);
        buttonPane.setBackground(ivory);

        //JButton
        leftButton.addActionListener(this);
        leftButton.setActionCommand("left");
        rightButton.addActionListener(this);
        rightButton.setActionCommand("right");
    }

    //actionPerformed
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();

        if (buttonCommand.equals("left"))
        {
            this.dispose();
            Home reader = new Home();
        } else if (buttonCommand.equals("right"))
        {

            if (nameText.getText().equals("") || quantityText.getText().equals("")
                    || priceText.getText().equals("") || openText.getText().equals("")
                    || purchaseText.getText().equals("") || closeText.getText().equals("")
                    || rentText.getText().equals("") || electricityText.getText().equals("")
                    || waterText.getText().equals("") || internetText.getText().equals("")
                    || insuranceText.getText().equals("") || salaryText.getText().equals("")
                    || interestText.getText().equals(""))
            {
                String warning = "Please fill out everything on the form.";
                ErrorFrame errObj = new ErrorFrame(warning);
            } else
            {
                try
                {
                    tradingObj.setName(nameText.getText());
                    tradingObj.setQuantity(Double.parseDouble(quantityText.getText()));
                    tradingObj.setPrice(Double.parseDouble(priceText.getText()));
                    tradingObj.setOpeningStock(Double.parseDouble(openText.getText()));
                    tradingObj.setPurchases(Double.parseDouble(purchaseText.getText()));
                    tradingObj.setClosingStock(Double.parseDouble(closeText.getText()));
                    tradingObj.setSalesRevenue(tradingObj.calculateSalesRevenue());
                    tradingObj.setCostOfGoodsSold(tradingObj.calculateCostOfGoodsSold());
                    tradingObj.setGrossProfit(tradingObj.calculateGrossProfit());

                    profitObj.setRent(Double.parseDouble(rentText.getText()));
                    profitObj.setElectricity(Double.parseDouble(electricityText.getText()));
                    profitObj.setWater(Double.parseDouble(waterText.getText()));
                    profitObj.setInternet(Double.parseDouble(internetText.getText()));
                    profitObj.setInsurance(Double.parseDouble(insuranceText.getText()));
                    profitObj.setSalary(Double.parseDouble(salaryText.getText()));
                    profitObj.setExpenses(profitObj.calculateExpenses());
                    profitObj.setNetProfitBefore(profitObj.calculateNetProfitBefore(tradingObj.getGrossProfit()));
                    profitObj.setInterest(Double.parseDouble(interestText.getText()));
                    profitObj.setNetProfitBfTax(profitObj.calculateNetProfitBfTax());

                    AdditionalExpense addObj = new AdditionalExpense(tradingObj, profitObj);
                    this.dispose();
                } catch (NumberFormatException exc)
                {
                    String warning = "Please write numerical values for both account areas.";
                    ErrorFrame errObj = new ErrorFrame(warning);
                }
            }
        }
    }
}