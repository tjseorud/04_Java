package service;

import java.util.Random;

import dto.StudentDTO;
/**Service
 * 	-프로그램의 실질적인 기능(비즈니스 로직)을 제공하는 Class
 */
public class StudentService {
	private StudentDTO[] dtos =new StudentDTO[5];	//StudentDTO 객체 배열선언
	/*new StudentDTO[5] 
	 * -StudentDTO 참조형 변수 5칸짜리 배열생성
	 * -index :0-4
	 * -각 index 요소의 초기값 :null(참조 객체 없음)
	 */
	
	//기본 생성자
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨..]\n");
		dtos[0] =new StudentDTO("202500001", "짱구", '남');
		dtos[1] =new StudentDTO("202500002", "유리", '여');
		dtos[2] =new StudentDTO("202500003", "훈이", '남');
		
		Random random =new Random();	//자바 제공 난수발생 객체
		for(StudentDTO std : dtos) {	//향상된 for
			if(std ==null) {
				continue;
			}
			//random.nextInt(101) :0-101 미만의 정수형 난수생성
			std.setHtml(random.nextInt(101));	
			std.setCss(random.nextInt(101));	
			std.setJs(random.nextInt(101));	
			std.setJava(random.nextInt(101));	
		}
	}
	
	/**students 객체 배열을 반환하는 메서드
	 * (students에 저장된 주소가 복사되서 반환됨 == 얕은 복사)
	 * @return dtos
	 */
	public StudentDTO[] getDtos() {
		return dtos;
	}
	
	/**<pre>
	 * students 객체 배열 요소중
	 * 비어있는(null) index를 찾아 
	 * 전달받은 StudentDTO 객체를 추가 후 true 반환
	 * 단, 비어있는 index가 없으면 false 반환
	 * </pre>
	 * @param dto :추가하려는 학생객체 참조주소
	 * @return 추가 성공 :true/ 추가 실패 :false
	 */
	public boolean addStudent(StudentDTO dto) {
		for(int i=0; i<dtos.length; i++) {
			if(dtos[i] ==null) {
				//i번째 index요소가 참조하는게 없을경우
				//
				dtos[i] =dto;
				return true;	
			}
		}
		return false;	//
	}
	
	/**index번째 학생 반환 메서드
	 * @param index
	 * @return index 번째 학생객체 참조주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		//ArrayIndexOutOfBoundsException :배열 인덱스 범위초과
		//Index 10 out of bounds for length 5
		if(index<0 ||index >=dtos.length) {	//index가 배열범위를 벗어난 경우
			return null;
		}
		return dtos[index];
	}
	
	/**targetName과 이름이 일치하는 학생객체 반환 service 반환
	 * @param targetName
	 * @return 이름이 일치하는 학생 객체주소 || null
	 */
	public StudentDTO selectName(String targetName) {
		for(StudentDTO dto : dtos) {
			//students 순차접근중 null을 만났을때 == 학생이 없을경우
			if(dto ==null) {
				return null;
			}
			//학생이 있을경우 ->이름비교
			/*[key point]
			 * 비교 연산자(A == B)
			 * -A와 B에 저장된 값이 같으면 true, 다르면 false 반환
			 * 
			 * boolean A.equals(B)
			 *  -A가 참조하는 객체의 필드와 B가 참조하는 객체의 필드가 같은지 비교하여
			 *   같으면 true 다르면 false 반환
			 *   (객체가 가지고있는 실제값을 비교)
			 */
			if(dto.getName().equals(targetName)) {
				return dto;
				/*std.getName() ==targetName*/
				//참조형은 주소를 저장
				//생성된 객체는 기본적으로 서로 다른곳에서 생성된다
				//->저장된 이름과 입력된 이름이 같아도
			}
		}
		return null;	//if 가 하나도 실행되지 않은경우
	}
	
	/**전달받은 index가 students 범위 내 인덱스가 맞는지
	 * 맞다면 index 번째에 참조하는 
	 * 
	 * @param index
	 * @return 1:범위초과 /2:null /3:참조하는 학생있음
	 */
	public int checkIndex(int index) {
		if(index<0 ||index >=dtos.length) {
			return 1;
		}
		if(dtos[index] ==null) {
			return 2;
		}
		return 3;
	}
	
	/**index 번째 학생의 점수 수정 메서드
	 * @param index
	 * @param html
	 * @param css
	 * @param js
	 * @param java
	 */
	public void updateScore(int index,int html,int css,int js,int java) {
		dtos[index].setHtml(html);
		dtos[index].setCss(css);
		dtos[index].setJs(js);
		dtos[index].setJava(java);
		//반환형 void 메서드로 return; 작성이 필수 ->작성이 안되면 컴파일러가 추가
	}
	
	/**students 배열에서 점수 평균 최고,최저 학생찾기
	 * @return result(String)
	 */
	public String selectMaxMin() {
		//점수 평균 최고,최저 학생의 이름/평균 저장할 변수
		String maxName =null;
		String minName =null;
		double maxAvg =0.0;
		double minAvg =100.0;
		
		for(StudentDTO dto :dtos) {	//향상된 for
			if(dto ==null) {	//참조할 학생이 없는 경우
				break;
			}
			int sum =dto.getHtml()+dto.getCss()+dto.getJs()+dto.getJs()+dto.getJava();	//합계
			double avg =sum/4.0;	//평균
			
			if(avg >maxAvg) {
				maxAvg =avg;
				maxName =dto.getName();
			}
			if(avg <minAvg) {
				minAvg =avg;
				minName =dto.getName();
			}
		}
		String result =String.format("최고점 :%s(%.1f)\n"+"최저점 :%s(%.1f)",maxName,maxAvg,minName,minAvg);
		return result;
	}
	
	/**index 번째 학생 삭제 후 요소 한칸씩 당기기
	 * @param index :삭제할 index 번호
	 * @return studentName :삭제된 학생 이름
	 */
	public String delectStudent(int index) {
		String studentName =dtos[index].getName();	//삭제할 학생이름(삭제전 이름만 백업)
		
		dtos[index] =null;
		
		for(int i=index; i<dtos.length-1; i++) {	//삭제된 index 뒤에 요소 하나씩 당기기
			dtos[i] =dtos[i+1];
		}
		dtos[dtos.length-1] =null;	//마지막 index에 null 대입
		return studentName;
	}
}