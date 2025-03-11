package c18;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class c05GUI extends JFrame{
	
	c05GUI(String title){
		//Frame
		super(title);
		setBounds(200,200,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Component
		JButton btn1 = new JButton("파일로 저장");
		btn1.setBounds(247,20,120,30);
		
		JButton btn2 = new JButton("1:1 요청");
		btn2.setBounds(247,60,120,30);
		
		JButton btn3 = new JButton("대화기록보기");
		btn3.setBounds(247,100,120,30);
	
		JButton input = new JButton("입력");
		input.setBounds(247,300,120,30);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(20, 300, 210, 30);
		
		JTextArea area1 = new JTextArea();
//		area1.setBounds(20, 10, 210, 280);
		
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(20, 10, 210, 280);
		
		//Panel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(input);
		
		panel.add(txt1);
//		panel.add(area1);
		
		panel.add(scroll1);
		
		//Frame(Panel)
		add(panel);
		
		//Frame
		setVisible(true);
//		
	}
	
}

public class c05Ex {
	
	public static void main(String[] args) {
		
		new c05GUI("Chatting Server");

	}

}
