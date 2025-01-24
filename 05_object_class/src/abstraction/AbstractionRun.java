package abstraction;

public class AbstractionRun {
	public static void main(String[] args) {
		//객체생성 -클래스에 정의된 내용대로 Heep 메모리영역에 할당(생성)
		Student std =new Student();
		std.setName("철수");
		std.setStudentNumber("202500001");
		std.setHtml(100);
		std.setCss(70);
		std.setJs(80);
		std.setJava(30);
		
		System.out.println(std.getName()+"의 점수 합계 :"+std.getSum());
		String result =std.toString();
		System.out.println(result);
		
		Student std2 =new Student();
		std2.setStudentNumber("202400001");
		std2.setName("짱구");
		std2.setHtml(59);
		std2.setCss(68);
		std2.setJs(71);
		std2.setJava(57);
		
		String result2 =std2.toString();
		System.out.println(result2);
		
		Student std3 =new Student();
		std3.setStudentNumber("202400002");
		std3.setName("히히모카");
		std3.setHtml(80);
		std3.setCss(80);
		std3.setJs(80);
		std3.setJava(80);
		
		String result3 =std3.toString();
		System.out.println(result3);
	}
}