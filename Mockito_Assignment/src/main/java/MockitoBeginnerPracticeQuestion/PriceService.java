package MockitoBeginnerPracticeQuestion;

public class PriceService{
	DiscountRepository d;
	public PriceService(DiscountRepository d) {
		this.d=d;	
	}
	public double calcluatePrice(String productcode,double price) {
		double discount = d.getDiscountPercentage(productcode);
		double finalPrice = price-(price*(discount/100));
		return finalPrice;
	}
}
