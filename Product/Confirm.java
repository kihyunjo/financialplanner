//package financialplanner;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Confirm extends JFrame implements ActionListener
{

    //constants declaration
    private final int FRAME_X = 450;
    private final int FRAME_Y = 250;
    private final int FRAME_WIDTH = 470;
    private final int FRAME_HEIGHT = 120;
    private final int FONT_A = 18;
    private final int GREEN_R = 196;
    private final int GREEN_G = 212;
    private final int GREEN_B = 175;
    private final int GREY_R = 173;
    private final int GREY_G = 196;
    private final int GREY_B = 204;
    private final Color GREEN = new Color(GREEN_R, GREEN_G, GREEN_B);
    private final Color GREY = new Color(GREY_R, GREY_G, GREY_B);
    private final Font ARIAL = new Font("Arial", Font.PLAIN, FONT_A);
    private final java.net.URL CONFIRM_PATH = getClass().getResource("check.png");

    //JFrame
    private JFrame gFrame;
    
    //JLabel
    private JLabel symbol;
    private JLabel info;
    
    //JButton
    private JButton ok;
    
    //Integer
    private int status;
    
    private TradingAc tradingObj;
    private ProfitLossAc profitObj;

    //Constructor
    public Confirm(TradingAc x, ProfitLossAc y, JFrame addFrame)
    {
        super();
        
        //JFrame
        gFrame = addFrame;
        
        //JLabel
        symbol = new JLabel(new ImageIcon(CONFIRM_PATH));
        info = new JLabel("Your company is completely registered on the program.");

        //JButton
        ok = new JButton("OK");

        //Object
        tradingObj = x;
        profitObj = y;

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(GREEN);

        //JLabel
        info.setFont(ARIAL);

        //JButton
        ok.addActionListener((ActionListener) this);
        ok.setBackground(GREY);
        ok.setOpaque(true);
        ok.setBorderPainted(false);

        this.add(symbol);
        this.add(info);
        this.add(ok);
        this.setVisible(true);
    }

    //actionPerformed
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();

        if (buttonCommand.equals("OK"))
        {
            SQLStatement sqlObj = new SQLStatement();
            sqlObj.insertIncomeStatement(tradingObj, profitObj);
            this.dispose();
            gFrame.dispose();
            Home reader = new Home();
        } else
        {
            System.out.println("Unexpected error");
        }
    }
}