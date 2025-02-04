package section02;

public class Section02Run {
	public static void main(String[] args) {
		Student s1 =new Student();	//기본생성자
		Student s2 =new Student("홍길동",17,"종로고등학교");	//매개변수 있는 생성자
		System.out.println(s2.toString());
		
		//Overriding test
		Person p3 =new Person("짱구",5);
		System.out.println(p3/*.toString()*/);
		System.out.println(p3.introduce("데빌구"));
		System.out.println();
		/*[참고]
		 * print 관련 메서드 또는 문자열 +연결시 참조변수명만 작성하면 자동으로 toString() 호출됨
		 * (컴파일러가 자동으로 .toString() 추가)
		 */
		Student s3 =new Student("철수",8,"떡잎초등학교");
		System.out.println(s3);
		System.out.println(s3.introduce("모범생"));
	}
	
}