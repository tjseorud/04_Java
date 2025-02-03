package section01;

/**부모역할 class
 * 
 */
public class Parent {
	private String lastName ="김";	/*private :현재 클래스/객체만 접근가능*/
	protected String firstName ="철수";		/*protected :같은 패키지 내 + 상속관계 직접접근가능*/
	private String address ="서울시 중구 남대문로 120";
	private int money =10000;
	public String introduce() {
		return "저는 Parent";
	}
	public String toString() {
		return String.format("성 :%s / 이름 :%s / 주소 : %s / 돈 :%d", lastName,firstName,address,money);
	}
	
	public Parent() {	//기본생성자
		System.out.println("*** Parent 생성됨 ***");
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}