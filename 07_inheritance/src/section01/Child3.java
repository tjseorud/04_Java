package section01;

public class Child3 extends Parent {
//	private String lastName ="김";
//	private String firstName ="가람";
//	private String address ="충북 청주시";
//	private int money =9000;
	private double bitCoin;
	public Child3() {
		System.out.println("*** Child3 생성됨 ***");
		setFirstName("가람");
		/*protected String firstName;
		 * ->상속받은 자식객체가 부모의 필드에 직접접근 가능
		 */
		firstName ="가람가람";	
		setAddress("충북 청주시");
//		address ="이건 안됨";
		setMoney(9000);
		setBitCoin(0.1);
	}
	
	public double getBitCoin() {
		return bitCoin;
	}
	public void setBitCoin(double bitCoin) {
		this.bitCoin = bitCoin;
	}
}