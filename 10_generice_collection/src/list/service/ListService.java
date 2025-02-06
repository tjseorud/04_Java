package list.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListService {
	/*[Collection Framework]
	 * -Java에서 제공하는 자료구조모음
	 * -java.util 패키지에 존재
	 *[특징]
	 * 1.크기제한 X
	 * 2.추가,수정,삭제,정렬 등의 기능제공
	 * 3.객체만 저장가능
	 * 	-기본 자료형은 Wrapper Class를 이용해서 저장
	 * 	-기본적으로 타입제한 X,개발의 편의성을 위해 1가지 타입으로 제한 ->제네릭스 이용
	 */
	/*[List(목록)]
	 * -데이터를 순차적으로 나열한 자료구조(배열 비슷)
	 *[특징]
	 * -각 데이터를 index를 이용해 구분 ==순서가 있음
	 * -index로 데이터 구분되기 때문에 중복값 저장가능
	 */
	public void test1() {
		/*List는 인터페이스 ->직접 객체생성불가 ->상속받아 구현한 자식클래스 이용
		 *[ArrayList] -배열처럼 생긴 List
		 */
		ArrayList list = new ArrayList();	//제네릭을 이용한 타입제한X
		/*boolean add(E e) :리스트 객체에 요소E 추가후 true 반환*/
		list.add(new Object());
		list.add("hello world");
		list.add(12345);		
		/*E get(int index) :리스트에서 index번쨰 요소E 반환*/
		list.get(0);	//Object type 반환
	  Object obj =list.get(1);
	  if(obj instanceof String) {	//type 검증
	  	System.out.println(((String)obj).length());	//다운캐스팅
	  }
	  /* **불편하게 타입검증, 다운캐스팅을 하는 이유**
	   *  -여러타입을 저장할수 있다는 컬렉션의 특징이 오히려 독이됨
	   *   ->제네릭스를 이용한 타입을 제한 ->한 타입만 있을태니 검증,다운캐스팅 X
	   */
	}
	public void test2() {
		ArrayList<String> list = new ArrayList<String>();	//제네릭을 이용한 타입제한
//		list.add(123);	//type 불일치 오류발생
		list.add("김치찌개");
		list.add("족발");
		list.add("보쌈");
		list.add("치킨");
		list.add("피자");
		list.add("떡볶이");
		
		/*int size() :저장된 객체의 개수 반환*/
		for(int i=0; i<list.size(); i++) {
			String menu =list.get(i);	//i 번째 인덱스값 얻어오기
			//->type 검증 X, 다운캐스팅 X
			System.out.println(menu);
		}		
		for(String menu :list) {	//향상된 for
			System.out.println(menu);
		}
		System.out.println();
		
		/*void add(int index, E e) :index 번째에 e 추가(중간 삽입)*/
		list.add(1,"갈비탕");
		/*String toString()*/
		System.out.println(list.toString());	
		
		/*E set(int index, E e)
		 * -index 번쨰 요소에 전달받은 e를 수정
		 * -결과로 이전에 존재하던 요소(E)를 반환
		 */
		String before =list.set(2, "불족발");
		System.out.println();
		System.out.println(before+"(이)가 수정 되었습니다");
		System.out.println(list);
		
		/*boolean contains(E e)
		 * -같은 객체가 있는지 확인(있다면 true, 없다면 false)
		 * -비교하려는 객체가 equals()를 오버라이딩 해야함
		 */
		System.out.println("보쌈 :"+list.contains("보쌈"));
		System.out.println("막국수 :"+list.contains("막국수"));
		
		/*int indexOf(E e)
		 * -같은 객체가 있는 index 번호를 반환
		 * -없으면 -1 반환
		 */
		System.out.println("치킨 :"+list.indexOf("치킨"));
		System.out.println("햄버거 :"+list.indexOf("햄버거"));
		
		/*E remove(int index)
		 * -index 번쨰 요소 삭제
		 * -삭제된 요소(E) 반환
		 * -중간 요소가 삭제되면 알아서 빈공간을 채움(앞으로 당김)
		 */
		System.out.println(list.remove(2)+" 제거");
		System.out.println(list);
	}
	/*컬렉션 객체의 참조변수는 부모타입(List 인터페이스)으로 설정하면 좋은이유
	 * ->프로그래밍 과정에서 미처 생각하지 못한 비효융적인 요소를 쉽게 개선하기 위해서
	 * 
	 * 1.ArrayList 
	 * 	-배열처럼 요소가 붙어있음
	 *  -장점 :검색속도가 빠름
	 *  -단점 :중간에 추가,수정,삭제가 비효율적
	 *  
	 * 2.LinkedList
	 * 	-요소를 서로 참조하는 형식으로 연결되어있음
	 *  -장점 :중간에 추가,수정,삭제가 효율적
	 *  -단점 :검색속도가 느름
	 */
	public void test3() {
//		List<Integer> list =new ArrayList<Integer>();	//부모 타입 참조변수 List
		List<Integer> list =new LinkedList<Integer>();	//중간에 추가,수정,삭제가 빠른 List
		Random random =new Random();	//난수 생성 객체
		//1970.1.1 09:00:00.000(한국 기준)을 기준으로 현재 얼마나 시간이 지났는지 ms(1/1000초)단위로 계산해서 반환
		long start =System.currentTimeMillis();	
//		try {
//			Thread.sleep(1000);	//현재 쓰레드를 1초(1000ms) 동안 멈춤
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		list.add(random.nextInt(Integer.MAX_VALUE));	//0번
		list.add(random.nextInt(Integer.MAX_VALUE));	//1번
		
		for(int i=0; i<1000000; i++) {
			list.add(1,random.nextInt(Integer.MAX_VALUE));
		}
		long end =System.currentTimeMillis();	
		
		System.out.println("걸린 시간 :"+(end -start)+"ms");
	}
}