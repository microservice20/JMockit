package Caclulator.Caclulator;

public class CalCulator {
	
	public int performMath(String operation, int k, int m) {
		int returnValue = 0;
		if (operation.equals("add")) {
			returnValue = new Addition(k, m).performAddition();
		} else if (operation.equals("sub")) {
			returnValue = new Sustraction(k, m).performSubst();
		} else if (operation.equals("mul")) {
			returnValue = new Mutiply(k, m).performMutily();
		} else {
			returnValue = new Divide(k, m).performDivide();
		}

		return returnValue;
	}

}
