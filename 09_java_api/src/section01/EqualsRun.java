package section01;

import java.util.Random;

public class EqualsRun {
	public static void main(String[] args) {
		Book book1 =new Book(1,"어린왕자","생택쥐베리",10000);
		Book book2 =new Book(1,"어린왕자","생택쥐베리",10000);
		Book book3 =book1;
		System.out.println(book3 ==book1); //true (저장된 주소가 같음)
		System.out.println("book1 == book2 :"+(book1 ==book2));	//서로다른 객체 참조 ->다른주소 ->false
		//오버라이딩 전 :false(주소비교)
		//오버라이딩 후 :true(필드값비교)
		System.out.println("book1.equals(book2) :"+book1.equals(book2));
		
		/*equals() 오버라이딩에 추가할 내용*/
		//1)같은 객체를 참조하는데 비교하는 경우
		Book book4 =book1;
		System.out.println(book1.equals(book4));
		//2)전달인자가 null인 경우(참조를 안하는 경우)
		Book book5 =null;
		System.out.println(book1.equals(book5));
		//3)비교대상이 같은타입의 객체인지 확인 ->ClassCastException 발생 방지
		Random random =new Random();
		System.out.println(book1.equals(random));
	}
}