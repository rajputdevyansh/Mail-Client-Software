package application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.FetchMail;
import general.SendMail;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MailClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel BG5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailClient frame = new MailClient();
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
	public MailClient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Images/MCS.png"));
		setTitle("Mail Client Software");
		setResizable(false);
		setBackground(new Color(14, 73, 78));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		
		BG5 = new JPanel();
		BG5.setBackground(new Color(14, 73, 78));
		BG5.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BG5);
		BG5.setLayout(null);
		
		JLabel Tag15 = new JLabel("MAIL");
		Tag15.setForeground(new Color(223, 11, 11));
		Tag15.setFont(new Font("Univers Condensed", Font.BOLD, 70));
		Tag15.setBounds(69, 40, 181, 51);
		BG5.add(Tag15);
		
		JLabel Tag16 = new JLabel("CLIENT");
		Tag16.setForeground(new Color(223, 11, 11));
		Tag16.setFont(new Font("Univers Condensed", Font.BOLD, 70));
		Tag16.setBounds(398, 40, 261, 51);
		BG5.add(Tag16);
		
		JLabel Tag17 = new JLabel("");
		Tag17.setIcon(new ImageIcon("./Images/MCS128.png"));
		Tag17.setBounds(260, 10, 128, 128);
		BG5.add(Tag17);
		
		JLabel Tag18 = new JLabel("SOFTWARE");
		Tag18.setForeground(new Color(255, 255, 255));
		Tag18.setFont(new Font("Univers Condensed", Font.BOLD, 70));
		Tag18.setBounds(147, 156, 402, 64);
		BG5.add(Tag18);
		
		JButton MBTSEND = new JButton("SEND");
		MBTSEND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SendMail SM = new SendMail();
				SM.setVisible(true);
			}
		});
		MBTSEND.setForeground(new Color(1, 48, 52));
		MBTSEND.setFont(new Font("Arial", Font.BOLD, 50));
		MBTSEND.setBackground(new Color(104, 151, 155));
		MBTSEND.setBounds(34, 282, 275, 200);
		BG5.add(MBTSEND);
		
		JButton MBTFETCH = new JButton("FETCH");
		MBTFETCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FetchMail FM = new FetchMail();
				FM.setVisible(true);
			}
		});
		MBTFETCH.setForeground(new Color(1, 48, 52));
		MBTFETCH.setFont(new Font("Arial", Font.BOLD, 50));
		MBTFETCH.setBackground(new Color(104, 151, 155));
		MBTFETCH.setBounds(384, 282, 275, 200);
		BG5.add(MBTFETCH);
		
		
	}

}
