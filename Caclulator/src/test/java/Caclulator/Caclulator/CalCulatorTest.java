package Caclulator.Caclulator;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Tested;

class CalCulatorTest {

	@Mocked
	CalCulator oCalculator;

	//@Test
	@DisplayName("Expectations operation ")
	void Addition() {
		new Expectations(oCalculator)
		{{
			oCalculator.performMath("add", anyInt, anyInt);
			result= new Delegate<CalCulator>() {
				 int performMath(String operation, int k, int m) {
				  int retrunValue=oCalculator.performMath("sub", 15, 10);
				  return retrunValue;
				 }};
		}};
		int retrunValue = oCalculator.performMath("add", 10, 10);
		assertTrue(retrunValue > 0);
		
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("Addition operation ") void staticBlock() { new
	 * MockUp<UserConstants>() {
	 * 
	 * @Mock public String operationType() { return "sub"; } }; String retrunValue =
	 * oCalculator.getuserOperation(); assertTrue(retrunValue.equals("sub")); }
	 */

	/*
	 * @Test
	 * 
	 * @DisplayName("Substraction operation ") void Substraction() { int retrunValue
	 * = oCalculator.performMath("sub", 4, 3); assertTrue(retrunValue > 0); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Multiply operation ") void MultiplyOp() { int retrunValue =
	 * oCalculator.performMath("mul", 4, 3); assertTrue(retrunValue > 0); }
	 * 
	 * 
	 * 
	 * @DisplayName("Divison operation ") void DivisonOperation() { int retrunValue=
	 * oCalculator.performMath("div", 4, 3); assertTrue(retrunValue > 0); }
	 */
}
