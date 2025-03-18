package c21;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class Memo{
	private int id;
	private String text;
	private LocalDateTime createdAt;
	Memo(){}
	public Memo(int id, String text, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Memo [id=" + id + ", text=" + text + ", createdAt=" + createdAt + "]";
	}
}

class SelectFrame extends JFrame implements MouseListener, ActionListener{
	
	c07GUI mainUi;
	JTable table;
	JScrollPane scroll;
	JPanel panel;
	JButton btn1;
	String selectedText;
	
	SelectFrame(c07GUI mainUi){
		super("SELECT 결과");
		this.mainUi = mainUi;
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//panel
		panel = new JPanel();
		panel.setLayout(null);
		
		//
		btn1 = new JButton("선택");
		btn1.setBounds(200,415,80,30);
		btn1.addActionListener(this);
		
		panel.add(btn1);
		
		//frame(panel)
		add(panel);
		
		//event
		
		
		setVisible(false);
	}
	void select(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		if(scroll!=null) {
			panel.remove(table);
			panel.remove(scroll);
		}
		//component
		String[] columns = {"ID","TEXT","CREATED_AT"};
		List<String[]>data = new ArrayList();
		
		
		try {
			//SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_memo");
			
		
			//SQL 실행
			List<Memo> list = new ArrayList();
			Memo memo;
			rs =  pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					memo = new Memo();
					memo.setId(rs.getInt("id"));
					memo.setText(rs.getString("text"));
					Timestamp timestamp = rs.getTimestamp("createdAt");
					memo.setCreatedAt(timestamp.toLocalDateTime());
					list.add(memo);
					
					data.add(new String[] {rs.getString("id"), rs.getString("text"),rs.getString("createdAt")});
					
				}
			}
			list.forEach(System.out::println);
			
			//------------------------------------------------
			String[][] arr = new String[data.size()][];
			//for 값복사
			for(int i=0;i<data.size();i++) {
				arr[i] = data.get(i);
			}
			
			table = new JTable(arr, columns);
			table.addMouseListener(this);
//			table.setBounds(40,10,400,400);
			
			scroll = new JScrollPane(table);
			scroll.setBounds(40,30,400,370);
			
			//panel(component)
//			panel.add(table);
			panel.add(scroll);
			
		}catch(Exception e3){
			e3.printStackTrace();
		}finally {
			try {rs.close();}catch(Exception e2) {}
			try {pstmt.close();}catch(Exception e2) {}
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {

		int selectedRow = table.getSelectedRow();
		String selectedText = table.getValueAt(selectedRow, 1).toString();
		System.out.println("CLICKED"+selectedText);
		
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
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btn1) {
			//mainUI에 selectedText 전달
			mainUi.area1.setText(selectedText);
			//현재 프레임은 종료
		}
		
	}
}

class c07GUI extends JFrame implements ActionListener, KeyListener, MouseListener{
	
	JButton btn1;
	JButton btn2;
	JButton btn3;	//INSERT
	JButton btn4;	//UPDATE
	JButton btn5;	//DELETE
	JButton btn6;	//SELECTONE
	
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	Writer out;
	
	//DB CONN DATA
	static String id = "root";
	static String pw = "8575";
	static String url = "jdbc:mysql://localhost:3306/testdb";
	
	//JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	//SELECT FRAME
	SelectFrame selectFrame;
	
	c07GUI(String title) throws ClassNotFoundException, SQLException{
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
		
		btn3 = new JButton("INSERT");
		btn3.setBounds(247,100,120,30);
		
		btn4 = new JButton("UPDATE");
		btn4.setBounds(247,140,120,30);
		
		btn5 = new JButton("DELETE");
		btn5.setBounds(247,180,120,30);
		
		btn6 = new JButton("SELECT");
		btn6.setBounds(247,220,120,30);
	
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
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);
		
		//Panel(Component)
//		panel.add(area1);	//area는 스크롤과 연결 돼 있기 때문에 스크롤의 크기가 area 크기가 되고 area는 따로 값을 지정할 필요없다
		panel.add(scroll1);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(input);
		panel.add(txt1);
		
		//Frame(Panel)
		add(panel);
		
		//Frame
		setVisible(true);
		
		//DB 연결코드
		Class.forName("com.mysql.cj.jdbc.Driver");		//사용할 클래스 명시
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("DB CONNECTED...");
		
		//SELECT FRAME
		selectFrame = new SelectFrame(this);	//c07GUI를 가져옴 
		
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
			}catch(Exception e1) {
				e1.printStackTrace();
				
			}finally {
				try {out.close();} catch(IOException e1) {e1.printStackTrace();}
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
			
		}
		else if(e.getSource()==btn3) 
		{
			System.out.println("INSERT");
			
			try {
				
				pstmt = conn.prepareStatement("insert into tbl_memo values(null, ?, now())");
				pstmt.setString(1, area1.getText());
				int result=pstmt.executeUpdate();
				
				if(result>0) {
					
					System.out.println("[INFO] INSERT 성공");
					JOptionPane.showMessageDialog(null, "INSERT 성공","INSERT 확인창", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					System.out.println("[INFO] INSERT 실패");
					JOptionPane.showMessageDialog(null, "INSERT 실패","INSERT 확인창", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {pstmt.close();}catch(Exception e1) {e1.printStackTrace();}
			}
			
		}
		else if(e.getSource()==btn4) {
				
		}
		else if(e.getSource()==btn5) {
				
		}
		else if(e.getSource()==btn6) {
			
			selectFrame.setVisible(true);
			//전체 조회 가져와서 CONSOL에 출력
			selectFrame.select(conn, pstmt, rs);

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

public class c07SwingEventMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		new c07GUI("Chatting Server");

	}

}
