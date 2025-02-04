package section01.dto;

/**Child class
 * (extends Parent)
 */
public class Child extends Parent {
	private String car;
	
	public Child() {
		super();
	}

	public Child(String lastName, int money, String car) {
		super(lastName,money);
		this.car = car;
	}

	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return super.toString()+" / Child [car=" + car + "]";
	}
	
}
