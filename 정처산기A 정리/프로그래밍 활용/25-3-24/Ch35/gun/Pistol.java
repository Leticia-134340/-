package Ch35.gun;

import Ch35.Unit.Unit;

public class Pistol extends Gun {
	public Pistol(){
		this.power = 20;
		this.curBullitCnt=0;
		this.maxBullitCnt=10;
	}

	@Override
	public void fire(Unit unit) {
		if(curBullitCnt==0) {
			System.out.println("총알 : 0 재장전 필요...");
			return;
		}
		
	}

	@Override
	public void reload(int bullit) {
		if(this.maxBullitCnt>this.curBullitCnt+bullit)
			this.curBullitCnt+=bullit;
		else
			this.curBullitCnt=maxBullitCnt;
		
	}

}
