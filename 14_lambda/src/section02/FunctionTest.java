package section02;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class FunctionTest {
	public static void main(String[] args) {
		/*Function 계열
		 * -매개변수를 받아서 다른타입으로 변환(가공)하여 반환하는 함수형 인터페이스
		 * -R apply???(T) 메서드 제공
		 */
		//Function<T, R> :매개변수 T 전달, R 타입 반환
		Function<String, Integer> strLength =(str)-> str.length();
		System.out.println(strLength.apply("Function의 글자수"));
		
		//BiFunction<T, U, R> :T 와 U 를 전달받아 R 형태로 반환
		BiFunction<Integer, Integer, Double> divTwoNumber =(a,b)->(double)a/b;
		System.out.println("3/2 = "+divTwoNumber.apply(3, 2));
		System.out.println("77/2 = "+divTwoNumber.apply(77, 2));
		
		//IntToDoubleFunction :int를 받아서 double로 반환
		IntToDoubleFunction randomNumber =(range)->Math.random()*range;	//0 이상 range 미만 반환
		Set<Double> set =new HashSet<Double>();
		
		while (set.size() <10) {
			set.add(randomNumber.applyAsDouble(5));	//set에 저장된 객체수가 10미만이면 반복
		}
		//컬렉션(Set) + 람다식
		set.forEach(r ->System.out.println(r));
	}
}
