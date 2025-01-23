package service;

import java.util.Scanner;

public class ArrayService1 {
	/*Array(배열)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * - 생성시 Heep 메모리 영역에 할당
	 * - 주소를 참조해서 배열요소 접근가능
	 */
	
	/**Java에서 배열 선언, 할당, 초기화하는 방법
	 */
	public void method1() {
		/*(참고)
		 * int num; : int 자료형을 저장하기 위한 공간을 메모리에 할당하고 해당공간의 이름을 "num"으로 지정
		 *  -> 실제 값을 저장가능(실제 값을 저장할 수 있는 자료형은 기본자료형 밖에 없다)
		 */
		int[]arr;	//OR int arr[];	//선언
		/* - int[] 자료형을 저장하기 위한 공간(변수)을 메모리에 할당하고 해당공간의 이름을 "arr"으로 지정
		 * 	-> 배열이 존재하는 주소(위치) 저장가능()
		 */
		arr =new int[4];	//할당
		//Heep 메모리영역에 생성된 int 4칸짜리 배열의 시작주소를 arr 참조형 변수에 대입
		/* new : Heep 메모리영역에 객체/배열을 할당(생성)하는 연산자
		 * 	-> 생성완료 후 생성된 객체/배열의 시작주소를 반환
		 * 
		 * int[4] : int형 변수 4개 묶인 배열할당
		 * 	-> Heep 메모리영역은 빈칸으로 존재불가
		 * 	-> JVM이 자료형별 기본값(0)으로 초기화
		 */		
		System.out.println("arr[0] :"+arr[0]);
		System.out.println("arr[1] :"+arr[1]);
		System.out.println("arr[2] :"+arr[2]);
		System.out.println("arr[3] :"+arr[3]);
		
		//1)
		arr[0] =10;
		arr[1] =20;
		arr[2] =30;
		arr[3] =40;
		System.out.println("arr[0] :"+arr[0]);
		System.out.println("arr[1] :"+arr[1]);
		System.out.println("arr[2] :"+arr[2]);
		System.out.println("arr[3] :"+arr[3]);
		
		//2)for
		for(int i=0; i<arr.length; i++	) {
			arr[i] =(i+1)*100;
		}
		System.out.println("arr[0] :"+arr[0]);
		System.out.println("arr[1] :"+arr[1]);
		System.out.println("arr[2] :"+arr[2]);
		System.out.println("arr[3] :"+arr[3]);
	}
	
	/**선언과 동시에 할당 + 초기화
	 */
	public void method2() {
		//JS -> const arr =[10,20,30];
		int arr[]	= {10,20,30};	//Java는 {}
		
		/* Java 향상된 for */
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	/**오늘의 점심메뉴 뽑기
	 */
	public void method3() {
		String[] menus = {"순대국","닭갈비","마라탕","햄버거","짜장면","짬뽕","샐러드"};
		
		int randomNumber =(int)(Math.random()*menus.length);
		System.out.println("오늘의 점심메뉴는 :"+menus[randomNumber]);
	}
	
	/**Java Array 사용시 주의할점
	 */
	public void method4() {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("[입력받은 정수를 각 배열에 저장, 출력]");
		long[] arr =new long[3];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d] 값 입력 :",i);
			arr[i] =scan.nextLong();
		}
		for(long i:arr) {
			System.out.println(i);
		}
		//Array 길이 이상의 index에 접근하는 경우 -> (존재하지 않는 3번 index에 값 대입하기)
//		System.out.println("arr[3]에 값 대입 :");
//		long input =scan.nextLong();
		
//		arr[3] =input;
		/*ArrayIndexOutOfBoundsException:
		 * (배열 index 범위 초과)
		 * Index 3 out of bounds for length 3
		 * 
		 * ->존재하지않는 index 접근불가
		 */
//		System.out.println("확인 :"+arr[3]);
		scan.close();
	}
	
	/**인원수를 입력받아
	 * 그 크기를 가지는 정수배열을 선언, 할당하고
	 * 각 배열에 점수를 입력받아 저장.
	 * 입력이 완료되면 합계, 평균, 최대값, 최소값 출력하기
	 */
	public void method5() {
		Scanner scan =new Scanner(System.in);
		
		System.out.print("입력받을 인원수 입력 :");
		int size =scan.nextInt();
		
		int scoreArr[] =new int[size];
		int sum =0;
		
		for(int i=0; i<scoreArr.length; i++) {
			System.out.printf("%d번째 입력 :",i);
			scoreArr[i] =scan.nextInt();
			sum +=scoreArr[i];
		}
		System.out.println("합계 :"+sum);
		System.out.println("평균 :"+(double)sum/size);
		/*최고/최저점 기록된 index 찾기*/
		int maxIndex =0;
		int minIndex =0;
		
		for(int i=1; i<scoreArr.length; i++) {	//index[0]은 비교할 필요X 1부터 시작
			if(scoreArr[i]>scoreArr[maxIndex]) {
				maxIndex =i;	//현재 index[i]를 maxIndex에 대입
			}
			if(scoreArr[i]<scoreArr[minIndex]) {
				minIndex =i;	//현재 index[i]를 minIndex에 대입
			}
		}
		System.out.println("최대값 :"+scoreArr[maxIndex]);
		System.out.println("최소값 :"+scoreArr[minIndex]);
		
		scan.close();
	}
}
