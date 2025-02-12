package section02;

public class OuterClass2 {
	private int outerInstanceNum =100;	//인스턴스 변수
	private static int outerStaticNum =20;	//클래스 변수
	
	/*정적(static) 내부 클래스 정의*/
	public static class StaticInnerClass{
		public int innerInstanceNum =300;	//내부 클래스의 인스턴스 변수
		public static int innerStaticNum =50;	//내부 클래스의 클래스 변수
		
		public void display() {
			System.out.println("inner class dispaly() method");
//			System.out.println("outerInstanceNum :"+outerInstanceNum); //Err -외부 클래스의 인스턴스 변수 호출 불가
			System.out.println("outerStaticNum :"+outerStaticNum); //외부 클래스의 static 변수 호출 가능 ->static 끼리는 OK
			System.out.println("innerInstanceNum :"+innerInstanceNum); //static 내부 클래스라도 ->non-static 끼리는 OK
			System.out.println("innerStaticNum :"+innerStaticNum); //내부 클래스의 static 변수 호출 가능 ->non-static 끼리는 OK
			
		}
		public static void staticDisplay() {
			System.out.println("inner class staticDisplay() method");
			System.out.println("outerStaticNum :"+outerStaticNum);	//외부 클래스 변수는 static 내부 클래스의 static 메서드에도 호출 가능
//			System.out.println("innerInstanceNum :"+innerInstanceNum);	//Err -non-static 멤버변수 호출 불가
			System.out.println("innerStaticNum :"+innerStaticNum);	//
		}
		/*static() ->non-static 		 호출 X
		/*static() ->static			 		 호출 O
		/*non-static() ->non-static	 호출 O
		/*non-static() ->static			 호출 O
		 */
	}
}