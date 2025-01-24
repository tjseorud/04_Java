package staticmember;

public class Korean {
	/**static(정적인, 고정된)
	 * -고정된영역(static 메모리영역)에 모든객체가 공유할멤버(필드/메서드)를 생성해서 공유
	 * -static이 붙은 멤버는 [프로그램 실행시] static 영역에 할당 [프로그램 종료시]소멸
	 */
	//클래스 변수
	// -생성시기 :프로그램 실행시 static 영역에 생성
	// -소멸시기 :프로그램 종료시 소멸
	public static int nationalCode =82;	//국가코드 //생성시 82로 필드를 초기화(명시적 초기화)
	//인스턴스 변수 
	// -생성시기 :객체 생성시 변수도 같이 생성
	// -소멸시기 :어떤 변수도 객체를 참조하지 않을 경우 객체 소멸
	//  (Heep 메모리영역의 GC(Garbage Collection)가 메모리 반환)
	private String name;
	private String id;
	//인스턴스 초기화 블럭 :인스턴스 변수 초기화 목적
	{
		System.out.println("객체 생성시 마다 수행");
		name ="홍길동";
		id ="900101-1234567";
	}
	//클래스 초기화 블럭 :클래스 변수 초기화 목적
	static {
		System.out.println("프로그램 실행시 수행");
		nationalCode =999;
//		name ="user"; //인스턴스 변수는 초기화 불가
	}
	public Korean() {}	//class에 생성자가 없을경우 컴파일러가 추가함
	public Korean(String name,String id) {
		this.name =name;
		this.id =id;
	}
	//getter/setter(필드 간접 접근)
	public int getNationalCode() {
		return nationalCode;
	}
	public void setNationalCode(int nationalCode) {
//		this.nationalCode = nationalCode;	
		Korean.nationalCode = nationalCode;	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String toString() {
		return String.format("이름 :%s / 주민번호 :%s / 국가코드 :+%d \n", name,id,nationalCode);
	}
}
