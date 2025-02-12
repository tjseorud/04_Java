package section04;

/*interface
 * -상속받은 클래스간의 접점을 만듦(비슷한 형태를 지니게 만듦)
 * -상수형 필드(public static final)만 작성가능
 * -추상 메서드(public abstract) 또는 default 메서드만 작성가능
 */
public interface Animal {
	/*추상 메서드
	 * -메서드 정의 부분이 없는 미완성 메서드
	 * -상속받은 자식이 무조건 재정의 해야함(오버라이딩 강제화)
	 */
	public abstract void move();
	void eat();	//public abstract 생략 OK
}