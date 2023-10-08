package network;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Serverswing extends JFrame {

	private JPanel contentPane;
	private JTextField txtAaa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serverswing frame = new Serverswing();
					frame.setVisible(true);
					 ServerSocket serverSocket = new ServerSocket(45312); // Choose a port
			            System.out.println("Server is waiting for a connection...");
			            Socket clientSocket = serverSocket.accept(); // Wait for a client to connect

			            // Read messages from the client
			            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			            String message;
			            String a="";
			            while ((message = in.readLine()) != null) {
			                System.out.println("Received: " + message);
			                
			                a=a+message+"\n";
			            }
			            frame.txtAaa.setText(a);

			            // Close the connections
			            in.close();
			            clientSocket.close();
			            serverSocket.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Serverswing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 4, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAaa = new JTextField();
		txtAaa.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAaa.setBackground(new Color(200, 225, 57));
		txtAaa.setBounds(271, 10, 320, 183);
		contentPane.add(txtAaa);
		txtAaa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\eclipse workspace\\Network\\src\\network\\serverimg.png"));
		lblNewLabel.setBounds(10, 10, 581, 196);
		contentPane.add(lblNewLabel);
		
	}

}
