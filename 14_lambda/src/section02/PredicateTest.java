package section02;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		/*Predicate 계열
		 * -매개변수를 전달받아 boolean 값을 반환하는 함수영 인터페이스
		 *  ->조건식 결과 반환으로 자주 사용
		 * -test() 메서드 제공
		 */
		//Predicate<T> : T를 전달받아 boolean 반환
		Predicate<Integer> ageLimit =(age)->{
			if(age <0 ||age>100) { return false; }
			return age >=20;
		};
		if(ageLimit.test(17)) {	//17은 0-100사이 정수이면서 20 이상인 경우
			System.out.println("성인 입니다");
		}else {
			System.out.println("성인이 아니거나 잘못 입력");
		}
		
		//BiPredicate<T, U> :매개변수 T,U 전달받아 boolean 반환
		BiPredicate<String, String> stringLengthCompare =(str1,str2)->str1.length() >str2.length();
		//str1이 str2보다 길면 true
		String str1 ="Hello World!";
		String str2 ="Show me the money";
		String result =stringLengthCompare.test(str1, str2)? str1 :str2;
		
		System.out.println(result+"(이)가 더 긴 문자열");
	}
}
