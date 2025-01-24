package view;

import java.util.Scanner;

import dto.StudentDTO;
import service.StudentService;
/**View
 * 	-보여지는 용도의 기능(입력/출력)을 담당하는 Class
 */
public class StudentView {
	private Scanner scan =new Scanner(System.in);	//입력용 객체생성
	private StudentService service =new StudentService();	//기능 제공용 객체생성	
	/**학생관리 프로그램의 메인메뉴 출력용 메서드
	 */
	public void mainMenu() {
		int input =0;	// 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			input =scan.nextInt();
			scan.nextLine();	//입력버퍼에 남은 내용 모두제거
			
			switch (input) {
			case 1: break;
			case 2: allStudent(); break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 7: break;
			case 0: System.out.println("*** 프로그램 종료 ***"); break;
			default: System.out.println("* 잘못된 메뉴번호를 입력했습니다"); break;
			}
		}while(input !=0);
		scan.close();
	}
	//private 메서드 : 객체 내부에서만 사용되는 기능
	/**학생 전체 조회
	 */
	private void allStudent() {	
		System.out.println("\n--- 학생 전체 조회 ---\n");
		// StudentService 객체에서 모든학생을 저장한 객체 배열을 얻어와 화면에 출력
		
		StudentDTO[] dtos =service.getDtos();
		
		//향상된 for
		for(StudentDTO std :dtos) {
			if(std ==null) {	//null.toString() ->오류 구문 수행전 검증
				continue;
			}
			/* 참조변수를 문자열만들 때 또는 print() 관련 메서드에 사용될 때
			 * 참조 변수에 저장된 주소가 출력되면 이상하니까 컴파일러가 자동으로 참조변수.toString()을 호출하도록 변경
			 */
			System.out.println(std);	//std.toString()
		}
		
	}
}