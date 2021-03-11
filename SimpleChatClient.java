package day0311;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
 * 일 대 일 채팅클라이언트
 * @author user
 */
@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener , Runnable{
	private JTextField jtfTalk;
	private JTextArea jtaTalkDisplay;
	private JButton jbtnConnectServer;
	
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private JScrollPane jspTalkDisplay;
	public SimpleChatClient() {
		super("::::::::::::::::::::::::채팅클라이언트::::::::::::::::::::::::::::::::::::::::::::");
		jtfTalk=new JTextField();
		jbtnConnectServer=new JButton("서버접속");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk.setBackground(Color.WHITE);
		
		jspTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jspTalkDisplay.setBorder(new TitledBorder("대화내용"));
		
		JPanel jpanel=new JPanel();
		jpanel.add(jbtnConnectServer);
		jtfTalk.setBorder(new TitledBorder("대화입력"));
		
		
		add("North",jpanel);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		jtfTalk.addActionListener(this);
		jbtnConnectServer.addActionListener(this);
		
		setBounds(100,100,400,500);
		setVisible(true);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			try {
				closeClient();
			} catch (IOException e1) {
				e1.printStackTrace();
			}//end catch
			dispose();
			}//windowClosing
			
		});
		
		jtfTalk.requestFocus();
	}//SimpleChatServer
	
	/**
	 * 	소켓을 생성하여 서버소켓에 연결 시도<br>
	 * 	데이터를 주고 받기 위해 스트림을 연결한다
	 * @throws IOException
	 */
	public void connectToServer() throws IOException {
		if( client == null ) {
		String ipAddr = JOptionPane.showInputDialog("접속서버의 주소 입력","211.63.89.");
		
		client = new Socket(ipAddr, 10000); //서버로 연결시도
		//데이터를 주고받기 위해 스트림을 연결 
		readStream = new DataInputStream(client.getInputStream()); //데이터를 읽을 준비가 된 상태
		writeStream = new DataOutputStream(client.getOutputStream()); //데이터를 쓸 준비가 된 상태
		
		//메세지를 동시에 읽어들인다
		Thread thread = new Thread(this);
		thread.start();
		
		} //end if
		
	}//connectToServer
	
	/**
	 * 	대화 상대가 보내오는 메세지 읽기
	 */
	@Override
	public void run() {
		String msg ="";
		try {
			while( true ) {
				msg = readStream.readUTF();
				jtaTalkDisplay.append(msg+"\n");//대화보기 창에 메세지를 출력
				jspTalkDisplay.getVerticalScrollBar().setValue( jspTalkDisplay.getVerticalScrollBar().getMaximum() );
			}//end while
		}catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//readMsg
	
	/**
	 * 	입력된 메세지를 서버로 전송하는 일
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		//대화내용을 입력하는 JTextField에서 입력된 값을
		String sendMsg = "[ 신류진최고야 ] "+jtfTalk.getText();
		//대화내용창에 대화쓰기
		jtaTalkDisplay.append(sendMsg+"\n");
		jspTalkDisplay.getVerticalScrollBar().setValue( jspTalkDisplay.getVerticalScrollBar().getMaximum() );
		//스트림에 기록
		writeStream.writeUTF(sendMsg);
		//스트림의 내용을 목적지로 분출
		writeStream.flush();
	}//sendMsg
	
	public void closeClient()throws IOException{
		if( readStream != null ) {readStream.close();}
		if( writeStream != null ) {writeStream.close();}
		if( client != null ) {client.close();}
	}//closeClient
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if( ae.getSource() == jbtnConnectServer ) {
			try {
				connectToServer();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		
		if( ae.getSource() == jtfTalk ) {
			try {
				sendMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		
	}//actionPerformed

	public static void main(String[] args) {
		new SimpleChatClient();
	}//main


}//class
