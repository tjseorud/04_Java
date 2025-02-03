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
	//생성자 없음 -> 컴파일러가 기본 생성자 자동추가
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
			System.out.println("6. 학생 1명 점수 조회(인덱스/점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("8. 학생 삭제(인덱스)");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			input =scan.nextInt();
			scan.nextLine();	//입력버퍼에 남은 내용 모두제거
			
			switch (input) {
				case 1: addStudent(); break;
				case 2: allStudent(); break;
				case 3: selectIndex(); break;
				case 4: selectName(); break;
				case 5: updateIndex(); break;
				case 6: selectScore(); break;
				case 7: selectMaxMin(); break;
				case 8: delectStudent(); break;
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
		System.out.println("\n--- 학생 전체 조회 ---");
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
	
	/**학생 추가
	 * <pre>
	 * 학번,이름,성별을 입력받아 Student 객체로 만들어서 
	 * StudentService.addStudent() 메서드에 전달
	 * 	->추가 성공시 true 실패시 false 반환받아 결과 출력
	 * </pre>
	 */
	private void addStudent() {
		System.out.println("\n--- 학생 추가 ---");		
		System.out.print("학번 :");
		String studentNumber =scan.next();
		
		System.out.print("이름 :");
		String name =scan.next();
		
		System.out.print("성별 :");
		char gender =scan.next().charAt(0);
		
		StudentDTO dto =new StudentDTO(studentNumber, name, gender);
		//생성된 StudentDTO 객체를 StudentService.addStudent() 메서드에 전달 ->true/false 반환 예정
		boolean result = service.addStudent(dto);
		
		if(result) {
			System.out.println(name+"학생이 추가 되었습니다.");
		}else {
			System.out.println("더 이상 학생을 추가할 수 없습니다.");
		}
	}
	
	/**학생 1명 정보 조회(인덱스)
	 * <pre>
	 * index를 입력받아
	 * StudentService.selectIndex()로 전달
	 *  -학생 객체배열에서 해당 index 번째 학생을 반환받기
	 *  -반환받은 학생정보를 출력
	 *   단, 반환받은 학생이 없을경우(null)
	 *   "해당 index에 학생이 존재하지 않습니다"를 출력
	 * </pre>
	 */
	private void selectIndex() {
		System.out.println("\n--- 학생 1명 정보 조회(인덱스) ---");
		System.out.print("조회할 인덱스 입력 :");
		int index =scan.nextInt();
		//service.selectIndex()로 index 전달
		StudentDTO dto = service.selectIndex(index);
		
		if(dto ==null) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
		}else {
			System.out.println(index+"번째 학생 정보");
			System.out.println(dto.toString());
		}
	}
	
	/**학생 이름으로 조회(동명이인 X)
	 * <pre>
	 * 이름을 입력받아
	 * StudentDTO StudentService.selectName(String name)호출
	 * 반환형				클래스명.메서드명(매개변수)
	 *  -학생정보 반환받아서 출력
	 *   단, 반환받은 학생이 없을경우(null)
	 *   "00학생이 존재하지 않습니다"를 출력
	 * </pre>
	 */
	private void selectName() {
		System.out.println("\n--- 학생 이름으로 조회(동명이인 X) ---");
		System.out.print("검색할 학생 이름 입력 :");
		String targetName =scan.next();
		
		StudentDTO dto =service.selectName(targetName);
		
		if(dto ==null) {
			System.out.println(targetName+"학생이 존재하지 않습니다");
		}else {
			System.out.println(dto.toString());
		}
	}
	
	/**학생 정보 수정(인덱스)
	 * <pre>
	 * -인덱스 번호를 입력받아 해당 인덱스에 학생이 있는지 확인
	 *  1)범위초과 :"인덱스 범위가 올바르지 않습니다"
	 *  2)참조하는 학생이 없을경우 :"해당 인덱스에 학생이 존재하지 않습니다"
	 * 출력
	 * 
	 * -입력받은 인덱스에 학생이 있을경우
	 * HTML, CSS, JS, Java점수를 순서대로 입력받은 후
	 * void StudentService.updateIndex(index,점수들..) 호출
	 * </pre>
	 */
	private void updateIndex() {
		System.out.println("\n--- 학생 정보 수정(인덱스) ---");
		System.out.print("수정할 학생 인덱스 번호 입력 :");
		int index =scan.nextInt();
		int check =service.checkIndex(index);	//인덱스 범위,학생참조여부 확인 메서드 호출
		
		if(check ==1) {
			System.out.println("인덱스 범위가 올바르지 않습니다");
		}
		if(check ==2) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
		}
		//정상 index인 경우
		System.out.print("HTML, CSS, JS, Java 순서로 점수입력 :");
		int html =scan.nextInt();
		int css =scan.nextInt();
		int js =scan.nextInt();
		int java =scan.nextInt();
		/*scan.next()/scan.nextInt()
		 * -띄어쓰기/엔터 입력 전까지만 인식
		 */
		service.updateScore(index,html,css,js,java);	//반환형 void
		
		System.out.println("*** 점수 수정 완료 ***");
		
	}
	
	/**학생 1명 점수 조회(인덱스/점수, 합계, 평균)
	 * <pre>
	 * -인덱스 번호를 입력받아 해당 인덱스에 학생이 있는지 확인
	 *  1)범위초과 :"인덱스 범위가 올바르지 않습니다"
	 *  2)참조하는 학생이 없을경우 :"해당 인덱스에 학생이 존재하지 않습니다"
	 * 출력
	 * 
	 * -인덱스가 정상 입력되었다면
	 * 	해당 인덱스 번째 학생(StudentDTO)을 반환 받기
	 * -합계,평균 구하기
	 * -아래와 같은 형식으로 출력
	 * ---------------------------------------------
	 * [202500001] 짱구(남) 
	 * HTML :10 / CSS :20 / JS :30 / Java :40
	 * 합계 :100
	 * 평균 :25.0
	 * ---------------------------------------------
	 * </pre>
	 */
	private void selectScore() {
		System.out.println("\n--- 학생 1명 점수 조회(인덱스/점수, 합계, 평균) ---");
		System.out.print("점수를 조회할 인덱스 입력 :");
		int index =scan.nextInt();
		int check =service.checkIndex(index);	//인덱스 범위,학생참조여부 확인 메서드 호출
		
		if(check ==1) {
			System.out.println("인덱스 범위가 올바르지 않습니다");
		}
		if(check ==2) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
		}
		StudentDTO dto =service.selectIndex(index);		
		int sum =dto.getHtml()+dto.getCss()+dto.getJs()+dto.getJs()+dto.getJava();
		double avg =sum/4.0;
		
		System.out.println("---------------------------------------------");
		System.out.println(dto.toString());
		System.out.println("합계 :"+sum);
		System.out.printf("평균 :%.1f\n",avg);
		System.out.println("---------------------------------------------");
	}
	
	/**평균 최고점, 최저점 학생
	 * <pre>
	 * String StudentService.selectMaxMin() 메서드 호출하여
	 * 아래와 같은 문자열을 반환받아 출력하기
	 * ----------------
	 * 최고점 :유리(85.4)
	 * 최저점 :훈이(31.6)
	 * ----------------
	 * </pre>
	 */
	private void selectMaxMin() {
		System.out.println("\n--- 평균 최고점, 최저점 학생 ---");	
		String result =service.selectMaxMin();
		System.out.println("----------------");
		System.out.println(result);
		System.out.println("----------------");
	}
	
	/**학생 삭제(인덱스)
	 * -index 입력받아 검사(범위초과,null 검사)
	 * -정말 삭제할지 확인절차 추가 ->"정말로 삭제 하시겠습니까(Y/N) :"
	 * -'N'입력시 "취소 되었습니다" 출력후 return;
	 * -'Y'입력시 
	 *  1)students 배열에서 입력받은 index 번째 요소를 null로 변경
	 *  2)삭제된 index 뒤에 요소를 하나씩 당겨오기
	 *  3)"삭제 되었습니다" 출력후 return;
	 */
	private void delectStudent() {
		System.out.println("\n--- 학생 삭제(인덱스) ---");
		System.out.print("삭제할 인덱스 입력 :");
		int index =scan.nextInt();
		int check =service.checkIndex(index);	//인덱스 범위,학생참조여부 확인 메서드 호출
		
		if(check ==1) {
			System.out.println("인덱스 범위가 올바르지 않습니다");
		}
		if(check ==2) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
		}
		
		System.out.print("정말로 삭제 하시겠습니까?(Y/N) :");
		char input =scan.next().charAt(0);		
//		String input =scan.next();		
//		if(input.equals("N") ||input.equals("n")) {}
		if(input =='N' ||input =='n') {
			System.out.println("취소 되었습니다");
			return;
		}
		if(input =='Y' ||input =='y') {		
			String studentName =service.delectStudent(index);
			System.out.println(studentName+" 학생이 삭제 되었습니다");
			return;
		}		
	}
}