package Caclulator.Caclulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mockit.Injectable;
import mockit.Mocked;

class SubclassTest {

	@Injectable
	Subclass sub;

	/*
	 * @Mocked Superclass sublass;
	 */

	//@Test
	void test() {
		sub=new Subclass("data");     
		assertEquals(sub.getData(), "data");

	}

}
