package section01.run;

import section01.dto.Child;
import section01.dto.Parent;

/**다형성 확인 +기초
 */
public class TestRun {
	public static void main(String[] args) {
		Parent p1 =new Parent();	//부모 참조변수 =부모객체 ->양쪽 다 Parent 타입 ==컴퓨터 값처리 원칙 ok
		//p1 호출가능 메서드 -Parent의 메서드 +Object 한테 상속받은 메서드
		System.out.println("p1.getLastName() :"+p1.getLastName());
		System.out.println("p1.hashCode() :"+p1.hashCode());
		System.out.println();
		
		Child c1 =new Child("신",500,"붕붕이");	//자식 참조변수 =자식객체 -Child +Object, Parent에게 상속받은 메서드
		System.out.println("c1.getCar() :"+c1.getCar());
		System.out.println("c1.getLastName() :"+c1.getLastName());
		System.out.println("c1.hashCode() :"+c1.hashCode());
		
		/*다형성(Polymorphism)
		 * -하나의 객체가 다양한 객체형태로 변하는 성질
		 * 
		 *다형성 -업캐스팅(Up Casting)
		 * -자식객체의 형태를 부모 객체형태로 변환
		 * -'부모'참조변수 =new '자식'객체; ->자식 객체가 부모 객체 형태로 변한 것처럼 보임
		 * 
		 *다형성 -다운캐스팅(Down Casting)
		 * -업캐스팅 상태에서(부모 참조변수 =자식 객체) 참조변수의 자료형을 자식 타입으로 강제형변환 하는것
		 */
		//업캐스팅 확인
		Parent p2 =new Child("김",9999,"아벤떼");	//부모 참조변수 =자식 객체(오류 X) ->Why? 자식객체 내 부모객체 부분만 참조하기 때문
		//p2 호출가능 메서드 -Parent,Object 메서드만 호출가능
		// -Child 객체지만 Parent로 변경되어 Child 메서드 인식불가
		System.out.println("p2.getLastName() :"+p2.getLastName());
		System.out.println("p2.hashCode() :"+p2.hashCode());
//		System.out.println(p2.getCar());	//Err
		System.out.println();
		//다운캐스팅 확인
		System.out.println(((Child)p2).getCar());
		
		Child c2 =(Child)p2;	//얕은복사(주소만 복사)
		System.out.println(c2.getCar());
	}
}
