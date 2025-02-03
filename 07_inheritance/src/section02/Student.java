package section02;

/**Person class를 상속받은 Student class
 * 
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
	public String toString() {
		return String.format("name :%s / age :%d / schoolName :%s", getName(),getAge(),schoolName);
	}
}
