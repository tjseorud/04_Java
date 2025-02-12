package section03;

import java.security.PublicKey;

public class OuterClass3 {
	private String instanceMessage ="Hello";	//외부 클래스의 인스턴스 변수
	
	public void outerDisplay() {
		String localMessage ="World";	//외부 클래스의 멤버 메서드에 선언된 지역 변수
		/*지역 내부 클래스 정의*/
		/*(default) 접근 제어자
		 * -같은 패키지 내에서 접근가능
		 * -접근 제어자를 작성하지 않은 상태 == (default)*/
		/*(default)*/class LocalInnerClass{
			public void innerDisplay() {
				//외부 클래스의 멤버변수, 지역변수 접근가능
				System.out.println(instanceMessage+localMessage);
			}
		}
		//지역 내부 클래스를 이용해 객체 생성
		LocalInnerClass inner =new LocalInnerClass();
		inner.innerDisplay();
	}
	public void method() {	//다른 메서드에서는 지역 내부 클래스 호출 X
//		LocalInnerClass inner =new LocalInnerClass(); //Err
	}
}