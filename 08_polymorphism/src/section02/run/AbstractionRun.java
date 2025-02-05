package section02.run;

import section02.dto.Animal;
import section02.dto.Cat;
import section02.dto.Snake;

public class AbstractionRun {
	public static void main(String[] args) {
		/*1.추상 클래스는 객체(instance) 생성불가*/
		/*Cannot instantiate the type Animal
		 * ->Animal 타입은 인스턴스화 할수없다
		 */
//		Animal a =new Animal();
		
		/*2.추상클래스를 상속받은 객체생성*/
		Cat cat =new Cat("고양이과","단모");
		cat.eat();
		cat.move();
		cat.sleep();
		System.out.println();
		
		/*3.추상클래스르 참조형 변수로 사용하기*/
		Animal a2 =new Cat("고양이과","장모");	//다형성 -업캐스팅 적용
		//Animal의 eat() 메서드는 추상메서드로 원래는 호출이 불가능하지만
		//참조하는 객체가 eat()를 구현한 자식타입이므로 컴파일시(정적바인딩) 오류발생 X
		
		//실제 실행시 Cat 	
		a2.eat();
		a2.move();
		a2.sleep();
		System.out.println();
		
		/*4.추상클래스 활용법*/
		printAnimal(new Cat("고양이과","털없음"));
		printAnimal(new Snake("파충류"));
	}
	//static :프로그램 실행시 해석되어 static 메모리영역에 생성되는 키워드 ->객체생성없이 클래스명.메서드명 호출가능
	// +같은클래스라도 static 메서드 내에서 다른 메세드를 호출하려면 
	//  1)현재클래스를 이용해 객체생성
	//	2)
	public static void printAnimal(Animal animal) {	
		/*매개변수 Animal(추상클래스)
		 * -부모타입의 참조변수로 사용(다형성 -업캐스팅)
		 * -Animal을 상속받은 클래스는 반드시 상속받아 재정의한 eat(),move(),sleep() 존재
		 * 	->자식에게 공통적인 규약설정(오버라이딩 강제화)
		 * 
		 * -Animal이 상속한 추상메서드를 호출(동적바인딩)
		 */
		System.out.println();
		System.out.println(animal.getClass().getName());
		animal.eat();
		animal.move();
		animal.sleep();
		System.out.println(animal.toString());
	}
}