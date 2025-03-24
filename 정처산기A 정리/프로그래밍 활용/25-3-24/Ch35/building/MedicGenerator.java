package Ch35.building;

import Ch35.Unit.Medic;
import Ch35.Unit.Unit;

public class MedicGenerator implements UnitGenerator {

	@Override
	public Unit gen() {
		// TODO Auto-generated method stub
		return new Medic();
	}

}
