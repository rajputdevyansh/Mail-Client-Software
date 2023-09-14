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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FetchMail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel BG4;
	private JTextField ENID2;
	private JTextField ENPASS2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FetchMail frame = new FetchMail();
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
	public FetchMail() {
		setBackground(new Color(14, 73, 78));
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Images/read.png"));
		setTitle("Fetch Mail");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		
		BG4 = new JPanel();
		BG4.setBackground(new Color(14, 73, 78));
		BG4.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BG4);
		BG4.setLayout(null);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 0, 700, 35);
		BG4.add(panel3);
		
		JLabel Tag11 = new JLabel("Enter Details");
		Tag11.setForeground(new Color(1, 48, 52));
		Tag11.setFont(new Font("Candara", Font.BOLD, 32));
		panel3.add(Tag11);
		
		JLabel Tag12 = new JLabel("ID :- ");
		Tag12.setForeground(new Color(255, 255, 255));
		Tag12.setFont(new Font("Candara", Font.BOLD, 30));
		Tag12.setBounds(10, 45, 79, 35);
		BG4.add(Tag12);
		
		JLabel Tag13 = new JLabel("PASS :-");
		Tag13.setForeground(new Color(255, 255, 255));
		Tag13.setFont(new Font("Candara", Font.BOLD, 30));
		Tag13.setBounds(10, 80, 112, 35);
		BG4.add(Tag13);
		
		JPanel panel4 = new JPanel();
		panel4.setBounds(0, 115, 700, 35);
		BG4.add(panel4);
		
		JLabel Tag14 = new JLabel("Mails");
		Tag14.setForeground(new Color(1, 48, 52));
		Tag14.setFont(new Font("Candara", Font.BOLD, 32));
		panel4.add(Tag14);
		
		ENID2 = new JTextField();
		ENID2.setForeground(new Color(223, 11, 11));
		ENID2.setFont(new Font("Verdana", Font.BOLD, 16));
		ENID2.setColumns(10);
		ENID2.setBackground(new Color(104, 151, 155));
		ENID2.setBounds(69, 44, 555, 27);
		BG4.add(ENID2);
		
		ENPASS2 = new JTextField();
		ENPASS2.setForeground(new Color(223, 11, 11));
		ENPASS2.setFont(new Font("Verdana", Font.BOLD, 16));
		ENPASS2.setColumns(10);
		ENPASS2.setBackground(new Color(104, 151, 155));
		ENPASS2.setBounds(103, 80, 521, 27);
		BG4.add(ENPASS2);
		
		JTextArea MAILS = new JTextArea();
		MAILS.setEditable(false);
		MAILS.setLineWrap(true);
		MAILS.setForeground(new Color(255, 255, 255));
		MAILS.setFont(new Font("Verdana", Font.BOLD, 16));
		MAILS.setBackground(new Color(104, 151, 155));
		MAILS.setBounds(10, 160, 666, 345);
		BG4.add(MAILS);
		
		JButton BTHOME4 = new JButton("HOME");
		BTHOME4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MailClient mcs = new MailClient();
				mcs.setVisible(true);
			}
		});
		BTHOME4.setForeground(Color.WHITE);
		BTHOME4.setFont(new Font("Arial", Font.BOLD, 25));
		BTHOME4.setBackground(new Color(1, 48, 52));
		BTHOME4.setBounds(20, 515, 124, 35);
		BG4.add(BTHOME4);
		
		JButton BTFETCH = new JButton("FETCH");
		BTFETCH.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String host= "pop.gmail.com";
				@SuppressWarnings("unused")
				String storeType= "POP3";
				String user= ENID2.getText();
				String password=ENPASS2.getText(); 
				try{

				      Properties properties = new Properties();

				      properties.put("mail.pop3.host", host);
				      properties.put("mail.pop3.port", "995");
				      properties.put("mail.pop3.starttls.enable", "true");
				      Session emailSession = Session.getDefaultInstance(properties);
				  
				      Store store = emailSession.getStore("pop3s");

				      store.connect(host, user, password);

				      Folder emailFolder = store.getFolder("INBOX");
				      emailFolder.open(Folder.READ_ONLY);

				      Message[] messages = emailFolder.getMessages();
				      String mmm="Total Messages---" + messages.length;
				      System.out.println(mmm);
				      MAILS.append(mmm);
				      				  
				      for (int i = 0, n = 10; i < n; i++) 
				      {
				         
				    	  Message message = messages[i];
				         String m="\n---------------------------------\n";
				         String b="\nEmail Number " + (i + 1);
				         String bb="\nFrom: " + message.getFrom()[0];
				         String mm="\nSubject: " + message.getSubject();
				         String mb="\nText: " + message.getContent().toString();
				         System.out.println(m);
				         MAILS.append(m);
				         System.out.println(b);
				         MAILS.append(b);
				         System.out.println(bb);
				         MAILS.append(bb);
				         System.out.println(mm);
				         MAILS.append(mm);
				         System.out.println(mb);
				         MAILS.append(mb);
				        

				      }

				      emailFolder.close(false);
				      store.close();

				      } 
				catch (NoSuchProviderException l) {
				         l.printStackTrace();
				      } catch (MessagingException l) {
				         l.printStackTrace();
				      } catch (Exception l) {
				         l.printStackTrace();
				      };
				
			}
		});
		BTFETCH.setForeground(Color.WHITE);
		BTFETCH.setFont(new Font("Arial", Font.BOLD, 25));
		BTFETCH.setBackground(new Color(1, 48, 52));
		BTFETCH.setBounds(542, 515, 124, 35);
		BG4.add(BTFETCH);
		
		JButton RESET4 = new JButton("X");
		RESET4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ENID2.setText(null);
				ENPASS2.setText(null);
			}
		});
		RESET4.setForeground(Color.WHITE);
		RESET4.setFont(new Font("Tahoma", Font.BOLD, 23));
		RESET4.setBackground(Color.RED);
		RESET4.setBounds(630, 56, 50, 40);
		BG4.add(RESET4);
		
		JScrollPane scrollPane = new JScrollPane(MAILS);
		scrollPane.setBounds(10, 160, 666, 345);
		BG4.add(scrollPane);
		
		
	}
}
