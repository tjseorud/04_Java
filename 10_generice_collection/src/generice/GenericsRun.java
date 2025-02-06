package generice;

import java.util.List;

public class GenericsRun {
	public static void main(String[] args) {
		Box<String> box1 =new Box<String>();	//제네릭 타입을 String으로 지정
		box1.setValue("String만 전달가능");
		System.out.println(box1.getValue());
		
		Box<Integer> box2 =new Box<Integer>();	//제네릭 타입을 Integer으로 지정
		box2.setValue(1234);	//int ->Integer(Auto Boxing)
		System.out.println(box2.getValue());
		System.out.println();
		
		System.out.println("제");
		TestBox<Parent> t1 =new TestBox<Parent>();
		t1.setObj(new Parent());
		System.out.println(t1.getObj().getClass());
		
		TestBox<Child> t2 =new TestBox<Child>();
		t2.setObj(new Child());
		System.out.println(t2.getObj().getClass());
		
		//String은 Parent 상속관계가 아니기때문에 오류발생
//		TestBox<String> t3 =new TestBox<String>();
	}
	/*와일드카드 <?>
	 * -제네릭 클래스의 타입처리를 유연하게 대처해주는 문법
	 * 
	 * <?> :?에 어떤 타입이든 가능
	 * <? extends T>	:?는 T 또는 T 하위 타입
	 * <? super T>		:?는 T 또는 T 상위 타입
	 */
	public void test1(List<? extends Parent> list) {}
}