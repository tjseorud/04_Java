package common;

public class PrintEx {
	public static void main(String[] args) {
		/* System.out == 지정된 출력용 화면(이클립스 콘솔)
		 * System.out.print(출력내용);
		 * 	- 출력 내용을 콘솔에 출력 후 줄바꿈 X
		 * System.out.println(출력내용);
		 * 	- 출력 내용을 콘솔에 출력 후 줄바꿈 (ln == line)
		 * System.out.printf("문자열 템플릿(패턴)",패턴에 대입될 값/변수...);
		 *  - 정해진 형식(템플릿)에 맞는 문자열을 출력
		 *  - 문자열 형식 중간에 "%"로 시작하는 패턴을 입력하며 원하는 변수/값을 대입할 수 있다
		 *  
		 *  [패턴 종류]
		 *  - %d (Decimal, 10진 정수)	:정수(byte, short, int, long)
		 *  - %c (Character, 문자)		:문자(char)
		 *  - %s (String, 문자열)			:문자열(String)
		 *  - %b (boolean, 논리형)		:논리형(boolean)
		 *  - %f (float, 실수)				:실수(float, double)
		 *  
		 *  -양의 정수 :정수 크기만큼 칸 확보 + 오른쪽 정렬 
		 *  	ex) "%4d",3 -> ㅁㅁㅁ3
		 *  -음의 정수 :정수 크기만큼 칸 확보 + 왼쪽 정렬 
		 *  	ex) "%-4d",3 -> 3ㅁㅁㅁ
		 *  -소수점 :소수점 아래 몇자리 표시할지 지정(지정된 자리 아래에서 반올림)
		 *  	ex) "%.1f",3.15 -> 3.2
		 * */
//		print()
		System.out.print("이름 :");		//줄바꿈 X
		System.out.print("홍길동");		//줄바꿈 X
		System.out.print(", 나이 : 20세");	//줄바꿈 X
//		println()
		System.out.println();	//출력 내용 없이 줄바꿈
		System.out.println();
		System.out.println();
		System.out.println("[println()]");
		
		String name ="신짱구";	//참조형(값 저장X, 값의 위치(주소) 저장)
		int age =5;						//4btye
		double height =80.5;	//8btye
		char gender ='남';			//2btye
		boolean javaStudy =false;	//1btye
//		println()
		System.out.println(name+"는 "+age+"세 "+gender+"아로 키는 "+height+"cm이며, 자바공부 여부 :"+javaStudy);
//		printf()
		System.out.printf("%s는 %d세 %c아로 키는 %.1fcm이며, 자바공부 여부 :%b",name,age,gender,height,javaStudy);
		
		//왼쪽 정렬
		System.out.println();	//개행(줄바꿈)
		System.out.printf("%-6s/%-6d",name,age);
		
		//오른쪽 정렬
		System.out.println();	//개행(줄바꿈)
		System.out.printf("%6s/%6d",name,age);
		
		//(참고)오른쪽 정렬	//0 == 빈칸에 0 추가(숫자만 가능)
		System.out.println();	//개행(줄바꿈)
		System.out.printf("%6s/%06d",name,age);
		
//		escape 문자
		/* - 문자열 내에서 \로 시작하는 특수 문자
		 * - \n OR \r OR \r\n :줄바꿈
		 * - \t 		:탭(tap)
		 * - \u0000 :유니코드
		 * - \\ 		:백슬래시 출력
		 * - \' OR \" :'," 기호 출력(리터럴 인식 X)*/
		System.out.println();
		System.out.println("[escape 문자]");
		System.out.print("1\t2\t3\n");
		System.out.print("\"홍길동\"자료형은 String\r");
		System.out.print("\\0/\n");
	}
}
