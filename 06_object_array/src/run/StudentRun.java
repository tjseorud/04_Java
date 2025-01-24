package run;

import view.StudentView;

/**Run
 * 	-자바 프로그램 실행용 Class
 */
public class StudentRun {
	public static void main(String[] args) {
		new StudentView().mainMenu();	//객체를 1회용으로 사용하는 방법
		/*새로운 StudentView 객체가 생성 되자마자 mainMenu() 메서드를 호출
		 * 	-> mainMenu()가 종료되면 new StudentView()로 만들어진 객체가 소멸
		 * 	(왜? 참조하는 변수가 없어서 GC가 없애버림)
		 */ 
	}
}