//package financialplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorFrame extends JFrame implements ActionListener
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
    private final Color GREEN = new Color(GREEN_R,GREEN_G,GREEN_B);
    private final Color GREY = new Color(GREY_R,GREY_G,GREY_B);
    private final Font ARIAL = new Font("Arial", Font.PLAIN, FONT_A);
    private final java.net.URL ERROR_PATH = getClass().getResource("error.png");
  
    //JLabel
    private JLabel gWarning;
    private JLabel symbol;
    
    //JButton
    private JButton ok;

    //Constructor
    public ErrorFrame(String pWarning)
    {
        //JFrame
        super();
        gWarning = new JLabel(pWarning);
        this.setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLayout(new BorderLayout());
	this.getContentPane().setBackground(GREEN);
		
	//JLabel
	gWarning.setFont(ARIAL);
        gWarning.setHorizontalAlignment(JLabel.CENTER);
        symbol = new JLabel(new ImageIcon(ERROR_PATH));
		
	//JButton
        ok = new JButton("OK");
	ok.addActionListener((ActionListener) this);
	ok.setBackground(GREY);
	ok.setOpaque(true);
	ok.setBorderPainted(false);
        
	this.add(symbol, BorderLayout.NORTH);
	this.add(gWarning, BorderLayout.CENTER);
	this.add(ok, BorderLayout.SOUTH);
	this.setVisible(true);
	}
	
	//actionPerformed
	public void actionPerformed(ActionEvent e)
	{
            String buttonCommand = e.getActionCommand();
            if(buttonCommand.equals("OK"))
                this.dispose();
            else
                System.out.println("Unexpected error");
	}
}