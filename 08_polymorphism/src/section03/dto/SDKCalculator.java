package section03.dto;

/**Calculator 인터페이스 구현체
 * -모든 인터페이스 구현체는 같은형태를 띄고있음
 */
public class SDKCalculator implements Calculator {

	@Override
	public int plus(int a, int b) {
		return checkNum(a+b);
	}
	@Override
	public int minus(int a, int b) {
		return checkNum(a-b);
	}
	@Override
	public int multi(int a, int b) {
		return checkNum(a*b);
	}
	@Override
	public double div(int a, int b) {
		return checkDNum(a/b);
	}
	@Override
	public int mod(int a, int b) {
		return checkNum(a%b);
	}
	@Override
	public int pow(int a, int x) {
//		int temp =1;
//		for(int i=0; i<x; i++) {
//			temp *=a;
//		}
//		return checkNum(temp);
		//Math.pow 이용
		return checkNum((int)Math.pow(a, x));
	}
	@Override
	public double areaOfCircle(double r) {
		return checkDNum(r*r*PI);
	}
}