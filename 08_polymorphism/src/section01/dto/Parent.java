package section01.dto;

/**부모 class
 * (extends Object)
 */
public class Parent extends Object {
	private String lastName ="제갈";
	private int money =10000;
	
	public Parent() {
		super();	//부모 생성자 호출(미작성시 컴파일러가 추가) ->Object()
	}

	public Parent(String lastName, int money) {
		super();
		this.lastName = lastName;
		this.money = money;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	/*Object.toString()
	 *[자동완성 방식1]
	 * Alt+Shift+S ->Override/implement Methods... 클릭
	 * 
	 *[자동완성 방식2]
	 * 오버라이딩 하려는 메서드 이름 작성후 Ctrl+Space 자동완성
	 * 
	 *[자동완성 방식3]
	 * Alt+Shift+S ->S toString()... 클릭
	 */
	@Override
	public String toString() {
		return "Parent [lastName=" + lastName + ", money=" + money + "]";
	}

}