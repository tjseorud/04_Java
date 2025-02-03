package section01;

public class Child2 extends Parent {
//	private String lastName ="김";
//	private String firstName ="바다";
//	private String address ="경기도 용인시";
//	private int money =7000;
	private String car;
	public Child2() {
		System.out.println("*** Child2 생성됨 ***");
		//부모의 firstName 를 상속받았으나 private이라서 직접접근 불가능 ->간접접근방법
		setFirstName("바다");
		setAddress("경기도 용인시");
		setMoney(7000);
		car ="아반떼";
	}
	
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
}