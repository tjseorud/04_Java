package loop.service;

import java.util.Scanner;

/**반복문 기능 제공 class1*/
public class LoopService1 {
	Scanner scan =new Scanner(System.in);
	public void displayMenu() {
		System.out.println("1.method1()");
		System.out.println("2.method2()");
		System.out.println("3.method3()");
		System.out.println("4.method4()");
		System.out.println("5.method5()");
		System.out.println("6.method6()");
		System.out.println("7.method7()");
		System.out.println("8.method8()");
		System.out.print("실행할 메서드 번호입력 : ");
		int input =scan.nextInt();
	
		switch (input) {
		case 1: method1(); break;
		case 2: method2(); break;
		case 3: method3(); break;
		case 4: method4(); break;
		case 5: method5(); break;
		case 6: method6(); break;
		case 7: method7(); break;
		case 8: method8(); break;		
		default: System.out.println("없는 번호 입력"); break;
		}
	}
	
	/**for를 이용하며 1-10까지 세로로 출력*/
	public void method1() {
		/* 초기식 : for에서 사용할 지역 변수 선언
		 * 조건식 : 결과가 true/false가 나오는 식
		 * 증감식 : 초기식 변수를 증감시켜 조건식의 결과가 변할 수 있게 제어하는 식
		 */
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}			
	}
	
	/**9876554321 출력*/
	public void method2() {
		for(int i=9; i>=1; i--) {
			System.out.print(i);
		}
		System.out.println();
		
		for(int i=0; i<9;i++) {
			System.out.print(9-i);
		}
	}
	
	/**두 정수를 입력받아 두 정수사이 모든 정수를 출력(무조건 첫번째 입력은 작은수)
	 * <pre/>
	 * 첫 번째 정수입력 : 5
	 * 두 번째 정수입력 : 12
	 * 5 6 7 8 9 10 11 12
	 */
	public void method3() {
		System.out.print("첫 번째 정수입력 : ");
		int num1 =scan.nextInt();
		
		System.out.print("두 번째 정수입력 : ");
		int num2 =scan.nextInt();
		
		for(int i=num1; i<=num2; i++) {
			System.out.print(i+" ");
		}
	}
	
	/**입력된 두 정수 사이의 모든 정수 출력
	 * <ul/>
	 * 	<li/>입력 1이 입력 2보다 작거나 같은경우 :1234- 증가하며 출력
	 * 	<li/>입력 1이 입력 2보다 큰 경우 :9876- 감소하며 출력
	 */
	public void method4() {
		System.out.print("입력 1 : ");
		int num1 =scan.nextInt();
		
		System.out.print("입력 2 : ");
		int num2 =scan.nextInt();
		
		if(num1<=num2) {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i+" ");
			}
		}else {
			for(int i=num1; i>=num2; i--) {
				System.out.print(i+" ");
			}
		}
	}
	
	/**두 정수를 입력받아 작은 수부터 큰 수까지 1씩 증가하며 출력
	 * <pre/>
	 * [실행화면]
	 * 입력 1 : 3
	 * 입력 2 : 6
	 * 3 4 5 6
	 * 
	 * 입력 1 : 7
	 * 입력 2 : 2
	 * 2 3 4 5 6 7
	 */
	public void method5() {
		System.out.print("입력 1 : ");
		int num1 =scan.nextInt();
		
		System.out.print("입력 2 : ");
		int num2 =scan.nextInt();
		//v1
		if(num1<=num2) {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i+" ");
			}
		}else {
			for(int i=num2; i<=num1; i++) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		//v2
		int start =num1;
		int end =num2;
		
		if(num1>num2) {
			start =num2;
			end =num1;
		}
		for(int i=start; i<=end; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		//v3 num1,num2 (swap)
		int temp =num2;
		if(num1>num2) {
			num2 =num1;
			num1 =temp;
		}
		for(int i=num1; i<=num2; i++) {
			System.out.print(i+" ");
		}
	}
	
	/**1-100사이의 정수 중 입력받은 정수의 배수가 몇개, 배수의 합 구하기*/
	public void method6() {
		System.out.print("정수 입력 : ");
		int num =scan.nextInt();
		int sum =0;
		int count =0;
		
		for(int i=num; i<=100; i++) {
			count++;
			sum +=i;
		}
		System.out.printf("개수 : %d / 합계 : %d",count,sum);
	}
	
	/**입력받은 단 출력하기(구구단)*/
	public void method7() {
		System.out.print("단 입력 : ");
		int num =scan.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%2d X %2d = %2d \n",num,i,num*i);
		}
	}
	
	/**입력받은 두 정수 사이의 구구단을 모두 출력
	 * <pre/>
	 * 시작 단 : 3
	 * 종료 단 : 5
	 * 
	 * [3단]
	 * 3 X 1 = 3
	 * ...
	 * [4단]
	 * 4 X 1 = 4
	 * ...
	 * [5단]
	 * 5 X 1 = 5
	 * ...
	 */
	public void method8() {
		System.out.print("시작 단 : ");
		int num1 =scan.nextInt();
		
		System.out.print("종료 단 : ");
		int num2 =scan.nextInt();
		
		for(int i=num1; i<=num2; i++) {
			System.out.printf("\n[%d단]\n",i);
			
			for(int j=1; j<=9; j++) {
				System.out.printf("%2d X %2d = %2d \n",i,j,i*j);
			}
		}
	}
}