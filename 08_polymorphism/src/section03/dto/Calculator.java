package section03.dto;

/*[interface(인터페이스)] -접점
 * ex)UI(User Interface) :화면 ->화면을 통해서 프로그맬과 사용자가 접촉(화면이 접점의 역할)
 * -객체지향 프로그래밍에서는 객체간의 접점을 만드는 용도로 사용
 * 
 * -효과
 *  1)클래스/객체간에 접점을 만들수있다
 *  2)극한의 추상화를 통해 유연한 코딩이 가능하다
 *  3)상속받은 자식클래스가 모두 같은형태를 갖는다
 *  
 *  [참고]
 *  대부분의 인터페이스를 상속받은 클래스는 인터페이스에서 제공하는 메서드만 오버라이딩하고 
 *  별도의 필드/메소드를 작성하지 않는다 (약속,규약) ->? 언제든지 동일한 코드로 실행할수 있게하려고
 *  
 * -작성법([]는 생략가능)
 *  1)상수형 필드만 작성가능 
 *  	->[public static final] 자료형 변수명;
 *  2)기본적으로 모든메소드는 추상메소드 
 *  	->[public abstract] 반환형 메서드명();
 *  3)default 메서드 작성가능(오버라이딩 OK)
 *  	->default void 메서드명(){}
 *  
 *  -사용법
 *   1)해당 인터페이스를 상속받을 클래스에 implements(구현하다) 키워드를 작성
 *   	->public class 클래스명 implements 인터페이스명{}
 *   2)상속받은 추상메서드를 모두 오버라이딩(재정의)
 *   3)상속받은클래스를 객체로 만들어 사용 
 *    ->사용방법은 추상클래스와 동일
 *    1. 인터페이스는 객체 생성불가
 *    2. 부모타입 참조변수로는 사용가능
 */
/**Calculator interface
 * -객체생성 용도 X, 클래스/객체간의 접점용도 O
 */
public interface Calculator {
	/*필드는 public static final만 작성가능*/
	public static final int MAX_NUM =1_000_000_000;
	//public static final 생략가능 ->자동추가
	int MIN_NUM =-1_000_000_000;
	double PI =3.141592;
	/*기본적으로 추상메소드만 작성가능
	 * ->추상메서드에서 상속받은 자식클래스에서 재정의가 강제됨
	 */
	/**두 수의 합을 반환
	 * 단, 결과는 최대,최소값을 넘을수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	public abstract int plus(int a, int b);
	/**두 수의 차을 반환
	 * 단, 결과는 최대,최소값을 넘을수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int minus(int a, int b);	//public abstract 생략 가능
	/**두 수의 곱을 반환
	 * 단, 결과는 최대,최소값을 넘을수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int multi(int a, int b);
	/**두 수를 나눈 몫을 반환
	 * 단, 결과는 최대,최소값을 넘을수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	double div(int a, int b);
	/**두 수를 나눈 나머지를 반환
	 * 단, 결과는 최대,최소값을 넘을수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int mod(int a, int b);
	/**a를 x만큼 거듭 제곱한 결과를 반환
	 * 단, 결과는 최대,최소값을 넘을수 없음
	 * @param a
	 * @param x
	 * @return 결과
	 */
	int pow(int a, int x);
	/**원의 넓이를 반환
	 * 단, 결과는 최대,최소값을 넘을수 없음
	 * @param r
	 * @return 결과
	 */
	double areaOfCircle(double r);
	
	//default method
	/**전달받은 num이 최대/최소를 초과하는지 확인
	 *  -최대값 초과시 MAX_NUM return
	 *  -최소값 미만시 MIN_NUM return
	 *  -범위내 값은 그냥 return
	 * @param num
	 * @return
	 */
	default int checkNum(int num) {
		if(num >MAX_NUM)return MAX_NUM;
		if(num <MIN_NUM)return MIN_NUM;
		return num;
	}
	default double checkDNum(double num) {
		if(num >MAX_NUM)return MAX_NUM;
		if(num <MIN_NUM)return MIN_NUM;
		return num;
	}
}