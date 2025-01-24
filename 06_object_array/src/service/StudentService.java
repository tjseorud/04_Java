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
		for(StudentDTO std : dtos) {
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
	
	/**dtos 객체 배열을 반환하는 메서드
	 * (dtos에 저장된 주소가 복사되서 반환됨 == 얕은 복사)
	 * @return dtos
	 */
	public StudentDTO[] getDtos() {
		return dtos;
	}
}