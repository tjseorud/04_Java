package section02;

public class Section02Run {
	public static void main(String[] args) {
		Student s1 =new Student();	//기본생성자
		Student s2 =new Student("홍길동",17,"종로고등학교");	//매개변수 있는 생성자
		System.out.println(s2.toString());
	}
	
}