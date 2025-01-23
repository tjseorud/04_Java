package loop.practice;

import java.util.Scanner;
/**기능 제공용 클래스*/
public class LoopPractice {
	Scanner scan =new Scanner(System.in);
	/**사용자로부터 한 개의 값을 입력받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
	 * 단, 입력한 수는 1보다 크거나 같아야 합니다.
	 * 만일 1미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
	 */
	public void practice1(){
		System.out.print("1이상의 숫자를 입력하세요 :");
		int input =scan.nextInt();
		
		if(input <1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		for(int i=1; i<=input; i++) {
			System.out.printf("%d ",i);
		}
	}
	
	/**사용자로부터 한 개의 값을 입력받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
	 * 단, 입력한 수는 1보다 크거나 같아야 합니다.
	 */
	public void practice2(){
	 	System.out.print("1이상의 숫자를 입력하세요 :");
		int input =scan.nextInt();
		
		if(input <1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		for(int i=1; i<input; i++) {
			System.out.printf("%d ",input-i);
		}
	}
	 
	/**1부터 사용자에게 입력받은 수 까지의 정수들의 합을 for문을 이용하여 출력하세요.*/
	public void practice3(){
		System.out.print("정수를 하나 입력하세요 :");
		int input =scan.nextInt();
		int sum =0;
		
		for(int i=1; i<=input; i++) {
			System.out.print(i);
			sum +=i;
			if(input != i) {
				System.out.print(" + ");
			}
		}
		System.out.printf(" = %d",sum);
	}
	 
	/**사용자로부터 두 개의 값을 입력받아 그 사이의 숫자를 모두 출력하세요.
	 * 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
	 */
	public void practice4(){
		System.out.print("첫 번째 숫자:");
		int input1 =scan.nextInt();
		if(input1 <1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		
		System.out.print("두 번째 숫자:");
		int input2 =scan.nextInt();
		if(input2 <1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		int temp =input2;
		if(input1>input2) {
			input2 =input1;
			input1 =temp;
		}
		for(int i=input1; i<=input2; i++) {
			System.out.printf("%d ",i);
		}
	}
	
	/**사용자로부터 입력 받은 숫자의 단을 출력하세요.*/
	public void practice5(){
		System.out.print("숫자 :");
		int input =scan.nextInt();
		
		System.out.printf("===== %d단 =====\n",input);
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d \n",input,i,input*i);
		}
	}
	
	/**사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
	 * 단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요.
	 */
	public void practice6(){
		System.out.print("숫자 :");
		int input =scan.nextInt();
		
		if(input <2) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
			return;
		}		
		for(int j=input; j<=9; j++) {
			System.out.printf("===== %d단 =====\n",input);
			for(int i=1; i<=9; i++) {
				System.out.printf("%d * %d = %d \n",j,i,j*i);
			}			
		}
	}
	
	/**다음과 같은 실행 예제를 구현하세요.
	 * <pre>
	 * ex.
	 * 정수 입력 : 4
	 * *
	 * **
	 * ***
	 * ****
	 * </pre>
	 */
	public void practice7(){
		System.out.print("정수 입력 :");
		int input =scan.nextInt();
		
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");	
			}
			System.out.println();
		}
	}
	
	/**다음과 같은 실행 예제를 구현하세요.
	 * <pre>
	 * ex.
	 * 정수 입력 : 4
	 * ****
	 * ***
	 * **
	 * *
	 * </pre>
	 */
	public void practice8(){
		System.out.print("정수 입력 :");
		int input =scan.nextInt();
		
		for(int i=input; i>0; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");	
			}
			System.out.println();
		}
	}
	
	/**다음과 같은 실행 예제를 구현하세요.
	 * <pre>
	 * ex.
	 * 정수 입력 : 4
	 *    *
	 *   **
	 *  ***
	 * ****
	 * </pre>
	 */
	public void practice9(){
		System.out.print("정수 입력 :");
		int input =scan.nextInt();

		for(int i=1; i<=input; i++) {
			for(int j=1; j<=input-i; j++) {
				System.out.print(" ");	
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**다음과 같은 실행 예제를 구현하세요.
	 * * <pre>
	 * ex.
	 * 정수 입력 : 3
	 * *
	 * **
	 * ***
	 * **
	 * *
	 * </pre>
	 */
	public void practice10(){
		System.out.print("정수 입력 :");
		int input =scan.nextInt();
		
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");	
			}
			System.out.println();
		}
		for(int i=input-1; i>0; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");	
			}
			System.out.println();
		}
	}
	
	
	/**다음과 같은 실행 예제를 구현하세요.
	 * <pre>
	 * ex.
	 * 정수 입력 : 4
	 *    *
	 *   ***
	 *  *****
	 * *******
	 * </pre>
	 */
	public void practice11(){
		System.out.print("정수 입력 :");
		int input =scan.nextInt();
		//v1
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=input-i; j++) {
				System.out.print(" ");	
			}
			for(int j=1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//v2
		for(int i=1; i<=input; i++) {			
			for(int j=1; j<=2*input-1; j++) {
//				if(j <=input-i) {
				if(input-i>= j || input+i<=j) {
					System.out.print(" ");
				}else {
					System.out.print("*");	
				}
			}
			System.out.println();
		}	
	}
	

	/**다음과 같은 실행 예제를 구현하세요.
	 * <pre>
	 * ex.
	 * 정수 입력 : 5
	 * *****
	 * *   *
	 * *   *
	 * *   *
	 * *****
	 * </pre>
	 */
	public void practice12(){
		System.out.print("정수 입력 :");
		int input =scan.nextInt();
		
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=input; j++) {
				if(i==1 || i==input || j==1 || j==input) {	//처음/마지막 행/열만 *출력
					System.out.print("*");
				}else {
					System.out.print(" ");	
				}
			}
			System.out.println();
		}
	}
	
	/**1부터 사용자에게 입력 받은 수까지 중에서
	 * 	1) 2와 3의 배수를 모두 출력하고
	 * 	2) 2와 3의 공배수의 개수를 출력하세요.
	 * 	* ‘공배수’는 둘 이상의 수의 공통인 배수라는 뜻으로 어떤 수를 해당 수들로 나눴을 때 모두 나머지가 0이 나오는 수
	 */
	public void practice13(){
		System.out.print("자연수 하나를 입력하세요 :");
		int input =scan.nextInt();
		int count =0;
		
		for(int i=1; i<=input; i++) {			
			if(i %2 !=0 && i %3 !=0) {
				count++;
				continue;
			}	
			System.out.print(i+" ");		
		}
		System.out.printf("\ncount : %d",count);
	}
	
	/**사용자로부터 입력 받은 하나의 값이 소수인지 판별하는 프로그램을 구현하세요.
	 * 단, 입력한 수가 2보다 작은 경우 “잘못 입력하셨습니다.”를 출력하세요.
	 * 	* ‘소수’는 n을 1부터 n까지로 나누었을 때 나누어 떨어지는 수가 1과 n뿐인 수를 말한다.
	 * 		ex) 2, 3, 5, 7, 11 …
	 */
	public void practice14(){
		System.out.print("숫자 :");
		int input =scan.nextInt();
		int i;
		if(input <2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		for(i =2; i<input; i++) {
			if(input %i ==0) {
				System.out.println("소수가 아닙니다.");
				break;
			}
		}
		if(input ==i) {
			System.out.println("소수입니다.");
		}
	}
	
	/**위 문제와 모든 것이 동일하나, 입력한 수가 2보다 작은 경우
	 * “잘못 입력하셨습니다.”를 출력하면서 다시 사용자가 값을 입력하도록 하세요.
	 * 	* ‘소수’는 n을 1부터 n까지로 나누었을 때 나누어 떨어지는 수가 1과 n뿐인 수를 말한다.
	 * 		ex) 2, 3, 5, 7, 11 …
	 */
	public void practice15(){
		while(true) {
			System.out.print("숫자 :");
			int input =scan.nextInt();
			
			int i;
			if(input <2) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			for(i =2; i<input; i++) {
				if(input %i ==0) {
					System.out.println("소수가 아닙니다.");
					break;
				}
			}
			if(input ==i) {
				System.out.println("소수입니다.");
				break;
			}
		}
	}
	

	/**2부터 사용자가 입력한 수까지의 소수를 모두 출력하고 소수의 개수를 출력하세요.
	 * 단, 입력한 수가 2보다 작은 경우 “잘못 입력하셨습니다.”를 출력하세요.
	 */
	public void practice16(){
		System.out.print("숫자 :");
		int input =scan.nextInt();
		int count =0;
		
		if(input <2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		for(int i=2; i<=input; i++) {	//2부터 입력받은 수까지 1개씩 접근
			boolean flag =true;	//신호용 /true :소수O /false :소수X 
			
			for(int j=2; j<i; j++) {	//1과 자기자신(input)을 뺀 정수를 한 개씩 접근(X)
				if(i %j ==0) {	//1과 자기자신 빼고 나누어 떨어지는 수 존개
					flag =false;
					break;
				}
			}
			if(flag) {
				System.out.print(i+" ");
				count++;
			}
		}
		System.out.printf("\n2부터 %d까지 소수의 개수는 %d개 입니다.",input,count);
	}
}