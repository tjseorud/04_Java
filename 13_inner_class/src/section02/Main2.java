package section02;

import section02.OuterClass2.StaticInnerClass;

public class Main2 {
	public static void main(String[] args) {
		/*인스턴스 내부 클래스 생성 방법*/
//		OuterClass2 outer =new OuterClass2();
//		OuterClass2.StaticInnerClass inner =outer.new StaticInnerClass();
		/*정적 내부 클래스 생성 방법
		 * -외부 인스턴스 생성없이 바로 내부 클래스 이용가능
		 */
		OuterClass2.StaticInnerClass inner =new OuterClass2.StaticInnerClass();
		inner.display();
//		inner.staticDisplay();	//참조변수를 이용한 static 호출은 권장 X
		OuterClass2.StaticInnerClass.staticDisplay();
	}
}