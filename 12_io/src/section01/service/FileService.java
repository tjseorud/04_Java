package section01.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileService {
	/* File 클래스
	 * - java.io 패키지
	 * - 파일/디렉토리(폴더)를 관리하는 클래스(파일/디렉토리 존재 유무 관계 없음)
	 * - 파일 생성, 제거, 이름, 크기, 마지막 수정일, 존재여부 등의 기능 제공 
	 * 
	 * - File 클래스 메서드
	 * boolean  mkdir()          : 디렉토리 생성(단일)
	 * boolean  mkdirs()         : 경로상의 모든 디렉토리 생성
	 * boolean  createNewFile()  : 파일 생성
	 * boolean  delete()         : 파일/디렉토리 삭제
	 * String   getName()        : 파일이름 반환
	 * String   getParent()      : 파일이 저장된 디렉토리 반환
	 * String   getPath()        : 전체경로 반환
	 * boolean  isFile()         : 현재 File 객체가 관리하는게 파일이면 true
	 * boolean  isDirectory()    : 현재 File 객체가 관리하는게 디렉토리 true
	 * boolean  exists()         : 파일/디렉토리가 존재하면 true, 아님 false
	 * long     length()         : 파일크기 반환
	 * long     lastModified()   : 파일 마지막 수정일(1970.01.01 09:00부터 현재까지 지난시간을 ms 단위로 반환)
	 * String[] list()           : 디렉토리 내 파일 목록을 String[] 배열로 반환
	 * File[]   listFiles()      : 디렉토리 내 파일 목록을 File[] 배열로 반환 
	 */
	/*[개발 상식]
	 * -OS :운영체제
	 * -폴더(Windows) == 디렉토리(Linux/Mac)
	 * -경로 표기 방법 ->하위 폴더 접근 방법
	 * Windows 		:\(백슬래시)	ex)Windows 		:C:\workspace
	 * Linux/Mac 	:/(슬래시)	ex)Linux/Mac 	:/Users/user/workspace 
	 * 
	 * *Java는 모든 운영체제에서 호환된다 ->코드에서 경로 표기시 \,/를 신경쓰지 않아도 된다
	 *  ->JVM이 실행시 실행되는 운영체제에 맞춰서 해석
	 * 
	 * -최상위 경로(최상위 폴더, root)
	 * Windows 		: C:, D:, E: (다수 존재 가능)
	 * Linux/Mac 	: /
	 */
	/**File 클래스를 이용한 객체생성 +폴더관리*/
	public void test1() {
		/*실제로 파일/폴더의 유무 관계없이 일단 참조*/
		File directory =new File("C:/workspace/04_JAVA/12_io/io_test/20250211");
		System.out.println("폴더 경로 :"+directory.getPath());
		System.out.println("폴더 유무 확인 :"+directory.exists());	//exists :존재하다
		
		if(!directory.exists()) { //폴더가 없다면
			if(directory.mkdirs()) {
				System.out.println("폴더가 생성되었습니다");
			}
		}else { //있다면
			System.out.println("부모 폴더 :"+directory.getParent());
			File parent =new File(directory.getParent());	//부모폴더 참조
			File[] files =parent.listFiles();  //모든 자식을 File[]로 얻어오기
			
			for(File f :files) {
				f.delete();	//자식 폴더/파일 삭제
			}			
			//부모폴더 삭제 시 자식폴더/파일이 있으면 삭제불가 ->내부 폴더/파일을 모두 지우고 부모폴더 삭제
			if(parent.delete()) {	
				System.out.println("폴더가 삭제되었습니다");
			}
		}
	}
	/**지정된 경로에 파일생성하기*/
	public void test2() {
		/*절대 경로 :절대적 기준(root폴더)부터 경로 표기
		 *상대 경로 :현재 위치/프로젝트 기준으로 경로 표기
		 */
		File folder =new File("io_test/20250211");
		
		if(!folder.exists()) {	//폴더가 없다면 생성
			folder.mkdirs();	
		}
		File file =new File(folder.getPath()+"/파일생성.txt");
		
		if(!file.exists()) {	//파일이 없다면
			try {
				if(file.createNewFile()) {
					System.out.println("파일이 생성되었습니다");
				}
			}catch (IOException e) {
				System.out.println("-- 파일 생성 중 예외 발생 --");
				e.printStackTrace();	//예외발생 메서드 추적
			}
		}else {
			System.out.println("이미 "+file.getName()+"(이)가 존재합니다");
		}
	}
	/**입력받은 폴더에 존재하는 모든 폴더/파일 목록출력*/
	public void test3() {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("폴더 경로 입력 >");
		String path =sc.nextLine();
		
		File folder =new File(path);
		
		if(!folder.exists()) {	//폴더가 없을 경우
			System.out.println("잘못된 경오가 입력되었습니다");
			sc.close();
			return;
		}
		/*폴더내 모든폴더/파일을 File[]로 반환받기 ->*/
		File[] files =folder.listFiles();
		
		for(File f :files) {
			String fileName =f.getName();
			Long lastModified =f.lastModified();	//마지막 수정일
			//->1970.01.01 09:00부터 현재까지 지난시간을 ms 단위로 반환
			/*SimpleDateFormat :간단히 날짜형식을 지정할수 있는 객체*/
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd a h:mm");			
			String date =sdf.format(lastModified);	//ms ->날짜형식 문자열로 변환
			
			String type =null;	//파일 유형	
			
			if(f.isFile()) { type ="파일"; }
			else { type ="폴더"; }
			
			String kb =null;	//파일 크기
			
			if(f.isFile()) {	//파일인 경우에만 크기측정
				long fileSize =f.length();	//파일의 바이트 크기변환
				long size =fileSize/1024;		//Byte ->KB 변환
				
				if(size <1) { size =1; }	//1kb 미만은 모두 1로 표기
				kb =size +"KB";
				
				System.out.printf("%-20s %-20s %-5s %-10s\n",fileName,date,type,kb ==null ?"" :kb);
			}
		}	
		sc.close();
	}
}