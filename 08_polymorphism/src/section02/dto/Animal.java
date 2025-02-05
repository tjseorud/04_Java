package section02.dto;

/**추상 클래스
 * 1)추상 메서드(abstract method)를 포함한 클래스
 * 2)객체(instance)로 만들면 안되는 클래스
 * -abstract 예약어 작성
 * -추상 클래스는 보통 미완성(추상 메서드)을 가지고 있어 객체생성 불가능
 * -직접 객체생성은 불가능 하지만 자식클래스에서 상속받아 추상 메서드(미완성 부분)을 정의해서 완성시켜주면 자식객체는 생성가능
 * 	(오버라이딩 강제화, 동적바인딩)
 * 
 * -추상 클래스도 생성자는 필수로 존재해야만 한다 ->상속받은 자식 내부에 부모부분이 생성되어야하기 때문에
 * -부모부분에서 추상메서드는 어떻게 구현되나? ->오버라이딩된 자식의 메서드로 연결됨
 * 
 * -추상클래스는 왜 사용할까? ->클래스간의 공통된 기능을 공유하면서도 일부기능은 자식클래스에서 강제로 구현하기 위해서
 *  +상속, 다형성을 이용한 객체지향 프로그래밍의 유연성을 높이기 위해서
 */
public abstract class Animal {
	private String type;	//종
	public Animal() {
		super();
	}
	public Animal(String type) {
		super();
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "type :"+type;
	}
	/*추상 메서드
	 * -공통된 기능의 이름은 갖지만 정의할수 없는 메서드
	 * -메서드 정의부문 {}대신 ;작성
	 * -abstract 예약어 작성
	 */
	public abstract void move();
	public abstract void eat();
	public abstract void sleep();
}