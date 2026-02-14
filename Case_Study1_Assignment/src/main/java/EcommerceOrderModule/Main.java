package EcommerceOrderModule;

public class Main {
	public static void main(String[] args) {
		Main_Dao m = new Main_Dao();
		//m.saveuser();
		//m.findUser(1001);
		//m.deleteuser(1001);
		OrderDao o = new OrderDao();
		//o.saveOrder();
		//o.findOrder(109);
		//o.findOrdersByUser(1001l);
		
		PaymentDao p = new PaymentDao();
		//p.savepayment();
		p.findpayment(10001);
	}
}
