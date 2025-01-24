package abstraction;
//class :객체의 멤버(필드,메서드)를 정의한 문서 (==설계도)
public class Student {
	/*추상화(Abstraction)
	 * 객체의 공통점을 추출하고, 불필요한 부분 제거하고 유연성을 확보하는것 
	 */
	//필드 == 멤버변수
	//private 접근 제한자 -외부 직접접근을 제한(캡슐화 원리)
	private String studentNumber;
	private String name;
	private int html;
	private int css;
	private int js;
	private int java;
	/*생성자
	 * -객체가 생성될때 수행할 명령어를 작성한 특수한 메서드
	 * -객체 생성시 1회만 수행
	 *	
	 *[작성법]
	 *접근제어자 클래스명(){}
	 * -반환형X
	 * -이름은 클래스와 동일
	 */	
	/**기본 생성자 
	 * -매개변수가 없는 생성자
	 * -클래스 내에 생성자가 1개도 없으면 컴파일러가 자동으로 추가 ->public 클래스명(){}
	 */
	public Student() {
		System.out.println("--Student() 생성됨--");
		/*객체가 heep영역에 생성될 때 필드값이 모두 JVM 초기값으로 세팅이 진행됨
		 * -heep영역은 비어있는 상태로 존재불가
		 * -정수형 :0, 실수형 :0.0, 논리형 :false, 문자형 :'\u0000', 참조형 :null(참조하는 객체가 없다, 저장된 주소가 없다)
		 * 
		 * 생성자를 이용해서 객체가 생성될 때 필드값을 원하는 값으로 초기화 할수있다
		 */
		studentNumber ="202500000";
		name ="admin";
		html =100;
		css =100;
		js =100;
		java =100;
	}
//	Duplicate method Student() in type Student
	public Student(String studentNumber,String name) {	//매개변수가 있는 생성자
		System.out.println("--Student(String,String) 객체생성--");
		this.studentNumber =studentNumber;
		this.name =name;
	}
	//매개변수가 있는 생성자(모든필드 초기화)
	public Student(String studentNumber,String name,int html,int css,int js,int java) {	
		System.out.println("--모든 필드 초기화 생성자 객체생성--");
		this.studentNumber =studentNumber;
		this.name =name;
		this.html =html;
		this.css =css;
		this.js =js;
		this.java =java;
	}
	/*오버로딩(OverLoading, 과적)
	 * -하나의 클래스내에 같은이름의 메서드를 여러개 작성하는 기술
	 * -같은이름의 메서드는 원래 하나만 존재할수 있지만 매개변수(순서,타입,개수)를 다르게하여
	 * 	같은이름의 메서드라도 구분할 수 있게됨
	 */
	//메서드 == 객체의 기능(함수)
	/*접근제어자 반환타입 메서드명(매개변수) {	->선언부
 	 * 	// 메서드 정의 ->구현부
 	 * 	return 반환값;
	 * }
	 */
	/*직접 접근이 제한된 필드에 간접접근하는 방법을 제공하는 메서드
	 * (getter/setter)
	 */
	//getter :객체의 필드값을 얻어가게 만드는 메서드
	public String getName() {
		return name;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public int getHtml() {
		return html;
	}
	public int getCss() {
		return css;
	}
	public int getJs() {
		return js;
	}
	public int getJava() {
		return java;
	}
	//setter :외부에서 전달받은값을 객체의 필드에 세팅하는 메서드
	/*public void set필드명(매개변수) {
	 * 	this.필드명 =매개변수;
	 * }
	 * this 참조변수 :생성된 객체를 참조하는 변수(현재 객체)
	 */
	public void setName(String name) {
		 /*필드*/this.name =name;/*매개변수*/
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber =studentNumber;
	}
	public void setHtml(int html) {
		this.html =html;
	}
	public void setCss(int css) {
		this.css =css;
	}
	public void setJs(int js) {
		this.js =js;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	}
	public void setJava(int java) {
		this.java =java;
	}
	public int getSum() {	//합계
		return html+css+js+java;
	}
	public double getAverage() {	//평균
		return getSum() /4.0;
	}
	public String toString() {
		/* [반환형]
		 * String String.format("템플릿(패턴)",패턴에 대입될 값);
		 * 	-지정된 형식의 문자열을 만드는 메서드
		 * 	-System.out.print() 처럼 작성되지만 출력되지 않고 String으로 반환
		 */
		String str =String.format("[%s] %s \n"
				+ "HTML :%d / CSS :%d / JS :%d / Java :%d \n"
				+ "합계 :%d \n"
				+ "평균 :%.2f\n",
				studentNumber,name,html,css,js,java,getSum(),getAverage());
		return str;
	}
}