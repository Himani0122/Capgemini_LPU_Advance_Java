package implement_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import StepsToImplementmockito.Calculator;
import StepsToImplementmockito.MathService;

public class MathServiceTest {
	@Test
	public void testDoubleAddition() {
		//Step 1: createfakeobject
		Calculator c = mock(Calculator.class);
		//Step 2: what mock object should return(in calculator it should return int)
		when(c.add(5, 5)).thenReturn(10);
		//Step 3: give the fake object reference or inject the fake reference
		MathService service = new MathService(c);
		int res=service.doubleAddition(5, 5);
		
		assertEquals(10,res);
	}
}
