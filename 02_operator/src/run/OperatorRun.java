package run;
// 다른 패키지의 클래스를 가져오기 위해 import 구문작성
import ex.OperatorEx;

/**연산자 예제 실행용 class
 */
public class OperatorRun {
	public static void main(String[] args) {
		OperatorEx ex =new OperatorEx();	//가져온 OperatorEx class를 객체로 생성
		ex.test1();	//OperatorEx 객체가 가지고있는 test1() 메서드 호출
//		ex.test2(); //실행하고 싶지않으면 삭제나 주석처리
//		ex.method1();
//		ex.method2();
		ex.method3();
	}
}
