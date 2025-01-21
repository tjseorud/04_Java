package common;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("[자기소개 문장 생성 프로그램]");
		System.out.print("이름 입력 :");
		String name =sc.next();	//문자열(단어) 읽어오기
		
		System.out.print("나이 입력 :");
		int age =sc.nextInt();
		
		System.out.print("키 입력(cm) :");
		double height =sc.nextDouble();	//실수 읽어오기
		
		System.out.print("성별(남/여) 입력 :");
		char gender =sc.next().charAt(0);	
		// Scanner에서 char 자료형을 읽어오는 방법 제공X -> 문자열을 읽어와 index[0] 문자 하나만 얻어오기
		//String.charAt(index) : String에서 index번째 문자하나 반환
		System.out.println("[자기소개 문장]");
		System.out.printf("제 이름은 %s 이고 나이는 %d세, 키는 %.1fcm인 %c성 입니다",name,age,height,gender);
		sc.close();
	}
}
