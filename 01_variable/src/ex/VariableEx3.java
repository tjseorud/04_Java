package ex;

public class VariableEx3 {
	public static void main(String[] args) {
		/* --- 강제 형변환 ---
		 * 1. 값의 범위가 큰 자료형 -> 작은 자료형으로 변환(데이터 손실을 고려해야함)
		 * 2. 의도적으로 자료형을 변환할 때 ex)(double)int -> double
		 * [작성법]
		 * (자료형)변수명/값;
		 * */
		System.out.println("[강제 형변환 예제1 - 데이터 손실]");
		int num1 =290;
		byte result1 =(byte)num1;	//byte 강제 형변환
		System.out.println("num1 :"+num1);	//290
		System.out.println("result1 :"+result1);	//34
		
		System.out.println("[강제 형변환 예제2 - 데이터 손실]");
		// 실수 -> 정수로 강제 형변환 -> 소수점 버림 처리
		double num2 =123.999;
		int result2 =(int)num2;	//int 강제 형변환
		System.out.println("num2 :"+num2);
		System.out.println("result2 :"+result2);
		
		System.out.println("[강제 형변환 예제3 - 데이터 손실]");
		//난수를 정수로 반환 받기
		// 1-10 사이 정수형 난수
		// JS :Math.floor(Math.random() *10 +1)
		// Java : (int)(Math.random() *10 +1)
		
		for(int i=0;i<5;i++) {
			// Math.random() : 0.0 이상 1.0 미만 double형 난수 반환
			int randomNumber =(int)(Math.random()*10+1);
			System.out.println("randomNumber :"+randomNumber);
		}
		
		System.out.println("[의도적 자료형 변환1]");
		int a3 =5;
		int b3 =2;
		System.out.println(a3/b3);	//int /int =int ==2
		System.out.println((double)a3/(double)b3);	//(double)int /(double)int -> double /double =double ==2.5
		System.out.println((double)a3/b3);	//(double)int /int -> double /int -> double /double =double ==2.5 //강제 -> 자동
		
		System.out.println("[의도적 자료형 변환2]");
		System.out.println("문자열(char) <-> 유니코드(int)");
		System.out.println("A의 유니코드 번호 :"+(int)'A');
		System.out.println("A뒤에 10번째 문자 :"+(char)('A'+10));
	}
}
