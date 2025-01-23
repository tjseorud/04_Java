package encapsulation;

public class EncapsulationRun {
	public static void main(String[] args) {
		Person person1 =new Person();
//		person1.name ="홍길동";
//		person1.height =180.5;
		person1.setName("홍길동");
		person1.setHeight(180.5);
		
		Person person2 =new Person();
//		person2.name ="김미영";
//		person2.height =-160.7;	//캡슐화 안했을때 문제점 1.잘못된 데이터가 대입가능
		person2.setName("김미영");
		person2.setHeight(-160.7);
		
//		System.out.println("person1의 이름 :"+person1.name+" / 키 :"+person1.height);
//		System.out.println("person2의 이름 :"+person2.name+" / 키 :"+person2.height);
		System.out.println("person1의 "+person1.getInfo());
		System.out.println("person2의 "+person2.getInfo());
	}
}