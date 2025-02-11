package section04.service;

import java.util.Scanner;

import section04.exception.MyTestException;
import section04.exception.NegativeQuantityException;

public class UserDefineExeptionService {
	Scanner sc =new Scanner(System.in);
	
	public void test1() {
		System.out.println("-- 두 정수를 입력받아 곱한 값을 출력 --");
		System.out.print("정수 1 >>");
		int num1 =sc.nextInt();
		
		System.out.print("정수 2 >>");
		int num2 =sc.nextInt();
		
		//곱했을때 결과가 음수이면 예외 발생
		try {
			int result =num1*num2;
			
			if(result <0) {
//				throw new Exception(); //->현재 상황에 맞는 예외가 없음
//				throw new NegativeQuantityException();
				throw new NegativeQuantityException("음수를 곱한 결과가 -가 나옴");
			}
			System.out.println("결과 :"+result);
		}catch(NegativeQuantityException e) {
			System.out.println(e.getMessage()); //예외 메시지만 출력
			e.printStackTrace(); //예외가 발생한 지점까지의 메서드 호출 상황을 출력하는 메서드
		}finally {
			System.out.println("*** exit ***");
		}
	}
	public void test2() {
		throw new MyTestException();	//강제발생
		//컴파일 에러발생 O ->CheckedException
		//컴파일 에러발생 X ->UncheckedException
	}
}