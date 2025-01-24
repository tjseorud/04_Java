package staticmember;

public class StaticMemberRun {
	public static void main(String[] args) {
		System.out.println("Korean.nationalCode :"+Korean.nationalCode);
		/*아래 코드 수행전 이미 static이 붙은 멤버가 static 영역에 할당되어 있음
		 * 클래스명.필드명 / 클래스명.메서드명()
		 */
		Korean k1 =new Korean("김철수", "051230-3216544");
		Korean k2 =new Korean("이미영", "050525-3541282");
//		k1.setNationalCode(82);	//nationalCode필드에 값을명시적으로 초기화
//		k2.setNationalCode(82);
		
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		
		//만약 이미 생성된 모든 Korean 객체의 nationalCode를 수정해야되는 경우
//		k1.setNationalCode(1);
//		k2.setNationalCode(1);
//		static
		Korean.nationalCode =1000;	//모든 Korean 객체의 nationalCode가 일괄변경
		System.out.println("Korean.nationalCode :"+Korean.nationalCode);
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		
		System.out.println("[초기화 블럭]");
		Korean k3 =new Korean();
		Korean k4 =new Korean();
		System.out.println(k3.toString());
		System.out.println(k4.toString());
	}
}