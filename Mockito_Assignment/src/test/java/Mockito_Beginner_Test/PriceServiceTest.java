package Mockito_Beginner_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import MockitoBeginnerPracticeQuestion.DiscountRepository;
import MockitoBeginnerPracticeQuestion.PriceService;

public class PriceServiceTest {
	
	@Test
	public void calculatepricetest() {
		//Create mock object
		DiscountRepository d = mock(DiscountRepository.class);
		
		//Now we will tell mock what to return
		when(d.getDiscountPercentage("MOB")).thenReturn(10.0);
		when(d.getDiscountPercentage("LAP")).thenReturn(20.0);
		
		//Insert mock into service
		PriceService ps = new PriceService(d);
		
		double res = ps.calcluatePrice("LAP", 2000);
		
		assertEquals(1600.0,res);
	}
}
