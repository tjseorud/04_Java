package service;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayService2 {
	/**얕은 복사, 깊은 복사 확인하기
	 */
	public void method1() {
		int arr1[] = {10,20,30,40,50};
		int[] copyArr1 =arr1;
		
		System.out.println("arr1 :"+Arrays.toString(arr1));
		System.out.println("copyArr1 :"+Arrays.toString(copyArr1));
		/* Arrays 클래스명 : 배열 관련 유용한 기능 제공 클래스
		 * Arrays.toString(arr1) : 배열에 저장된 모든값을 하나의 문자열로 변환
		 */
		copyArr1[0] =999;
		System.out.println("변경후");
		System.out.println("arr1 :"+Arrays.toString(arr1));
		System.out.println("copyArr1 :"+Arrays.toString(copyArr1));
		
		/* hashCode() :주소를 이용해서 만든 해시함수 결과 값 */
		System.out.println(arr1.hashCode());
		System.out.println(copyArr1.hashCode());
		
		//깊은 복사
		int[] arr2 = {5,6,7,8};
		/*1)*/
		int[] copyArr2 =new int[arr2.length];	//완전히 동일한 형태를 만들기 위해 같은크기 배열을 생성
		
		/*2)*/
		for(int i=0; i<arr2.length; i++) {
			copyArr2[i] =arr2[i];
		}
		System.out.println("변경전");
		System.out.println("arr2 :"+Arrays.toString(arr2));
		System.out.println("copyArr2 :"+Arrays.toString(copyArr2));
		
		copyArr2[0] =1234;
		System.out.println("변경후");
		System.out.println("arr2 :"+Arrays.toString(arr2));
		System.out.println("copyArr2 :"+Arrays.toString(copyArr2));
		
		//hashCode() 다름 확인 ->서로다른 배열참조
		System.out.println(arr2.hashCode());
		System.out.println(copyArr2.hashCode());
		
		/* 3) System.arraycopy(a, b, c, d, e)
		 * a :원본 배열명
		 * b :원본 배열에서 복사를 시작할 index 번호
		 * c :복사된 배열 요소값이 저장될 배열명
		 * d :복사하려는 배열에 값을 저장하기 시작할 index 번호
		 * e :원본 배열에서 복사할 요소 개수(길이)
		 */
		int[] copyArr3 =new int[arr2.length];
		System.arraycopy(arr2, 0, copyArr3, 0, arr2.length);
		System.out.println("변경전");
		System.out.println("arr2 :"+Arrays.toString(arr2));
		System.out.println("copyArr3 :"+Arrays.toString(copyArr3));
		
		copyArr3[0] =2222;
		System.out.println("변경후");
		System.out.println("arr2 :"+Arrays.toString(arr2));
		System.out.println("copyArr3 :"+Arrays.toString(copyArr3));
	}
	
	/**2차원 배열 선언, 할당, 초기화
	 */
	public void method2() {
		/*Java에서 배열기호는 []는 개당 1차원 의미
		 * [][] ->2차원
		 * [][][]	->3차원
		 */
		//1차원 배열 :같은 자료형 변수의 묶음
		//2차원 배열 :같은 자료형 1차원 배열 참조변수의 묶음
		int[][] arr =new int[2][3];
		arr[0][0] =7;
		arr[0][1] =14;
		arr[0][2] =21;
		arr[1][0] =28;
		arr[1][1] =35;
		arr[1][2] =42;
		System.out.println("arr[0] :"+arr[0]);	//int[] 참조주소
		System.out.println("arr[1] :"+arr[1]);	//int[] 참조주소
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**2차원 배열 선언 및 초기화
	 */
	public void method3() {
		Scanner scan =new Scanner(System.in);
		
		int[] arr1 = {30,40,50,60};	//1차원 배열선언 및 초기화
		int[] arr2 = {15,35,55,75};
		int[][] arr = {arr1,arr2,{99,88,77,66}};	//2차원 배열선언 및 초기화
		
		System.out.print("검색할 숫자입력 :");
		int input =scan.nextInt();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==input) {
					System.out.printf("%d행 %d열에 있습니다 \n",i,j);
					scan.close();
					return;
				}
			}
		}
		System.out.println("존재하지 않습니다");
		scan.close();
	}
}