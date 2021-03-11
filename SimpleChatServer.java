package day0311;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * �� �� �� ä�ü��� : Thread ���� ��  : �޼����� ���� ������ �о���̴� �ڵ带 Thread�� ó��
 * 	�б�� ���Ⱑ ���ÿ� ����ȴ�
 * @author user
 */
@SuppressWarnings("serial")

//1. Runnable ����
public class SimpleChatServer extends JFrame implements ActionListener, Runnable {
	private JTextField jtfTalk;
	private JTextArea jtaTalkDisplay;
	private JButton jbtnOpenServer;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	JScrollPane jspTalkDisplay;
	
	public SimpleChatServer() {
		super("::::::::::::::::::::::::ä�ü���::::::::::::::::::::::::::::::::::::::::::::");
		jtfTalk=new JTextField();
		jbtnOpenServer=new JButton("��������");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk.setBackground(Color.WHITE);
		
		jspTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jspTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		
		JPanel jpanel=new JPanel();
		jpanel.add(jbtnOpenServer);
		jtfTalk.setBorder(new TitledBorder("��ȭ�Է�"));
		
		add("North",jpanel);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		jtfTalk.addActionListener(this);
		jbtnOpenServer.addActionListener(this);
		
		setBounds(100,100,400,500);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				try {
					closeServer();
				} catch (IOException e) {
					e.printStackTrace();
				}//end catch
				dispose();
			}//windowClosing
		});
		
		jtfTalk.requestFocus();
	}//SimpleChatServer
	
	public void openServer() throws IOException {
		//�������� ����
		if( server == null ) {
		server = new ServerSocket( 10000 );
		jtaTalkDisplay.setText("���� ���� ��......\n");
		//������ ���� �ޱ�
		client = server.accept();
		jtaTalkDisplay.append("������ ���� \n");
		//�޼����� �ְ�ޱ����� ��Ʈ�� ����
		readStream = new DataInputStream(client.getInputStream()); //�޼����� ���� �� �ִ� ����
		writeStream = new DataOutputStream(client.getOutputStream()); //�޼����� ���� �� �ִ� ����
		
		//Ŭ���̾�Ʈ�� �������� �޼����� �д´� ( run() )
		// start() ȣ��
//		SimpleChatServer scs = new SimpleChatServer();
		Thread thread = new Thread(this);
		thread.start();
		
	}//openServer
	}//end if
	/**
	 * �޼����� ������ �� ���� �б�
	 * @throws IOException
	 */
	public void run(){
		
		String msg = "";
				try {
					while(true) {
					msg = readStream.readUTF();
					jtaTalkDisplay.append(msg + "\n");
					jspTalkDisplay.getVerticalScrollBar().setValue( jspTalkDisplay.getVerticalScrollBar().getMaximum() );
				}//end while
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "�����ڰ� ��¼��");
				e.printStackTrace();
			}

		
	}//readMsg
	
	public void sendMsg() throws IOException{
		if(writeStream != null ) {
			String msg = "[�ŷ���]" + jtfTalk.getText();
			//��ȭâ�� �޼����� �ø���
			jtaTalkDisplay.append(msg+"\n");
			jspTalkDisplay.getVerticalScrollBar().setValue( jspTalkDisplay.getVerticalScrollBar().getMaximum() );
			//�����ڿ��� ������
			writeStream.writeUTF(msg);
		}//end if
	}//sendMsg
	
	public void closeServer()throws IOException{
		if( readStream != null ) { readStream.close(); }
		if( writeStream != null ) { writeStream.close(); }
		if( client != null ) { client.close(); }
		if( server != null ) { server.close(); }
	}//closeServer
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if( ae.getSource() == jbtnOpenServer ) {
			try {
				openServer();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		
		if( ae.getSource() == jtfTalk ) {
			try {
				sendMsg();
				jtfTalk.setText("");
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if

	}//actionPerformed

	public static void main(String[] args) {
		new SimpleChatServer();
	}//main

}//class
