package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GV extends JFrame implements ActionListener, KeyListener {
	
	JTextField tNum1;
	JTextField tNum2;
	JTextField tNum3;
	JTextArea area1;
	
	GV(String window2){
		
		//Frame
		super(window2);
		setBounds(300,200,400,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		JLabel laNotice = new JLabel("숫자 3개를 입력하세요");
		laNotice.setBounds(130,20,130,20);
		
		tNum1 = new JTextField();
		tNum1.setBounds(90,50,60,60);
		
		tNum2 = new JTextField();
		tNum2.setBounds(160,50,60,60);
		
		tNum3 = new JTextField();
		tNum3.setBounds(230,50,60,60);
		
		JButton btnSubmit = new JButton("제출");
		btnSubmit.setBounds(90, 120, 200, 30);

		area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(90, 160, 200, 200);
		
		tNum1.addKeyListener(this);
		tNum2.addKeyListener(this);
		tNum3.addKeyListener(this);
		
		
		panel.add(laNotice);
		panel.add(tNum1);
		panel.add(tNum2);
		panel.add(tNum3);
		panel.add(btnSubmit);
		panel.add(scroll1);
		
		add(panel);
		
		//Frame
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keypress"+e.getKeyCode());
//		System.out.println("keyPressed..." +e.getKeyChar());
		if(e.getSource()==tNum1 && e.getSource()==tNum2 && e.getSource()==tNum3) {
			if(e.getKeyCode()==10) {
				String message1 = tNum1.getText();
				String message2 = tNum2.getText();
				String message3 = tNum3.getText();
				System.out.printf(message1, message2, message3);
				area1.append(message1+" "+ message2 +" "+ message3 +"\n");
				tNum1.setText("");
				tNum2.setText("");
				tNum3.setText("");
			}
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
public class GameView {
	
	public static void main(String[] args) {
		
		new GV("Game");
	}
}


