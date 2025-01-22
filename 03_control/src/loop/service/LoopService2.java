package loop.service;

import java.util.Scanner;

public class LoopService2 {
	Scanner scan =new Scanner(System.in);
	public void displayMenu() {
		System.out.println("LoopService2");
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		
		System.out.print("번호입력 : ");
		int input =scan.nextInt();
		
		switch (input) {
		case 1: method1(); break;
		case 2: method2(); break;
		case 3: method3(); break;
		case 4: method4(); break;
		case 5: method5(); break;
		default: System.out.println("잘못 입력됨"); break;
		}
	}
	
	
	/**다음 모양 출력하기
	 * <pre/>
	 * (0,0)(0,1)(0,2)
	 * (1,0)(1,1)(1,2)
	 * (2,0)(2,1)(3,2)
	 * (3,0)(3,1)(3,2)
	 */
	public void method1() {
		for(int i=0; i<4; i++	) {
			for(int j=0; j<3; j++) {
				System.out.printf("(%d,%d) ",i,j);
			}
			System.out.println();
		}
	}
	
	/*분기문
	 * - break :현재 반복종료
	 * - continue :다음 반복으로 넘어가기
	 */
	
	/**1-20까지 출력
	 * 단, 입력받은 수에서 반복 멈추기
	 */
	public void method2() {
		System.out.print("Stop Number : ");
		int stop =scan.nextInt();
		
		for(int i=1; i<=20; i++) {
			System.out.println(i+" ");
			if(i ==stop) {
				break;
			}
		}
	}
	
	/**1-20까지 출력
	 * 단, 입력받은 수의 배수는 출력X
	 */
	public void method3() {
		System.out.print("Continue Number : ");
		int con =scan.nextInt();
		
		for(int i=1; i<=20; i++) {
			if(i % con ==0) {	//i의 배수면 넘김
				continue;
			}
			System.out.println(i+" ");
		}
	}
	
	/**0이 입력 될 때까지 입력된 모든 숫자 합계 구하기*/
	public void method4() {
		int sum =0;
		int input =-1;
		
		while(input !=0) {
			System.out.print("정수입력 : ");
			input =scan.nextInt();
			sum +=input;
		}
		System.out.println("합계 : "+sum);
	}
	
	/*do while
	 * - while의 조건식이 시작이 아닌 마지막 부분으로 이동한 반복문
	 * - 최소 1회 이상 반복 보장
	 * 
	 * [작성법]
	 * do{
	 * }while(조건식);
	 */
	
	/**0이 입력 될 때까지 입력된 모든 숫자 합계 구하기
	 * do while
	 */
	public void method5() {
		int sum =0;
		int input =0;	//int 기본값(0)
		
		do {
			System.out.print("정수입력 : ");
			input =scan.nextInt();
			sum +=input;
		}while(input !=0);
		System.out.println("합계 : "+sum);
	}
}