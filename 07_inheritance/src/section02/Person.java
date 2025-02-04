package section02;

/*Object Class
 * -모든 클래스(객체)의 최상의 부모
 * -모든 클래스(객체)가 공통적으로 가져야하는 기능이 모여있음
 * 
 * -클래스 선언부에 아무런 상속구문이 작성되지 않으면 컴파일러가 자동으로 [extends Object]추가
 */
/*final class /final 메서드
 * -final :마지막,최종
 * 
 *[final 예약어]
 * -final class :상속불가 클래스 ->다른 클래스가 필드/메서드를 상속받아 사용하지 못하게 하려고(+모든 메서드 오버라이딩 불가)
 * -final method :오버라이딩 불가 메서드 ->바꾸면 문제가 생기는 기능 재정의 방지
 * -final variable :값 대입불가 변수(상수)
 * 
 * *자바에서 클래스간의 상속은 단일상속만 지원한다
 */
public /*final*/ class Person /*extends Object*/ {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("[new Person]");
	}
	//매개변수 생성자 자동생성 :Alt + Shift + S ->O

	public Person(String name, int age) {
		System.out.println("[Person 매개변수 있는 생성자로 생성됨]");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/*Object.toString()
	 * -객체를 사람이 읽기 쉬운 간단한 문자열 형태로 반환하는 목적의 메서드
	 * -모든 자식 클래스에서 재정의(Overriding)해서 사용
	 */
	/*오버라이딩(Overriding)
	 * -덮어쓰다, 재정의 하다
	 * -부모와 같은 이름의 메서드를 자식이 다시 정의하는 기술(자식이 용도의 맞게 코드를 수정)
	 * 
	 * [Overriding 성립조건]
	 * 1)변경불가 
	 * 	-메서드명, 반환형, 매개변수의 타입, 개수, 순서
	 * 2)변경가능
	 * 	-접근 제어자는 같거나 넓은범위로 변경가능
	 * 	-예외처리는 같거나 좁은범위로 변경가능
	 * 
	 * [주의사항]
	 * 부모의 private 메서드는 오버라이딩 불가(직접접근이 차단되어 있어 재정의 자체가 불가)
	 */ 
  /*어노테이션(Annotation, 주석) :컴파일러를 위한 주석
   * -코드의 추가적인 정보제공 목적
   * -컴파일러에게 지시하는 목적
   * 
	 *@Override 어노테이션
	 * 1)해당 메서드가 오버라이딩 되었음을 명시(정보제공)
	 * 2)컴파일러에게 해당 메서드 오버라이딩이 문제없이 작성되었는지 확인(검증)하라 지시
	 *  (성립조건을 위배하지 않았는지 확인)
	 */  
	/*[오버라이딩(Overriding, 덮어쓰기/재정의)] 
	 * -상속관계에서 부모의 메서드를 자식이 용도에 맞게 재정의하는 것
	 * 
	 *[오버로딩(Overloading, 과적)] 
	 * -하나의 클래스에 같은이름의 메서드를 여러개 작성하는 기술
	 * -비슷한 기능을 제공하는 메서드들을 하나의 이름으로 관리
	 * 
	 *오버로딩
	 * -같은 class에 작성
	 * -매개변수(개수,순서,타입)하나라도 다름
	 * -반환형 관계없음
	 * -접근제어 관계없음
	 * -예외처리 관계없음	
	 *오버라이딩
	 * -하위(자식) class에 작성
	 * -매개변수 동일
	 * -반환형 동일
	 * -접근제어 같거나 넓은범위
	 * -예외처리 같거나 좁은범위
	 * 
	 *(공통점) :메서드 이름이 동일해야한다
	 */
	@Override
	public String toString() {
		return String.format("name :%s / age :%d", name,age);
	}
	
	public /*final*/ String introduce(String alias) {
		return String.format("[Person] 이름은 %s 이고 별명은 %s 입니다", name,alias);
	}
}