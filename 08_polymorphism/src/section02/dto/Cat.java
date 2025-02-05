package section02.dto;

/*추상 클래스인 Animal 상속받기
 * ->부모인 Animal의 필드/메서드(정상/추상)을 물려받음
 *  ->상속받은 추상 메서드를 사용하려면 재정의(오버라이딩)하라고 강제됨
 */
public class Cat extends Animal {
	//The type Cat must implement the inherited abstract method Animal.move()
	private String fur;
	public Cat() {
		super();
	}
	public Cat(String type ,String fur) {
		super(type);
		this.fur = fur;
	}
	public String getFur() {
		return fur;
	}
	public void setFur(String fur) {
		this.fur = fur;
	}
	@Override
	public String toString() {
		return super.toString()+" / fur :" +fur;
	}
	@Override
	public void move() {
		System.out.println("Cat :4족보행, 사뿐 사뿐 움직임");
	}
	@Override
	public void eat() {
		System.out.println("Cat :깨작 깨작 먹는중");
	}
	@Override
	public void sleep() {
		System.out.println("Cat :식빵굽는중");
	}
}