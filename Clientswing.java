package network;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
public class Clientswing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientswing frame = new Clientswing();
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
	public Clientswing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(204, 66, 118), 3, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(173, 16, 454, 69);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(23, 37, 105, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("client");
		        try {
		            Socket socket = new Socket("localhost", 45312); // Connect to the server on the specified port
		            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		            // Send messages to the server
		            String a=textField.getText();
		            
		            out.println(a);
		           out.println("How are you?");
		            Serverswing s=new Serverswing();
		            //s.setVisible(true);
		            dispose();

		            // Close the connection
		            out.close();
		            socket.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(317, 225, 162, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("G:\\eclipse workspace\\Network\\src\\network\\clientimg.png"));
		lblNewLabel_1.setBounds(-134, 10, 818, 296);
		contentPane.add(lblNewLabel_1);
	}
}
