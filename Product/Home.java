//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Home extends JFrame implements ActionListener
{

    //Constants Declaration
    private final int FRAME_X = 0;
    private final int FRAME_Y = 0;
    private final int FRAME_WIDTH = 1355;
    private final int FRAME_HEIGHT = 550;
    private final java.net.URL registerPath = getClass().getResource("register.jpg");
    private final java.net.URL statementPath = getClass().getResource("statement.jpg");
    private final java.net.URL planPath = getClass().getResource("plan.jpg");
    private final int GRID_ROW = 1;
    private final int GRID_COL = 3;
    private final int GRID_HGAP = 1;
    private final int GRID_VGAP = 1;
    private final java.net.URL LEFT_PATH = getClass().getResource("left.png");
    private final int FONT_T1 = 40;
    private final int FONT_T2 = 55;
    private final int FONT_S1 = 25;
    private final int FONT_S2 = 28;
    private final int COLOR_NR = 41;
    private final int COLOR_NG = 52;
    private final int COLOR_NB = 73;
    private final int COLOR_PR = 240;
    private final int COLOR_PG = 157;
    private final int COLOR_PB = 146;
    private final int COLOR_YR = 225;
    private final int COLOR_YG = 186;
    private final int COLOR_YB = 0;
    private final int COLOR_CR = 242;
    private final int COLOR_CG = 221;
    private final int COLOR_CB = 145;
    private final int COLOR_OR = 237;
    private final int COLOR_OG = 113;
    private final int COLOR_OB = 83;
    private final java.net.URL GO_PATH = getClass().getResource("go.png");

    //JLabel
    private JLabel title = new JLabel("Financial Planner");
    private JLabel info1 = new JLabel("Registering your company");
    private JLabel info2 = new JLabel("Viewing income statement");
    private JLabel info3 = new JLabel("Planning to increase profitability ratio");
    private JLabel arr1 = new JLabel("⇒");
    private JLabel arr2 = new JLabel("⇒");
    private JLabel arr3 = new JLabel("⇒");
    private JLabel registerPic = new JLabel(new ImageIcon(registerPath));
    private JLabel statementPic = new JLabel(new ImageIcon(statementPath));
    private JLabel planPic = new JLabel(new ImageIcon(planPath));

    //JButton
    private JButton go1 = new JButton(new ImageIcon(GO_PATH));
    private JButton go2 = new JButton(new ImageIcon(GO_PATH));
    private JButton go3 = new JButton(new ImageIcon(GO_PATH));
    private JButton leftButton = new JButton(new ImageIcon(LEFT_PATH));

    //JPanel
    private JPanel topPane = new JPanel(new BorderLayout());
    private JPanel mainPane = new JPanel(new GridLayout(GRID_ROW, GRID_COL, GRID_HGAP, GRID_VGAP));
    private JPanel firstPane1 = new JPanel(new BorderLayout());
    private JPanel secondPane1 = new JPanel(new BorderLayout());
    private JPanel thirdPane1 = new JPanel(new BorderLayout());
    private JPanel firstPane2 = new JPanel(new BorderLayout());
    private JPanel secondPane2 = new JPanel(new BorderLayout());
    private JPanel thirdPane2 = new JPanel(new BorderLayout());
    private JPanel buttonPane = new JPanel(new BorderLayout());

    //Font
    private Font timesRoman1 = new Font("TimesRoman", Font.BOLD, FONT_T1);
    private Font timesRoman2 = new Font("TimesRoman", Font.BOLD, FONT_T2);
    private Font serif1 = new Font("Serif", Font.BOLD, FONT_S1);
    private Font serif2 = new Font("Serif", Font.BOLD, FONT_S2);

    //Color
    private Color navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);
    private Color pink = new Color(COLOR_PR, COLOR_PG, COLOR_PB);
    private Color yellow = new Color(COLOR_YR, COLOR_YG, COLOR_YB);
    private Color cream = new Color(COLOR_CR, COLOR_CG, COLOR_CB);
    private Color orange = new Color(COLOR_OR, COLOR_OG, COLOR_OB);

    //Border
    private Border firstBorder1 = new LineBorder(yellow, 3);
    private Border firstBorder2 = new TitledBorder(firstBorder1);
    private Border firstBorder = new TitledBorder(firstBorder2,
            "Register", TitledBorder.CENTER, TitledBorder.TOP, timesRoman1, orange);
    private Border secondBorder1 = new LineBorder(yellow, 3);
    private Border secondBorder2 = new TitledBorder(secondBorder1);
    private Border secondBorder = new TitledBorder(secondBorder2,
            "Income Statement", TitledBorder.CENTER, TitledBorder.TOP, timesRoman1, orange);
    private Border thirdBorder1 = new LineBorder(yellow, 3);
    private Border thirdBorder2 = new TitledBorder(thirdBorder1);
    private Border thirdBorder = new TitledBorder(thirdBorder2,
            "Plan", TitledBorder.CENTER, TitledBorder.TOP, timesRoman1, orange);

    //Constructor
    public Home()
    {
        super();

        //JLabel
        title = new JLabel("Financial Planner");
        info1 = new JLabel("Registering your company");
        info2 = new JLabel("Viewing income statement");
        info3 = new JLabel("Planning to increase profitability ratio");
        arr1 = new JLabel("⇒");
        arr2 = new JLabel("⇒");
        arr3 = new JLabel("⇒");
        registerPic = new JLabel(new ImageIcon(registerPath));
        statementPic = new JLabel(new ImageIcon(statementPath));
        planPic = new JLabel(new ImageIcon(planPath));

        //JButton
        JButton go1 = new JButton(new ImageIcon(GO_PATH));
        go2 = new JButton(new ImageIcon(GO_PATH));
        go3 = new JButton(new ImageIcon(GO_PATH));
        leftButton = new JButton(new ImageIcon(LEFT_PATH));

        //JPanel
        topPane = new JPanel(new BorderLayout());
        mainPane = new JPanel(new GridLayout(GRID_ROW, GRID_COL, GRID_HGAP, GRID_VGAP));
        firstPane1 = new JPanel(new BorderLayout());
        secondPane1 = new JPanel(new BorderLayout());
        thirdPane1 = new JPanel(new BorderLayout());
        firstPane2 = new JPanel(new BorderLayout());
        secondPane2 = new JPanel(new BorderLayout());
        thirdPane2 = new JPanel(new BorderLayout());
        buttonPane = new JPanel(new BorderLayout());

        //Font
        timesRoman1 = new Font("TimesRoman", Font.BOLD, FONT_T1);
        timesRoman2 = new Font("TimesRoman", Font.BOLD, FONT_T2);
        serif1 = new Font("Serif", Font.BOLD, FONT_S1);
        serif2 = new Font("Serif", Font.BOLD, FONT_S2);

        //Color
        navy = new Color(COLOR_NR, COLOR_NG, COLOR_NB);
        pink = new Color(COLOR_PR, COLOR_PG, COLOR_PB);
        yellow = new Color(COLOR_YR, COLOR_YG, COLOR_YB);
        cream = new Color(COLOR_CR, COLOR_CG, COLOR_CB);
        orange = new Color(COLOR_OR, COLOR_OG, COLOR_OB);

        //Border
        firstBorder1 = new LineBorder(yellow, 3);
        firstBorder2 = new TitledBorder(firstBorder1);
        firstBorder = new TitledBorder(firstBorder2,
                "Register", TitledBorder.CENTER, TitledBorder.TOP, timesRoman1, orange);
        secondBorder1 = new LineBorder(yellow, 3);
        secondBorder2 = new TitledBorder(secondBorder1);
        Border secondBorder = new TitledBorder(secondBorder2,
                "Income Statement", TitledBorder.CENTER, TitledBorder.TOP, timesRoman1, orange);
        thirdBorder1 = new LineBorder(yellow, 3);
        thirdBorder2 = new TitledBorder(thirdBorder1);
        thirdBorder = new TitledBorder(thirdBorder2,
                "Plan", TitledBorder.CENTER, TitledBorder.TOP, timesRoman1, orange);
        //JFrame
        this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(topPane, BorderLayout.NORTH);
        this.add(mainPane, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
        this.getContentPane().setBackground(navy);
        this.setResizable(false);
        this.setVisible(true);

        //JPanel
        firstPane1.add(arr1, BorderLayout.WEST);
        firstPane1.add(info1, BorderLayout.CENTER);
        firstPane1.add(go1, BorderLayout.SOUTH);
        firstPane1.setBackground(navy);
        firstPane2.add(firstPane1, BorderLayout.NORTH);
        firstPane2.add(registerPic, BorderLayout.CENTER);
        firstPane2.setBorder(firstBorder);
        firstPane2.setBackground(navy);

        secondPane1.add(arr2, BorderLayout.WEST);
        secondPane1.add(info2, BorderLayout.CENTER);
        secondPane1.add(go2, BorderLayout.SOUTH);
        secondPane1.setBackground(navy);
        secondPane2.add(secondPane1, BorderLayout.NORTH);
        secondPane2.add(statementPic, BorderLayout.CENTER);
        secondPane2.setBorder(secondBorder);
        secondPane2.setBackground(navy);

        thirdPane1.add(arr3, BorderLayout.WEST);
        thirdPane1.add(info3, BorderLayout.CENTER);
        thirdPane1.add(go3, BorderLayout.SOUTH);
        thirdPane1.setBackground(navy);
        thirdPane2.add(thirdPane1, BorderLayout.NORTH);
        thirdPane2.add(planPic, BorderLayout.CENTER);
        thirdPane2.setBorder(thirdBorder);
        thirdPane2.setBackground(navy);

        mainPane.add(firstPane2);
        mainPane.add(secondPane2);
        mainPane.add(thirdPane2);
        mainPane.setBackground(navy);

        topPane.add(title, BorderLayout.CENTER);
        topPane.setBackground(navy);

        buttonPane.add(leftButton, BorderLayout.WEST);
        buttonPane.setBackground(navy);

        //JLabel
        title.setFont(timesRoman2);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(pink);
        info1.setFont(serif1);
        info1.setForeground(cream);
        info2.setFont(serif1);
        info2.setForeground(cream);
        info3.setFont(serif1);
        info3.setForeground(cream);
        arr1.setFont(serif2);
        arr1.setForeground(orange);
        arr2.setFont(serif2);
        arr2.setForeground(orange);
        arr3.setFont(serif2);
        arr3.setForeground(orange);

        //JButton
        go1.setBackground(navy);
        go1.setOpaque(true);
        go1.setBorderPainted(false);
        go1.addActionListener(this);
        go1.setActionCommand("go1");
        go2.setBackground(navy);
        go2.setOpaque(true);
        go2.setBorderPainted(false);
        go2.addActionListener(this);
        go2.setActionCommand("go2");
        go3.setBackground(navy);
        go3.setOpaque(true);
        go3.setBorderPainted(false);
        go3.addActionListener(this);
        go3.setActionCommand("go3");
        leftButton.setActionCommand("left");
        leftButton.addActionListener(this);
    }

    //actionPerformed
    @Override
    public void actionPerformed(ActionEvent e)
    {

        String buttonCommand = e.getActionCommand();
        if (buttonCommand.equals("go1"))
        {
            this.dispose();
            Registration reader = new Registration();
        } else if (buttonCommand.equals("go2"))
        {
            this.dispose();
            StatementCompany reader = new StatementCompany();
        } else if (buttonCommand.equals("go3"))
        {
            this.dispose();
            PlanCompany reader = new PlanCompany();
        } else if (buttonCommand.equals("left"))
        {
            this.dispose();
            Welcome reader = new Welcome();
        }
    }
}