package ex;

import java.util.Scanner;

/**예제 기능(메서드)를 제공하는 클래스
 */
public class OperatorEx {
	/**TEST 메서드(기능 == 함수)1
	 */
	public void test1() {
		System.out.println("test1() 호출됨");
	}
	/**TEST 메서드2
	 */
	public void test2() {
		System.out.println("test2() 호출됨");
	}
	// /** */ DOC 주석은 내부에 HTML 표기법 작성 가능
	/**입력받은 두 정수의 산술 연산 결과 출력하기
	 * <pre>
	 * [실행화면]
	 * 정수입력 1 : 10
	 * 정수입력 2 : 3
	 * 
	 * 10 + 3 = 13
	 * 10 - 3 = 13
	 * 10 * 3 = 13
	 * 10 / 3 = 13
	 * 10 % 3 = 13
	 * </pre>
	 */
	public void method1() {
		Scanner sc =new Scanner(System.in);
		System.out.print("정수입력 1 : ");
		long num1 =sc.nextLong();
		
		System.out.print("정수입력 2 : ");
		long num2 =sc.nextLong();
		
		System.out.println();
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
		System.out.println(num1+" - "+num2+" = "+(num1-num2));
		System.out.println(num1+" * "+num2+" = "+(num1*num2));
		System.out.println(num1+" / "+num2+" = "+(num1/num2));
		System.out.println(num1+" % "+num2+" = "+(num1%num2));
		System.out.printf("\n");
		System.out.printf("%d + %d = %d \n",num1,num2,num1+num2);
		System.out.printf("%d - %d = %d \n",num1,num2,num1-num2);
		System.out.printf("%d * %d = %d \n",num1,num2,num1*num2);
		System.out.printf("%d / %d = %d \n",num1,num2,num1/num2);
		System.out.printf("%d %% %d = %d \n",num1,num2,num1%num2);
		sc.close();
	}
	
	/**입력받은 정수가 3의 배수가 맞는지 확인 
	 * <pre>
	 * [실행화면]
	 * (맞는경우)
	 * 정수 입력 : 6
	 * 6은 3의 배수가 맞습니다.
	 * 
	 * (틀린경우)
	 * 정수 입력 : 7
	 * 7은 3의 배수가 아닙니다.
	 * </pre>
	 */
	public void method2() {
		Scanner sc =new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input =sc.nextInt();
		/* [삼항 연산자(조건 연산자)]
		 * 조건식 ? A : B;
		 * -조건식의 결과가 true 면 A를 반환
		 * -조건식의 결과가 false 면 B를 반환
		 * -삼항 연산자는 중첩 사용이 가능
		 */
		String result =(input % 3 == 0) ? "맞습니다":"아닙니다";
		System.out.printf("%d은 3의 배수가 %s",input,result);
		sc.close();
	}
	
	/**입력된 나이에 따라 "어린이","청소년","성인"구분하기
	 * <pre>
	 * 13세 이하 					:"어린이"
	 * 14세 이상 19세 이하 	:"청소년"
	 * 20세 이상 					:"성인"
	 * </pre>
	 */
	public void method3() {
		Scanner sc =new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age =sc.nextInt();
		
		String result = age <= 13? "어린이":(age <=19? "청소년":"성인");
		System.out.println(result);
		sc.close();
	}
}
