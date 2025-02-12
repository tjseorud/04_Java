package section01;

public class OuterClass1 {
	//OuterClass1의 필드(==멤버변수)
	private int num =10;
	
	private void test() {	//멤버 메서드
		System.out.println("OuterClass1의 test() method");
		System.out.println("num :"+num);	//멤버끼리는 서로 호출가능(접근 제어자 관련X)
	}
	/*외부 클래스 메서드를 이용해서 내부 클래스 객체생성*/
	public void displayMessage() {
		System.out.println("[외부 클래스에서 내부 클래스 객체생성]");
		InstanceInnerClass inner =new InstanceInnerClass();
		inner.display();
	}
	/*인스턴스 내부 클래스 정의 ==OuterClass1의 멤버*/
	public class InstanceInnerClass {
		public void display() {
			System.out.println("InstanceInnerClass display() method");
			num =300;	//OuterClass1의 멤버 변수 값 변경
			test();		//OuterClass1의 멤버 메서드 호출
			//->인스턴스 내부 클래스는 외부 클래스 멤버 접근가능
		}
	}
	
	/*static
	 * -프로그램 실행 시 변수/메서드를 메모리영역에 (클래스명.변수/클래스명.메서드명 형태로)할당
	 * -프로그램 종료 될때까지
	 */
}