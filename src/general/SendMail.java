package general;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MailClient;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SendMail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel BG1;
	private JTextField ENID1;
	private JTextField ENPASS1;
	private JTextField ENTO;
	private JTextField ENSUB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMail frame = new SendMail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void sending(String userid, String pass, String toid, String subj, String msgtxt)
	{
		Properties p = new Properties();
        p.put("mail.smtp.ssl.trust","smtp.gmail.com");
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");
        
        Session verify = Session.getInstance(p, new javax.mail.Authenticator()
        {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
                return new javax.mail.PasswordAuthentication(userid, pass);
            }
            
        });
        try
        {
            Message message = new MimeMessage(verify);
            
            message.setFrom(new InternetAddress("mailclientsoftware@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toid));
            message.setSubject(subj);
            message.setText(msgtxt);
            
            Transport.send(message);
            System.out.println("Mail Sent");
            Popup1 P1 = new Popup1();
            P1.setVisible(true);
        }
        catch(Exception e)
        {
        	System.out.println(e);
        	Popup2 P2= new Popup2();
        	P2.setVisible(true);
        }
	}
	public SendMail() {
		setBackground(new Color(14, 73, 78));
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Images/send.png"));
		setTitle("Send Mail");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		
		BG1 = new JPanel();
		BG1.setBackground(new Color(14, 73, 78));
		BG1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BG1);
		BG1.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 700, 35);
		BG1.add(panel1);
		
		JLabel Tag1 = new JLabel("Enter Details");
		Tag1.setForeground(new Color(1, 48, 52));
		Tag1.setFont(new Font("Candara", Font.BOLD, 32));
		panel1.add(Tag1);
		
		JLabel Tag2 = new JLabel("ID :- ");
		Tag2.setForeground(new Color(255, 255, 255));
		Tag2.setFont(new Font("Candara", Font.BOLD, 30));
		Tag2.setBounds(10, 45, 79, 35);
		BG1.add(Tag2);
		
		JLabel Tag3 = new JLabel("PASS :-");
		Tag3.setForeground(new Color(255, 255, 255));
		Tag3.setFont(new Font("Candara", Font.BOLD, 30));
		Tag3.setBounds(10, 80, 112, 35);
		BG1.add(Tag3);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 115, 700, 35);
		BG1.add(panel2);
		
		JLabel Tag4 = new JLabel("Enter Sending Details");
		Tag4.setForeground(new Color(1, 48, 52));
		Tag4.setFont(new Font("Candara", Font.BOLD, 32));
		panel2.add(Tag4);
		
		JLabel Tag5 = new JLabel("TO :-");
		Tag5.setForeground(new Color(255, 255, 255));
		Tag5.setFont(new Font("Candara", Font.BOLD, 30));
		Tag5.setBounds(10, 160, 112, 35);
		BG1.add(Tag5);
		
		JLabel Tag6 = new JLabel("SUBJECT :-");
		Tag6.setForeground(new Color(255, 255, 255));
		Tag6.setFont(new Font("Candara", Font.BOLD, 30));
		Tag6.setBounds(10, 195, 152, 35);
		BG1.add(Tag6);
		
		JLabel Tag7 = new JLabel("MESSAGE :-");
		Tag7.setForeground(new Color(255, 255, 255));
		Tag7.setFont(new Font("Candara", Font.BOLD, 30));
		Tag7.setBounds(10, 230, 152, 35);
		BG1.add(Tag7);
		
		ENID1 = new JTextField();
		ENID1.setForeground(new Color(223, 11, 11));
		ENID1.setFont(new Font("Verdana", Font.BOLD, 16));
		ENID1.setBackground(new Color(104, 151, 155));
		ENID1.setBounds(69, 44, 555, 27);
		BG1.add(ENID1);
		ENID1.setColumns(10);
		
		ENPASS1 = new JTextField();
		ENPASS1.setForeground(new Color(223, 11, 11));
		ENPASS1.setFont(new Font("Verdana", Font.BOLD, 16));
		ENPASS1.setBackground(new Color(104, 151, 155));
		ENPASS1.setColumns(10);
		ENPASS1.setBounds(103, 80, 521, 27);
		BG1.add(ENPASS1);
		
		ENTO = new JTextField();
		ENTO.setForeground(new Color(223, 11, 11));
		ENTO.setFont(new Font("Verdana", Font.BOLD, 16));
		ENTO.setBackground(new Color(104, 151, 155));
		ENTO.setColumns(10);
		ENTO.setBounds(80, 160, 544, 27);
		BG1.add(ENTO);
		
		ENSUB = new JTextField();
		ENSUB.setForeground(new Color(223, 11, 11));
		ENSUB.setFont(new Font("Verdana", Font.BOLD, 16));
		ENSUB.setBackground(new Color(104, 151, 155));
		ENSUB.setColumns(10);
		ENSUB.setBounds(151, 195, 473, 27);
		BG1.add(ENSUB);
		
		JButton RESET1 = new JButton("X");
		RESET1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ENID1.setText(null);
				ENPASS1.setText(null);
			}
		});
		RESET1.setForeground(new Color(255, 255, 255));
		RESET1.setFont(new Font("Tahoma", Font.BOLD, 23));
		RESET1.setBackground(new Color(255, 0, 0));
		RESET1.setBounds(630, 56, 50, 40);
		BG1.add(RESET1);
		
		JButton RESET2 = new JButton("X");
		RESET2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ENTO.setText(null);
				ENSUB.setText(null);
			}
		});
		RESET2.setForeground(new Color(255, 255, 255));
		RESET2.setFont(new Font("Tahoma", Font.BOLD, 23));
		RESET2.setBackground(new Color(255, 0, 0));
		RESET2.setBounds(630, 167, 50, 40);
		BG1.add(RESET2);
		
		JTextArea ENMSG = new JTextArea();
		ENMSG.setForeground(new Color(223, 11, 11));
		ENMSG.setFont(new Font("Verdana", Font.BOLD, 15));
		ENMSG.setBackground(new Color(104, 151, 155));
		ENMSG.setBounds(20, 260, 656, 241);
		BG1.add(ENMSG);
		
		JScrollPane scroll1 = new JScrollPane(ENMSG);
		scroll1.setBounds(20, 260, 656, 241);
		BG1.add(scroll1);
		
		JButton BTHOME1 = new JButton("HOME");
		BTHOME1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MailClient mcs = new MailClient();
				mcs.setVisible(true);
			}
		});
		BTHOME1.setForeground(new Color(255, 255, 255));
		BTHOME1.setFont(new Font("Arial", Font.BOLD, 25));
		BTHOME1.setBackground(new Color(1, 48, 52));
		BTHOME1.setBounds(10, 516, 124, 35);
		BG1.add(BTHOME1);
		
		JButton BTSEND = new JButton("SEND");
		BTSEND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sending(
						ENID1.getText(),
						ENPASS1.getText(), 
						ENTO.getText(), 
						ENSUB.getText(), 
						ENMSG.getText()
						);
			}
		});
		BTSEND.setForeground(Color.WHITE);
		BTSEND.setFont(new Font("Arial", Font.BOLD, 25));
		BTSEND.setBackground(new Color(1, 48, 52));
		BTSEND.setBounds(556, 516, 124, 35);
		BG1.add(BTSEND);
		
		JButton RESET3 = new JButton("RESET");
		RESET3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ENMSG.setText(null);
			}
		});
		RESET3.setForeground(Color.WHITE);
		RESET3.setFont(new Font("Arial", Font.BOLD, 25));
		RESET3.setBackground(new Color(255, 0, 0));
		RESET3.setBounds(422, 516, 124, 35);
		BG1.add(RESET3);
	}
}
