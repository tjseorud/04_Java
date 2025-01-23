package encapsulation;
/**Class :객체의 속성,기능을 정의한 문서(설계도)
 */
public class Person {	
	//private으로 필드 직접 접근제어
//	private String name;
	private String personName;
	private double height;
	
	/**private으로 접근이 제한된 필드를 간접 접근할 수 있는 public method
	 * @param String name
	 */
	public void setName(String name) {
//		this.name =name;
		this.personName =name;
	}
	
	/**private으로 접근이 제한된 필드를 간접 접근할 수 있는 public method
	 * @param double height
	 */
	public void setHeight(double height) {
		if(height>=0) {
			this.height =height;
		}else {
			this.height =height*-1;	//음수*음수=양수
		}
	}
	
	/**Person의 객체정보를 하나의 문자열로 반환하는 메서드
	 * @return
	 */
	public String getInfo() {
//		return "이름 :"+name+" / 키 :"+height;
		return "이름 :"+personName+" / 키 :"+height;
	}
}