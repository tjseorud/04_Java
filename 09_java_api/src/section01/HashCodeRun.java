package section01;

public class HashCodeRun {
	public static void main(String[] args) {
		/*int Object.hashCode();
		 * -객체를 식별하는 값
		 * -객체 메모리주소를 이용해서 생성
		 * 
		 * hashCode() Overriding
		 *  -equals() 결과가 true인 경우 hashCode() 결과도 같도록 오버라이딩(공식 문서 참조)
		 *  -equals() 오버라이딩시 hashCode()도 오버라이딩하기 ->hashCode() 사용기능을 많이 제공
		 */
		Book book1 =new Book(2,"해리포터","J.K.롤링",8000);
		Book book2 =new Book(2,"해리포터","J.K.롤링",8000);
		System.out.println("book1.hashCode() :"+book1.hashCode());
		System.out.println("book2.hashCode() :"+book2.hashCode());
	}
}