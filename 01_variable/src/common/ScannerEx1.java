package common;

// import(가져오다) :다른 패키지에서 존재하는 클래스를 가져오는 구문
import java.util.Scanner;

public class ScannerEx1 {
	public static void main(String[] args) {
		/* Scanner Class
		 * - 사용자로부터 입력을 받기위해 Java에서 제공하는 클래스
		 * - 패키지에 존재
		 * 	-> 사용시 import 구문을 작성해 가져와야함 */
		
		//Scanner 생성 구문 작성
		Scanner sc =new Scanner(System.in);
		/* new : Heap 메모리영역에 새 객체 생성
		 * new Scanner() :Heap 메모리영역에 Scanner 객체 생성
		 * System.in :지정된 입력장치(이클립스에선 기본값이 키보드)
		 * */
		System.out.print("정수 입력 :");
		int num1 =sc.nextInt();	//입력 버퍼에서 다음 정수 읽어오기 
//		-> 정수가 아닌 다른값이 입력되면 예외(Exception)이가 발생 
		System.out.println("입력 받은 num1 :"+num1);
//		* java.util.InputMismatchException -> 입력 자료형이 맞지않음 예외
		System.out.print("정수 입력 :");
		int num2 =sc.nextInt();
		System.out.println("입력 받은 num2 :"+num2);
		System.out.println("num1 + num2 ="+(num1+num2));
		sc.close();
	}
}
