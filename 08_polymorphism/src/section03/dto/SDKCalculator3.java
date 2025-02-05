package section03.dto;

/**implements(구현하다) -인터페이스 상속 키워드
 */
/*클래스가 다중상속 불가 이유 
 * -상속받은 같은이름의 필드/메서드 호출시 어떤 부모로부터 상속 받았는지 알 수 없기때문에
 *  (클래스 상속은 무조건 완성된 메서드를 상속받는다고 가정)
 */
/*인터페이스 다중 상속 확인
 * -다중상속 가능(개수제한 없음)
 * -인터페이스의 메서드는 default 메서드를 제외한 모든 추상메서드(미완성 메서드)
 * 	->상속받은 자식이 재정의(오버라이딩) 해야 사용가능
 * 
 * -미완성된 메서드는 이름이 같아도 하나만 구현하면 오류없이 사용가능
 *  단, default 메서드는 중복 X
 */
public class SDKCalculator3 implements Calculator, Machine {

	@Override
	public void powerOn() {
		
	}
	@Override
	public void powerOff() {
		
	}
	@Override
	public int plus(int a, int b) {
		return 0;
	}
	@Override
	public int minus(int a, int b) {
		return 0;
	}
	@Override
	public int multi(int a, int b) {
		return 0;
	}
	@Override
	public double div(int a, int b) {
		return 0;
	}
	@Override
	public int mod(int a, int b) {
		return 0;
	}
	@Override
	public int pow(int a, int x) {
		return 0;
	}
	@Override
	public double areaOfCircle(double r) {
		return 0;
	}
}