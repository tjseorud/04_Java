package section03.run;

import section03.dto.Calculator;
import section03.dto.SDKCalculator;

public class InterfaceRun {
	public static void main(String[] args) {
		//인터페이스를 부모타입 참조변수로 Calculator 구현체 생성하기(업캐스팅 +동적바인딩)
		Calculator calc =new SDKCalculator();
		/*같은 Calculator 인터페이스를 상속받은 다른 객체생성 ->Calculator가 제공하는 같은이름의 메서드가 존재
		 * -> 다른코드 수정없이 객체생성 부분만 수정해도 새 객체의 기능을 모두 호출가능 -> 유지 보수성 향상
		 */
//		Calculator calc =new SDKCalculator2();
		
		System.out.println(calc.plus(1234, 5678));
		System.out.println(calc.minus(987654, 123456));
		System.out.println(calc.multi(3333, 4444));
		System.out.println(calc.div(1111, 3));
		System.out.println(calc.mod(1111, 3));
		System.out.println(calc.pow(2, 16));
		System.out.println(calc.areaOfCircle(10.5));
	}
}