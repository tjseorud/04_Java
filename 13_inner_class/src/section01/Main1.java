package section01;

public class Main1 {
	public static void main(String[] args) {
		OuterClass1 outer =new OuterClass1();	//외부 클래스의 인스턴스 생성		
		//외부 클래스 내에 존재하는 내부 클래스 인스턴스 생성
		OuterClass1.InstanceInnerClass inner =outer.new InstanceInnerClass();
		inner.display();
		outer.displayMessage(); //외부 클래스의 메서드 호출 ->내부 클래스 객체생성
	}
	/*[내부 클래스]
	 * 1.인스턴스 내부 클래스
	 *  -외부 클래스의 멤버처럼 활용되는 내부 클래스
	 *  -외부 인스턴스가 존재해야지만 내부 인스턴스 생성가능
	 *  
	 * 2.정적(static) 내부 클래스
	 *  -외부 인스턴스 생성없이 내부 인스턴스 생성가능 (new OutClassName.InClassName())
	 *  
	 * 3.지역 내부 클래스
	 * 	-외부 클래스의 멤버 메서드 내에 존재하는 내부 클래스
	 *  -외부 메서드의 내부에서만 생성, 사용가능
	 *  
	 * 4.인스턴스 내부 클래스
	 *  -이름이 없는 내부 클래스
	 *  -인터페이스, 추상클래스를 상속받은 구현체를 따로 만들지 않고
	 *   필요한 곳에서 클래스를 정의(추상클래스 오버라이딩)하는 형식의 클래스
	 *  -일회용
	 */
}