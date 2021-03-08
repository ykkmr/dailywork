package day0308;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sun.awt.www.content.image.jpeg;

@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener {
	
	private JButton jbtn16bitStream, jbtn8bitStream;
	
	public FileCopy() {
		super("���Ϻ���");
		
		jbtn16bitStream = new JButton("16bit ���ϼ���");
		jbtn8bitStream = new JButton("8bit ���ϼ���");
		
		JPanel panel = new JPanel();
		panel.add(jbtn16bitStream);
		panel.add(jbtn8bitStream);
		
		add("Center", panel);
		
		jbtn16bitStream.addActionListener(this);
		jbtn8bitStream.addActionListener(this);
		
		setBounds(100, 100, 500, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//FileCopy
	
	public void use16bit(String originalName, String cpName) throws IOException {
		//�б� ��Ʈ�� ����
		BufferedReader br = null;
		//���� ��Ʈ�� ����
		BufferedWriter bw = null;
		
		try {
			//�б� ��Ʈ�� ����
			br = new BufferedReader(new FileReader(originalName));
			//���� ��Ʈ�� ����
			bw = new BufferedWriter(new FileWriter(cpName));
			
			String data ="";
			
			while( (data=br.readLine()) != null ) {//��Ʈ������ �б�
				//��Ʈ������ �о���� ������ ��Ʈ���� ����
				System.out.println(data);
				bw.write(data);
			}//end while
			//��Ʈ���� �ִ� ���� ������ �������� ����
			bw.flush();
		}finally {
			JOptionPane.showMessageDialog(this, cpName+"���Ϸ� ���� �Ǿ����ϴ�");
			//���� ����
			if( br != null ) {br.close();}//end if
			if( bw != null ) {bw.close();}//end if
		}
	}//use16bit
	
	public void use8bit(String originalName, String cpName) throws IOException {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			//�б⽺Ʈ�� ����
			fis = new FileInputStream(originalName);
			//���⽺Ʈ�� ����
			fos = new FileOutputStream(cpName);
			
			//////////////////////////////////////////////////DISK IO�� ���� �߻��ϴ� �ڵ� //////////////////////////////////////////////////////////
				byte[] readData = new byte[512];
				int leng = 0; //�迭�� ä���� ����.
				
				while( (leng = fis.read(readData)) != -1 ) {//���Ͽ��� �о���� ������ �ִٸ�
					fos.write(readData, 0, leng); //�迭�� ó���濡�� �о���� ����� ���
					
				}//end while
				
			//////////////////////////////////////////////////DISK IO�� ���� �߻��ϴ� �ڵ� //////////////////////////////////////////////////////////
				
			//////////////////////////////////////////////////DISK IO�� ���� �߻��ϴ� �ڵ� //////////////////////////////////////////////////////////
//			int readData = 0; //����� ���Ͽ��� �о���� byte�� ������ ����
//			
//			while( (readData = fis.read()) != -1 ) {//1byte�� �о�鿩
//				fos.write( readData ); //1byte�� ����
//				System.out.println( readData ); //���
//			}//end while
			//��Ʈ���� �����ϴ� ������ �������� ����
			
			//////////////////////////////////////////////////DISK IO�� ���� �߻��ϴ� �ڵ� //////////////////////////////////////////////////////////
			fos.flush();
			
			JOptionPane.showMessageDialog(this, cpName +"���Ϸ� ���� �Ǿ����ϴ�");

		}finally {
			//��Ʈ���� ���� ����
			if( fis != null ){fis.close();}//end if
			if( fos != null ){fos.close();}//end if
		}//end finally
		
	}//use8bit
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//FileDialog�� �б���� ����
		FileDialog fdOpen = new FileDialog(this, "������ ���� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String file = fdOpen.getFile();
		
		if( path != null ) {
			// ������ �������ϸ��� ����Ͽ� "���ϸ�_cp.Ȯ����" ������ �̸��� ������
			StringBuilder sbCpFileName = new StringBuilder( file ); //������ ���ϸ��� ������ S.B
			sbCpFileName.insert(sbCpFileName.lastIndexOf("."), "_cv");
			
			if(ae.getSource() == jbtn16bitStream) {
				try {
				use16bit(path + file, path + sbCpFileName.toString() );
				}catch(IOException e) {
					e.printStackTrace();
				}//end catch
			}//end if
			
			if(ae.getSource() == jbtn8bitStream) {
				try {
				use8bit(path + file , path + sbCpFileName.toString() );
				}catch(IOException e) {
					e.printStackTrace();
				}//end catch
			}//end if
			
		}//end if
		
		
	}//actionPerformed

	public static void main(String[] args) {

		new FileCopy();
		
	}//main

}//class
