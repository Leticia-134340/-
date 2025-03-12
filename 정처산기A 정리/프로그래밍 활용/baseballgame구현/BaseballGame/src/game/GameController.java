package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class GameController implements ActionListener {
	final int MAX_SIZE = 3;
	
	int count = 1;
	int answerArr[];
	GameView gameView;
	
	long beforeTime;
	
	public GameController() {
		Tandom random = new Random();
		
		List<Integer> list = new ArrayList<Interger>();
		answerArr = new int[MAX_SIZE];
		
		int index = 0;
		
		while(list.size() <MAX_SIZE) {
			int ranNum = random.nextInt(8) + 1;
			if(!list.contains(ranNum)) {
				list.add(ranNum);
				answerArr[index++] = ranNum;
				System.out.print(answerArr[index-1] + " ");
			}
		}
		beforeTime = System.currentTimeMillis();
		
		gameView = new GameView();
		gameView.btnSubmit.addActionListener(this);
		gameView.btnExit.addActionListener(this);
	}
	
	@override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gameView.btnSubmit) {
			try {
				int[] inputArr = new int[3];
				inputArr[0] = Integer.parseInt(gameView.tfNum1.getText());
				inputArr[1] = Integer.parseInt(gameView.tfNum1.getText());
				inputArr[2] = Integer.parseInt(gameView.tfNum1.getText());
				
				GameModel game = new GameModel(answerArr, inputArr);
				int[] resultArr = game.getResult();
				
				String result = count + "회 시도 ..."
								+inputArr[0] + " " + inputArr[1] + " "
								+inputArr[2] + " : "
								+resultArr[0] + "S" + resultArr[1] + "B"
								+resultArr[2] +"0\n";
				if(resultArr[0] == 3) {
					result += "축하합니다! 게임에 이겼습니다.";
					
					long time = timeCheck();
					String name = JOptionPane.showInputDialog(null, "게임에 이겼습니다. 이름을 입력하세요.", "축하합니다.", JOptionPane.OK_CANCEL_OPTION);
					System.out.println(name +"님, " + time + "초");
					
					game.saveRank(name, (int) time);
					gameView.stop();
				} else if(count++ == 10) {
					
				}
			}
		}
	}
}
