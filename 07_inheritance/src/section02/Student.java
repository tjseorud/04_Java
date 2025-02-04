package section02;

/**Person class를 상속받은 Student class
 */
public class Student extends Person {
	private String schoolName;
	/*super() 생성자
	 * -super :극상의, 상위의
	 * -현재 클래스의 상위클래스(부모) 생성자를 호출하는 구문
	 * -super() 생성자는 반드시 자식생성자의 첫 번째줄에 작성 되어야한다(미작성시 컴파일러가 자동추가)
	 * -코드길이 감소, 재사용성 증가
	 */
	public Student() {
		super();	//부모 기본생성자
		System.out.println("[new Student]");
	}
	/*매개변수가 있는 생성자
	 * ->가 가지고 있는 모든 필드(schoolName,name,age) 초기화
	 */
	public Student(String name, int age, String schoolName) {
		//부모의 매개변수있는 생성자를 호출 ->코드 길이감소
		super(name,age);
//		setName(name);
//		setAge(age);
		this.schoolName =schoolName;
		System.out.println("[Student 매개변수 있는 생성자로 생성됨]");
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/*super 참조변수(부모참조변수)
	 * -자식 내 부모객체를 참조하는 변수
	 * -부모의 필드/메서드에 접근하기위해 사용
	 */
	public String toString() {
		return super.toString()+" / schoolName :"+schoolName;	//super.toString() :부모의 toString() 메서드 호출
	}
//	public String toString() {
//		return String.format("name :%s / age :%d / schoolName :%s", getName(),getAge(),schoolName);
//	}
	/*Person.introduce() 메서드 오버라이딩(재정의)
	 * 오버라이딩 성립조건
	 * [변경불가] 
	 *  -반환형,메서드명,매개변수(개수,순서,타입)
	 * [변경가능] 
	 *  -접근제어자(같거나 넓은범위),예외처리(같거나 좁은범위)
	 */
	//Person.introduce() final
	//Cannot override the final method from Person
	@Override
	public String introduce(String alias) {
		return String.format("[Student Override] 이름은 %s, %s 이죠",super.getName(),alias);
	}
}
