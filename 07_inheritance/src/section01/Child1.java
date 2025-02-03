package section01;

/**[상속]
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
public class Child1 extends Parent {
	//물려받은 필드가 존재하기에 삭제
//	private String lastName ="김";
//	private String firstName ="산";
//	private String address ="서울시 강남구";
//	private int money =5000;
	private String laptop;
	public Child1() {
		System.out.println("*** Child1 생성됨 ***");
		setFirstName("산");
		setAddress("서울시 강남구");
		setMoney(5000);
		laptop ="맥북 M4 pro";
	}

	public String getLaptop() {
		return laptop;
	}
	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}
}