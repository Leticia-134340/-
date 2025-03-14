package c19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class c08GUI extends JFrame implements ActionListener, KeyListener, MouseListener{
	
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	Writer out;
	
	c08GUI(String title){
		//Frame
		super(title);
		setBounds(300,200,400,450);	//창 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//창이 백그라운드에서 실행되지 않도록 코드 넣기
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);	//레이아웃 없애기(그래야 자유롭게 이동)
		
		//Component
		btn1 = new JButton("저장하기");
		btn1.setBounds(247,20,120,30);
		
		btn2 = new JButton("불러오기");
		btn2.setBounds(247,60,120,30);
		
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(247,100,120,30);
	
		input = new JButton("입력");
		input.setBounds(247,300,120,30);
		
		txt1 = new JTextField();
		txt1.setBounds(20, 300, 210, 30);
		
		area1 = new JTextArea();
//		area1.setBounds(20, 10, 210, 280);
		
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(20, 10, 210, 280);
		
		//event listener add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);
		
		//Panel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(input);
		panel.add(txt1);
		
//		panel.add(area1);	//area는 스크롤과 연결 돼 있기 때문에 스크롤의 크기가 area 크기가 되고 area는 따로 값을 지정할 필요없다
		
		panel.add(scroll1);
		
		//Frame(Panel)
		add(panel);
		
		//Frame
		setVisible(true);
//		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		System.out.println("클릭!");
		if(e.getSource()==btn1) {
			System.out.println("저장하기");
			String contents = area1.getText();
			
			//파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);
			
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : "+ selectedVal);
			
			if(selectedVal==JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : "+ selectedFile);
			
			//파일 확장자 추가
			String filePath = selectedFile.toString();
			if(!selectedFile.toString().endsWith(".txt")) {
				filePath = selectedFile.toString()+".txt";
			}
			System.out.println("filePath : " + filePath);
			
			try {
				out = new FileWriter(filePath);
				out.write(contents);
				out.flush();
			}catch(Exception el) {
				el.printStackTrace();
				
			}finally {
				try {out.close();} catch(IOException el) {el.printStackTrace();}
				}
			}
			
		}else if(e.getSource()==btn2) {
			
			System.out.println("불러오기");
			
			//파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일을 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);
			
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : "+ selectedVal);
			if(selectedVal==JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : "+ selectedFile);

			if(selectedVal==JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : "+ selectedFile);
			
				try {
					Reader fin = new FileReader(selectedFile.toString());
					StringBuffer buffer = new StringBuffer();
					while(true) {
						int data = fin.read();
						if(data==-1)
							break;
						buffer.append((char)data);
					}
					area1.setText("");
					area1.append(buffer.toString());
					fin.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
			}
			
		}else if(e.getSource()==btn3) {
			System.out.println("대화기록보기");
		}
			else if(e.getSource()==input) {
			System.out.println("입력");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed..." +e.getKeyChar());
//		System.out.println("keyPressed..." +e.getKeyCode());
		if(e.getSource()==txt1) {
			if(e.getKeyCode()==10) {
				String message = txt1.getText();
				System.out.println(message);
				area1.append(message+"\n");
				txt1.setText("");
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("keyRelesed...");
//		System.out.println("keyRelesed..." +e.getKeyChar());
//		System.out.println("keyRelesed..." +e.getKeyCode());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		try {
//			System.out.println("mouseClicked..."+e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("mouseClicked..offset : " + offset);
			int row = area1.getLineOfOffset(offset);
//			System.out.println("mouseClicked...row : "+ row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n", startOffset,endOffset);
			String str = area1.getText(startOffset, endOffset-startOffset);
			System.out.println(str);
			
			
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		if(e.getSource()==input) {
//			String message = txt1.getText();
//			System.out.println(message);
//			area1.append(message+"\n");
//			txt1.setText("");
//		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class c08SwingEventMain {
	
	public static void main(String[] args) {
		
		new c08GUI("Chatting Server");

	}

}
