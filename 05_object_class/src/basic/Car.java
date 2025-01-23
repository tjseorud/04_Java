package basic;
/**현실에서의 객체는 속성(data), 기능(method)을 가지고있는 식별 가능한것
 * 객체 지향 프로그래밍(OOP, Object Oriented Programming)
 * 	-"객체와 객체가 상호작용을하면 사건이 발생한다" 개념을 프로그램으로 만들 때 적용한 패러다임
 * 
 * Class
 * 	-객체가 가지고있는 속성,기능을 정의한 것
 * 	-이를 통해 새로운 자료형을 만들수 있기 떄문에 "사용자 정의 자료형"이라고도 한다
 * 
 * Java에서 Object(객체)
 * 	-class에 정의된 내용을 토대로 new연산에 의해 JVM Heep 메모리영역에 생성된 것
 */
public class Car {
	/* Filed(필드)	== 멤버변수 -객체의 상태/속성 */
	String brand;
	String model;
	int year;
	
	/* 메서드(Methods) -객체의 기능 */
	public void start() {
		System.out.println("시동을 겁니다.");
	}
	
	public void stop() {
		System.out.println("시동을 끕니다.");
	}
}