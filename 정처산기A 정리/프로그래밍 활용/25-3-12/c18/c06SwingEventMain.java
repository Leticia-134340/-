package c18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class c06GUI extends JFrame implements ActionListener{
	
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	
	c06GUI(String title){
		//Frame
		super(title);
		setBounds(300,200,400,450);	//창 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//창이 백그라운드에서 실행되지 않도록 코드 넣기
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);	//레이아웃 없애기(그래야 자유롭게 이동)
		
		//Component
		btn1 = new JButton("파일로 저장");
		btn1.setBounds(247,20,120,30);
		
		btn2 = new JButton("1:1 요청");
		btn2.setBounds(247,60,120,30);
		
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(247,100,120,30);
	
		input = new JButton("입력");
		input.setBounds(247,300,120,30);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(20, 300, 210, 30);
		
		JTextArea area1 = new JTextArea();
//		area1.setBounds(20, 10, 210, 280);
		
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(20, 10, 210, 280);
		
		//event listener add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);
		
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
			System.out.println("파일로 저장 클릭");
		}else if(e.getSource()==btn2) {
			System.out.println("1:1 요청 클릭");
		}else if(e.getSource()==btn3) {
			System.out.println("대화기록보기 클릭");
		}else if(e.getSource()==input) {
			System.out.println("입력 클릭");
		}
		
	}
	
}

public class c06SwingEventMain {
	
	public static void main(String[] args) {
		
		new c06GUI("Chatting Server");

	}

}
