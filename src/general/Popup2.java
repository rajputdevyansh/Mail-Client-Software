package general;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MailClient;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Popup2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel BG3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Popup2 frame = new Popup2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Popup2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\popup2.png"));
		setTitle("Unable To Send");
		setResizable(false);
		setBackground(new Color(14, 73, 78));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		BG3 = new JPanel();
		BG3.setBackground(new Color(14, 73, 78));
		BG3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BG3);
		BG3.setLayout(null);
		
		JLabel Tag10 = new JLabel("UNABLE TO SEND");
		Tag10.setForeground(new Color(255, 0, 0));
		Tag10.setFont(new Font("Arial", Font.BOLD, 40));
		Tag10.setBounds(37, 56, 364, 47);
		BG3.add(Tag10);
		
		JButton BTHOME3 = new JButton("HOME");
		BTHOME3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MailClient mcs = new MailClient();
				mcs.setVisible(true);
			}
		});
		BTHOME3.setForeground(new Color(255, 255, 255));
		BTHOME3.setFont(new Font("Arial", Font.BOLD, 25));
		BTHOME3.setBackground(new Color(1, 48, 52));
		BTHOME3.setBounds(153, 159, 124, 35);
		BG3.add(BTHOME3);
	}

}
