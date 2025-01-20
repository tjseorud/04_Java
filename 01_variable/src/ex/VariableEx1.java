package ex;	// 현재 클래스 파일이 저장된 경로
/* Java는 소문자, Camel Case 사용
 * 단, 클래스명은 대문자로 시작
 */
public class VariableEx1 {
	/**[main method]
	 * 자바 프로그램을 실행 시키기 위한 구문 */
	public static void main(String[] args) {
		System.out.println("[Java 변수와 자료형]");
		/* 변수 : 메모리에 값을 저장하는 공간 + 해당 공간에 저장 할 수 있는 값을 바꿀 수 있음 */ 
		
		/* * Java는 JS와 다르게
		 * 	처음부터 변수의 자료형을 지정해야한다
		 * 
		 * * 1byte == 8bit
		 * 	-> 컴퓨터가 테이터를 처리(연산)을 위한 최소 단위 */ 
		
		/* [Java 기본 자료형 8가지]
		 * - 논리형 
		 * 	boolean(1byte) - true/false
		 * 
		 * - 정수형 : -1, 0, 1(양수/음수/0)
		 * 	byte	(1byte)
		 * 	short	(2byte)
		 * 	int		(4byte, 정수 기본형)
		 * 	long	(8byte) -> 숫자 뒤에 L또는 l을 붙임(L,l의 Long의 리터럴)
		 * 
		 * - 실수형 
		 * 	float	(4byte)	-> 숫자뒤에 F 또는 f를 붙임
		 * 	double	(8byte, 실수 기본형) 
		 * 	
		 * - 문자열
		 * 	char	(2byte) : '문자 하나'를 지정하는 유니코드를 저장함
		 * */
		// 변수 선언	
		int num1;	// 메모리에 int형 정수를 저장공간 4byte를 할당하고 해당공간의 이름을 num1으로 지정
		// * int형 정수 : -21.47억 - +21.47억
		
		/* Java 지역변수는 초기화를 하지 않은 경우 -> 출력, 연산 불가(단, 대입 연산은 제외) */
		// The local variable num1 may not have been initialized
//		System.out.println(num1);	
		num1 =200;
		System.out.println("num1 : "+num1);
//		sysout -> Ctrl+Space -> Enter : println() snippet
		System.out.println("[자료형별 리터럴 작성법]");
		// 논리형(boolean, 1byte)
		boolean bool1 =true;
		boolean bool2 =false;
		System.out.println("--- 논리형 ---");
		System.out.println("bool1 : "+bool1);
		System.out.println("bool2 : "+bool2);
		
		if(bool1 && !bool2) {
			System.out.println("this print?");
		}
		// 정수형 : byte(1), short(2), int(4), long(8)
		System.out.println("--- 정수형 ---");
		int intNum1 =2147483647;	// int max 값
//		int intNum2 =2147483648;	// int 범위 초과한 값을 대입 불가 -> 정수형 중에서 범위가 더큰 long 사용!
		
		// 2147483648 <- 일반 정수 표기법 == int로 인식
		// 2147483648L OR 2147483648l == long으로 인식
		long longNum1 =2147483648L;	
		
		// 자릿수 구분용으로 _ 사용가능
		long longNum2 =30_000_000_000L;	//300억
		System.out.println("intNum1 : "+intNum1);
		System.out.println("longNum1 : "+longNum1);
		System.out.println("longNum2 : "+longNum2);
		//출력 결과에 리터럴 표기법 L,l 포함 X
		//코드상에서만 리터럴을 이용해 자료형 구분
		
		// byte, short : 다른 언어(C언어)와 호환을 위해 남겨진 자료형
		// -> 별도의 리터럴 표기법 X 
		// -> 초기화시 int 타입 표기법 사용
		byte byteNum =100;
		short shortNum =20000;
		
		//[실수형]
		System.out.println("--- 실수형 ---");
		//일반적인 술수 표기법(1.23) == double 표기법
		// float : F 또는 f를 뒤에 붙임
		float floatNum =1.123456789f;	//floatNum	:1.1234568
		double doubleNum =1.123456789;	//doubleNum	:1.123456789
		System.out.println("floatNum : "+floatNum);		//float는 소수점 아래 8번째 자리에서 반올림
		System.out.println("doubleNum : "+doubleNum);	//double은 소수점 아래 16번째 자리에서 반올림
		// 소수점 아래를 더 많이 표현 == 정확도 더 높음 == 실수 기본형으로 채택
		
		//문자형(char, 2byte) : 리터럴 표기법('')
		System.out.println("--- 문자형 ---");
		/* 문자형은 실제로는 정수(유니코드)를 저장 == 문자형이지만 정수형으로 취급 */
		char ch1 ='A';	//유니코드 65('\u0041')
		char ch2 ='가';
		char ch3 ='宣';
		char ch4 ='★';
		System.out.println("ch1 : "+ch1);
		System.out.printf("%c,%d,%x \n",ch1,(int)ch1,(int)ch1);
		/* %c	:문자형
		 * %d	:10진수 정수형
		 * %x	:16진수 정수형
		 * (int)ch1 : ch1의 자료형을 int로 변환 */
		System.out.println("ch2 : "+ch2);
		System.out.println("ch3 : "+ch3);
		System.out.println("ch4 : "+ch4);
		
		/* 문자열(String, 4byte 또는 8byte)
		 * - 값이 아닌 주소를 저장하는 "참조 자료형(참조형)" 
		 * - 리터럴 표기법 : ""
		 * - String은 몇 글자가 작성 될지 모르기 때문에 기본적으로 크기가 정해져있는 "기본 자료형"에 포함 되지 않는다 
		 * - 대신 다른곳에 문자열이 byte[]모양으로 만들고 해당 배열의 주소를 참조하는 "참조형"이 된다
		 * */
		String str1 ="A"; 
		String str2 ="AB"; 
		String str3 ="ABC"; 
		String str4 ="ABCD"; 
		System.out.println("str1 : "+str1);
		System.out.println(System.identityHashCode(str1));	//hashCode : 주소 비슷한 무언가 -> 주소가 다르면 같은 결과 X
		System.out.println("str2 : "+str2);
		System.out.println(System.identityHashCode(str2));
	}
}