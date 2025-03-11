package c18;

import javax.swing.JFrame;

class c02GUI extends JFrame{
	
	c02GUI(String title){
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class C02SwingMain {

	public static void main(String[] args) {

		new c02GUI("두번째 프레임입니다");
		
	}

}
