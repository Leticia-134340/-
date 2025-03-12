package app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MainView extends JFrame {

	MainView(String window) {
		
		//Frame
		super(window);
		setBounds(300,200,400,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		//Component
		JButton btnGame = new JButton("게임 시작");
		btnGame.setBounds(100,180,90,30);
		
		JButton btnRank = new JButton("랭킹 확인");
		btnRank.setBounds(200,180,90,30);
		
		//Panel(Component)
		panel.add(btnGame);
		panel.add(btnRank);
		
		//Frame(Panel)
		add(panel);
		
		
		//Frame
		setVisible(true);
		
	}
	
	public static void main(String[] args) {

		new MainView("BaseBall");
		
	}

}
