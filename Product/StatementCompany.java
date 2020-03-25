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
import javax.swing.JTextField;

public class StatementCompany extends JFrame implements ActionListener
{

    //Constants Declaration
    private final java.net.URL LEFT_PATH = getClass().getResource("left.png");
    private final int FRAME_X = 400;
    private final int FRAME_Y = 0;
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 400;
    private final int FONT_T1 = 30;
    private final java.net.URL BRAND_PATH = getClass().getResource("brand.png");
    private final int COLOR_NR = 0;
    private final int COLOR_NG = 46;
    private final int COLOR_NB = 93;
    private final int COLOR_BR = 79;
    private final int COLOR_BG = 141;
    private final int COLOR_BB = 198;
    private final int COLOR_GR = 232;
    private final int COLOR_GG = 231;
    private final int COLOR_GB = 231;
    private final int COLOR_YR = 255;
    private final int COLOR_YG = 194;
    private final int COLOR_YB = 0;
    private final int COLOR_OR = 252;
    private final int COLOR_OG = 168;
    private final int COLOR_OB = 49;
    private final int FONT_S1 = 25;

    //JPanel
    private JPanel buttonPane;
    private JPanel inputPane;
    private JPanel midPane;

    //JLabel
    private JLabel instruction;
    private JLabel brand;

    //JTextField
    private JTextField input;

    //JButton
    private JButton ok;
    private JButton leftButton;

    //Font
    private Font timesRoman1;
    private Font serif1;

    //Color
    private Color navy;
    private Color blue;
    private Color grey;
    private Color yellow;
    private Color orange;

    private TradingAc tradingObj;

    public StatementCompany()
    {
        super();

        //JPanel
        buttonPane = new JPanel(new BorderLayout());
        inputPane = new JPanel(new FlowLayout());
        midPane = new JPanel(new BorderLayout());

        //JLabel
        instruction = new JLabel("Enter the name of your company");
        brand = new JLabel(new ImageIcon(BRAND_PATH));

        //JTextField
        input = new JTextField(10);

        //JButton
        ok = new JButton("OK");
        leftButton = new JButton(new ImageIcon(LEFT_PATH));

        //Font
        timesRoman1 = new Font("TimesRoman", Font.BOLD, FONT_T1);
        serif1 = new Font("Serif", Font.PLAIN, FONT_S1);

        //Color
        navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);
        blue = new Color(COLOR_BR, COLOR_BG, COLOR_BB);
        grey = new Color(COLOR_GR, COLOR_GG, COLOR_GB);
        yellow = new Color(COLOR_YR, COLOR_YG, COLOR_YB);
        orange = new Color(COLOR_OR, COLOR_OG, COLOR_OB);

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(navy);
        this.add(instruction, BorderLayout.NORTH);
        this.add(midPane, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
        this.setVisible(true);

        //JPanel
        midPane.add(inputPane, BorderLayout.NORTH);
        midPane.add(brand, BorderLayout.CENTER);
        midPane.setBackground(yellow);
        inputPane.add(input);
        inputPane.add(ok);
        inputPane.setBackground(blue);
        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.setBackground(orange);

        //JButton
        leftButton.setActionCommand("left");
        leftButton.addActionListener(this);
        ok.addActionListener(this);

        //JLabel
        instruction.setHorizontalAlignment(JLabel.CENTER);
        instruction.setForeground(grey);
        instruction.setFont(timesRoman1);

        //JTextField
        input.setFont(serif1);

        tradingObj = new TradingAc();
    }

    //actionPerformed
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();
        SQLStatement sqlObj = new SQLStatement();
        if (buttonCommand.equals("left"))
        {
            this.dispose();
            Home reader = new Home();
        } else if (buttonCommand.equals("OK"))
        {
            try
            {
                if (sqlObj.checkingName(input.getText()))
                {
                    if (buttonCommand.equals("left"))
                    {
                        this.dispose();
                        Home reader = new Home();
                    } else if (buttonCommand.equals("OK"))
                    {
                        this.dispose();
                        try
                        {
                            IncomeStatement incomeObj = new IncomeStatement(input.getText());
                        } catch (SQLException ex)
                        {
                            Logger.getLogger(StatementCompany.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else
                {
                    String warning = "Please write the name of the company you registered.";
                    ErrorFrame errObj = new ErrorFrame(warning);
                    input.setText("");
                }
            } catch (SQLException ex)
            {
                Logger.getLogger(StatementCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
