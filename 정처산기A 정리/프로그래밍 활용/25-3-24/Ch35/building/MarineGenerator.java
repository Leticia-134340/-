package Ch35.building;

import Ch35.Unit.Marine;
import Ch35.Unit.Unit;

public class MarineGenerator implements UnitGenerator {

	@Override
	public Unit gen() {
		// TODO Auto-generated method stub
		return new Marine();
	}

}
