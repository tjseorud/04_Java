package condition.service;

import java.util.Scanner;

/**기능(예제, 연습문제) 제공용 class
 */
public class ConditionService {
	//필드(field) == 멤버변수 == 인스턴스 변수
	// - 해당 클래스 내에서 언제,어디서든지 사용가능한 변수
	Scanner sc =new Scanner(System.in);	
	/**1-10 사이 난수(정수)가 짝수인지 홀수인지 검사
	 */
	public void method1() {
//		Math.random() : 0.0 이상 1.0 미만 난수발생
		int randomNumber =(int)(Math.random()*10 +1);
		
		boolean result =randomNumber %2==0;	//0이면 true, 1이면 false
		System.out.println("randomNumber :"+randomNumber);
		if(result) {
			System.out.println("짝수 입니다");
		}else {
			System.out.println("홀수 입니다");
		}
	}
	
	/**나이를 입력받아 "어린이","청소년","성인"구분
	 * <pre>
	 * 13세 이하	"어린이"
	 * 13세 초과 19세 이하 "청소년"
	 * 19세 초과	"성인"
	 * </pre>
	 */
	public void method2() {
		String result;
		System.out.print("나이 입력 : ");
		int age =sc.nextInt();
		
		if(age <= 13) {
			result ="어린이";
		}else if(age >19) {
			result ="성인";
		}else {
			result ="청소년";
		}
		System.out.printf("%s",result);
	}
	
	/**나이를 입력받아 "어린이","청소년","성인"구분
	 * <pre>
	 * 13세 이하	"어린이"
	 * 13세 초과 19세 이하 "청소년"
	 * 	- 14-16세 :"청소년(중)"
	 * 	- 17-19세 :"청소년(고)"
	 * 19세 초과	"성인"
	 * 0 미만 100 이상 "잘못 입력하셨습니다"
	 * </pre>
	 */
	public void method3() {
		String result;
		System.out.print("나이 입력 : ");
		int age =sc.nextInt();
		if(age <0 ||age >=100) {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
		result =(age <=13)?"어린이":(age >19)?"성인":(age <=16)?"청소년(중)":"청소년(고)";
		System.out.println(result);
	}
	
	
	/* switch case default */
	/**ConditionService에 작성된 메서드를 골라서 실행하는 메서드
	 */
	public void displayMenu() {
		System.out.println("1.method1()");
		System.out.println("2.method2()");
		System.out.println("3.method3()");
		System.out.print("메뉴번호 입력 >>");
		int input =sc.nextInt();
		
		/*(중요) 같은 클래스내 필드, 메서드는 이름만 부르면 호출 가능*/
		switch(input) {
		case 1: method1(); break;
		case 2: method2(); break;
		case 3: method3(); break;
		default: System.out.println("없는 메뉴번호 입니다.");
		}
	}
	
	/** [성적 판별기]
	 * <pre>
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
	 * 
	 * - 중간고사 (40%), 기말고사(50%), 과제(10%)
	 * 
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * 
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95점 이상 : A+
	 * 90점 이상 : A
	 * 85점 이상 : B+
	 * 80점 이상 : B
	 * 75점 이상 : C+
	 * 70점 이상 : C
	 * 65점 이상 : D+
	 * 60점 이상 : D
	 * 나머지    : F
	 * 
	 * 
	 * [실행 화면]
	 * 이름 : 홍길동
	 * 중간고사 점수(40%) : 100
	 * 기말고사 점수(50%) : 80
	 * 과제 점수(10%) : 50
	 * 
	 * 홍길동의 최종 점수 : 85.0점
	 * 성적 : B+
	 *</pre>
	 */
	public void method4() {
		String result;
		System.out.print("이름입력 :");
		String userName =sc.next();
		
		System.out.print("중간고사 점수입력 :");
		int test1 =sc.nextInt();
		if(test1 <0 || test1 >100) {
			System.out.println("입력값이 0미만이거나 100을 초과했습니다");
			return;
		}
		System.out.print("기말고사 점수입력 :");
		int test2 =sc.nextInt();
		if(test2 <0 || test2 >100) {
			System.out.println("입력값이 0미만이거나 100을 초과했습니다");
			return;
		}
		System.out.print("과제 점수입력 :");
		int test3 =sc.nextInt();
		if(test3 <0 || test3 >100) {
			System.out.println("입력값이 0미만이거나 100을 초과했습니다");
			return;
		}
		
		double input =(test1*0.4)+(test2*0.5)+(test3*0.1);
		result =input>=95?"A+":input>=90?"A":input>=85?"B+":input>=80?"B":input>=75?"C+":input>=70?"C":input>=65?"D+":input<60?"F":"D";		
		System.out.println("이름 : "+userName);
		System.out.println("중간고사 점수(40%) : "+test1);
		System.out.println("기말고사 점수(50%) : "+test2);
		System.out.println("과제 점수(10%) : "+test3);
		System.out.printf("%s의 최종 점수 : %.1f점 \n성적 : %s",userName,input,result);
	}
}
