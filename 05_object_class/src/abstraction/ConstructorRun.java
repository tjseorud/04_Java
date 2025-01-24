package abstraction;

public class ConstructorRun {
	public static void main(String[] args) {
		Student std1 =new Student();	//Student 기본 생성자를 이용 생성
		System.out.println(std1.toString());
		
		Student std2 =new Student("202500004", "맹구");		//Student(String,String)
		System.out.println(std2.toString());
		
		Student std3 =new Student("202500005", "유리", 40, 70, 90, 100);	//모든 필드 초기화 생성자
		System.out.println(std3.toString());
		
		Student std4 =new Student("202500006", "수지", 100, 100, 100, 100);	
		System.out.println(std4.toString());
	}
}