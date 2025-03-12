//package app;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainController implements ActionListener{
//	MainView mainView;
//	
//	public MainController() {
//		mainView = new MainView();
//		mainView.btnGame.addActionListener(this);
//		mainView.btnRank.addActionListener(this);
//	}
//
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == mainView.btnGame) {
//			new gameController();
//			mainView.setVisible(false);
//		}else if(e.getSource() == mainView.btnRank) {
//			new RankController();
//			mainView.setVisible(false);
//		}
//	}
//
//
//	public static void main(String[] args) {
//		new MainController();
//
//	}
//
//}
