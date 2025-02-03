package section01;

public class section01Run {
	public static void main(String[] args) {
		Parent p1 =new Parent();
		System.out.println("Parent.toString() :"+p1.toString());
		System.out.println();
		
		Child1 c1 =new Child1();
		/* *** Parent 생성됨 ***
		 * *** Child1 생성됨 ***
		 * ->자식 객체생성시 부모 객체도 같이 생성
		 */
		System.out.println("Child1.toString() :"+c1.toString());
		System.out.println("Child1.getLaptop() :"+c1.getLaptop());
		
		Child2 c2 =new Child2();
		System.out.println("Child2.toString() :"+c2.toString());
		System.out.println("Child2.getCar() :"+c2.getCar());
		
		Child3 c3 =new Child3();
		System.out.println("Child3.toString() :"+c3.toString());
		System.out.println("Child3.getBitCoin() :"+c3.getBitCoin());
		
		/*[상속]
		 * 부모의 코드(필드/메서드)를 물려받아 자식이 자신의 것처럼 사용
		 * 
		 * [특징/장점]
		 * 1.재 사용성 증가 :한번 작성한 부모코드를 자식들이 재사용
		 * 2.유지보수성 증가 :부모코드만 수정하면 자식은 그대로 있어도 됨
		 * 3.공통적인 규약 정의 :물려받은 자식등의 형태가 부모와 비슷
		 *  ->부모코드 수정,추가,제거 시 자식도 일괄변경
		 *  
		 * [상속 키워드] :extends(확장하다) 
		 *  ->부모의 필드/메서드를 상속받은 자식의 크기가 커지기 때문 "확장하다" 키워드 사용
		 *  
		 * [상속 주의사항]
		 * 1)부모의 생성자는 상속불가
		 * 2)부모의 private 필드/메서드는 상속받은 자식이어도 접근불가
		 * 
		 * [상속 메모리 구조] -자식객체 생성시 부모객체가 같이 생성되어 자식객체 내부에 배치
		 */
	} 
}
