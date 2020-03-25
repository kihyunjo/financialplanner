//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JFrame implements ActionListener, MouseListener
{

    //constants declaration
    private final int FRAME_X = 400;
    private final int FRAME_Y = 10;
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 545;
    private final int FONT_T1 = 70;
    private final int FONT_T2 = 40;
    private final int FONT_S = 30;
    private final int COLOR_GR = 63;
    private final int COLOR_GG = 73;
    private final int COLOR_GB = 86;
    private final int COLOR_NR = 92;
    private final int COLOR_NG = 111;
    private final int COLOR_NB = 132;
    private final int COLOR_IR = 225;
    private final int COLOR_IG = 226;
    private final int COLOR_IB = 217;
    private final int COLOR_BR = 202;
    private final int COLOR_BG = 196;
    private final int COLOR_BB = 182;
    private final int COLOR_CR = 168;
    private final int COLOR_CG = 157;
    private final int COLOR_CB = 145;
    private final java.net.URL PIC_PATH = getClass().getResource("business.png");

    //JPanel
    private JPanel topPane;
    private JPanel underPane;

    //JLabel
    private JLabel title;
    private JLabel description1;
    private JLabel description2;
    private JLabel mainPic;
    private JLabel credit;

    //JButton
    private JButton startButton;

    //Color
    private Color grey;
    private Color navy;
    private Color ivory;
    private Color beige;
    private Color coffee;

    //Font
    private Font timesRoman1;
    private Font timesRoman2;
    private Font serif;
    AccessDb accessObj;
    String dbQuery;
    Connection myDbConn;
    private int status;

    public Welcome()
    {
        super();
      
        //JPanel
        topPane = new JPanel();
        underPane = new JPanel();

        //JLabel
        title = new JLabel("Financial Planner");
        description1 = new JLabel(": helping users manage their ");
        description2 = new JLabel("  financial account through detailed process");
        mainPic = new JLabel(new ImageIcon(PIC_PATH));
        credit = new JLabel("By Kihyun Jo");

        //JButton
        startButton = new JButton("START");

        //Color
        grey = new Color(COLOR_GR, COLOR_GG, COLOR_GB);
        navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);
        ivory = new Color(COLOR_IR, COLOR_IG, COLOR_IB);
        beige = new Color(COLOR_BR, COLOR_BG, COLOR_BB);
        coffee = new Color(COLOR_CR, COLOR_CG, COLOR_CB);

        //Font
        timesRoman1 = new Font("TimesRoman", Font.BOLD, FONT_T1);
        timesRoman2 = new Font("TimesRoman", Font.BOLD, FONT_T2);
        serif = new Font("Serif", Font.BOLD, FONT_S);

        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(
                new BorderLayout());
        this.add(topPane, BorderLayout.NORTH);

        this.add(mainPic, BorderLayout.CENTER);

        this.add(underPane, BorderLayout.SOUTH);

        this.setResizable(
                false);

        //JPanel
        topPane.setLayout(
                new BorderLayout());
        topPane.add(title, BorderLayout.NORTH);

        topPane.add(description1, BorderLayout.CENTER);

        topPane.add(description2, BorderLayout.SOUTH);

        topPane.setBackground(navy);

        underPane.setLayout(
                new BorderLayout());
        underPane.add(startButton, BorderLayout.CENTER);

        underPane.add(credit, BorderLayout.SOUTH);

        underPane.setBackground(navy);

        //JLabel
        title.setFont(timesRoman1);

        title.setHorizontalAlignment(JLabel.LEFT);

        title.setForeground(ivory);

        description1.setFont(serif);

        description1.setHorizontalAlignment(JLabel.LEFT);

        description1.setForeground(beige);

        description2.setFont(serif);

        description2.setHorizontalAlignment(JLabel.LEFT);

        description2.setForeground(beige);

        credit.setFont(serif);

        credit.setForeground(beige);

        credit.setHorizontalAlignment(JLabel.RIGHT);

        mainPic.addMouseListener(
                this);
        mainPic.setToolTipText(
                "start the national anthem");

        //JButton
        startButton.addActionListener(
                this);
        startButton.setToolTipText(
                "start the national anthem");
        startButton.setFont(timesRoman2);

        startButton.setBackground(grey);

        startButton.setOpaque(
                true);
        startButton.setBorderPainted(
                false);
        startButton.setForeground(coffee);

        this.setVisible(
                true);
    }

    //actionPerformed
    public void actionPerformed(ActionEvent e)
    {
        String buttonCommand = e.getActionCommand();
        if (buttonCommand.equals("START"))
        {
            this.dispose();
            Home reader = new Home();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Object myCommand = e.getSource();
        if (myCommand == mainPic)
        {
            this.dispose();
            Home reader = new Home();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    //mainGui
    public static void main(String[] args)
    {
        Welcome mainGui = new Welcome();
    }
}
