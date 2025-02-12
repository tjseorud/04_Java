package section01;

/*[함수형 인터페이스]
 * -람다식 사용을 위한 인터페이스
 * -추상 메서드 1개만 있는 메서드
 * 
 *[@FunctionalInterface] 어노테이션
 * -함수형 인터페이스 작성법이 맞는지 컴파일러에게 검증하라는 어노테이션(컴파일러용 주석)
 * 
 *람다식(또는 람다 표현식)
 * -메서드를 하나의 식으로 표현하는 익명 함수
 * -함수형 인터페이스를 구현하는데 사용
 * 
 *Java 제공 함수형 인터페이스
 * -java.util.function package에 존재
 * 
 * 1.Consumer<T> 		:매개변수를 소비,		매개변수 O, return X
 * 2.Supplier<T> 		:값만 제공,				매개변수 X, return O
 * 3.Function<T,R>	:T를 받고 R을 반환,	매개변수 O, return O
 * 4.Opertor<T>			:T를 받고 T반환,		매개변수 O, return O
 * 5.Predicate<T>		:T를 받고 T/F반환,	매개변수 O, return O
 * 
 *메서드 참조
 * -함수형 인터페이스를 람다식으로 표햔하는 것이 아닌 이미 존재하는 메서드를 참조시키는 방법
 * 
 * ex) Consumer<T> con =()->{}; (X)
 * 		 Consumer<T> con =ClassName::MethodName	(O)
 */
@FunctionalInterface
public interface Calculator {
	/**두 수의 합을 반환하는 메서드
	 * @param a
	 * @param b
	 */
 public abstract int sumTwoNumber(int a, int b);
// void method();	//Err
}

/*(참고) 자바에서는 람다식을 구현하는데 왜 인터페이스를 사용했을까?
 * -자바는 클래스 또는 인터페이스 내부에만 메서드 선언이 가능하다
 * -인터페이스는 오직 추상메서드만 작성가능하고 오버라이딩 강제화된다
 *  ->위 조건을 만족하는 것이 "인터페이스" 밖에 없음 
 *  +인터페이스는 여러 추상 메서드 작성이 가능하기 때문에
 *   @FunctionalInterface 
 * 
 * -Function 	:독립적으로 존재할 수 있는 기능
 * -Method	:객체가 가지고 있는 (Function)기능
 * */
