package general;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MailClient;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Popup1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel BG2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Popup1 frame = new Popup1();
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
	public Popup1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Images/popup1.png"));
		setTitle("Mail Sent Successfuly");
		setResizable(false);
		setBackground(new Color(14, 73, 78));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		BG2 = new JPanel();
		BG2.setBackground(new Color(14, 73, 78));
		BG2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BG2);
		BG2.setLayout(null);
		
		JLabel Tag8 = new JLabel("Mail Successfuly");
		Tag8.setForeground(new Color(255, 255, 255));
		Tag8.setFont(new Font("Arial", Font.BOLD, 40));
		Tag8.setBounds(59, 33, 322, 47);
		BG2.add(Tag8);
		
		JLabel Tag9 = new JLabel("Delivered");
		Tag9.setForeground(new Color(255, 255, 255));
		Tag9.setFont(new Font("Arial", Font.BOLD, 40));
		Tag9.setBounds(125, 88, 187, 47);
		BG2.add(Tag9);
		
		JButton BTHOME2 = new JButton("HOME");
		BTHOME2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MailClient mcs = new MailClient();
				mcs.setVisible(true);
			}
		});
		BTHOME2.setForeground(new Color(255, 0, 0));
		BTHOME2.setFont(new Font("Arial", Font.BOLD, 25));
		BTHOME2.setBackground(new Color(1, 48, 52));
		BTHOME2.setBounds(151, 174, 124, 35);
		BG2.add(BTHOME2);
	}
}
