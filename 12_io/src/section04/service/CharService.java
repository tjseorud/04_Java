package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharService {
	/*[문자 기반 스트림]
	 * -2byte 문자(char) 단위로 입출력하는 스트림
	 * -문자만 작성된 파일(txt, bin 등), 채팅, JSON, 웹 요청(주소)/응답(HTML)
	 * -문자기반 스트림 최상위 인터페이스 :Reader(input), Writer(output)
	 */
	/**문자기반 스트림을 이용한 파일 출력*/
	public void fileOutput1() {
		FileWriter fw =null;
		
		try {
			String content ="""
					(여자)아이들 - 나는 아픈 건 딱 질색이니까
					오늘도 아침엔 입에 빵을 물고 똑같이 하루를 시작하고
					온종일 한 손엔 아이스 아메리카노 피곤해 죽겠네
					""";
			String path ="io_test/char";	//폴더가 없을경우
			File folder =new File(path);
			
			if(! folder.exists()) folder.mkdirs();
			
			fw =new FileWriter(folder+"/"+"나는아픈건딱질색이니까.txt");	//문자기반 파일출력 스트림 객체생성
			fw.write(content);	//문자기반 스트림을 이용해 출력 //String, char[] 출력을 위한 기능이 제공됨
			fw.flush();	//스트림에 남은 데이터를 밀어냄 //close()시 자동 수행됨
			
			System.out.println("출력완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**문자기반 스트림 + 보조 스트림을 이용한 파일 출력*/
	public void fileOutput2() {
		FileWriter fw =null;
		BufferedWriter bw =null;
		
		try {
			String content ="""
					(여자)아이들 - 나는 아픈 건 딱 질색이니까
					오늘도 아침엔 입에 빵을 물고 똑같이 하루를 시작하고
					온종일 한 손엔 아이스 아메리카노 피곤해 죽겠네
					""";
			String path ="io_test/char";	//폴더가 없을경우
			File folder =new File(path);
			
			if(! folder.exists()) folder.mkdirs();
			
			fw =new FileWriter(folder+"/"+"나는아픈건딱질색이니까_buffer.txt");	//문자기반 파일출력 스트림 객체생성
			bw =new BufferedWriter(fw);	//보조 스트림 객체생성
			bw.write(content);	//보조 스트림을 이용해 출력 //String, char[] 출력을 위한 기능이 제공됨
			bw.flush();	//스트림에 남은 데이터를 밀어냄 //close()시 자동 수행됨
			
			System.out.println("출력완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**문자기반 입력 스트림 + 보조 스트림을 이용한 파일 읽어오기*/
	public void fileInput() {
		/*try-with-resource
		 * -Java 7버전에서 추가된 기능
		 * -finally에서 작성하던 close 처리 구문을 자동으로 수행하도록 만드는 구문
		 */
		String path ="io_test/char/나는아픈건딱질색이니까.txt";
		try(BufferedReader br =new BufferedReader(new FileReader(path))) {
			//보조 스트림을 이용해서 파일내용 읽어오기
			StringBuilder sb =new StringBuilder();	//읽어온 내용 누적
			String temp =null;	//임시
			
			while (true) {
				temp =br.readLine();	//한 줄씩 읽어오기
				
				if(temp ==null) {break;}	//읽어올 내용이 없으면 반복종료
				sb.append(temp);	//읽어온 내용 누적
				sb.append("\n");	//엔터 추가
			}
			System.out.println("읽어오기 성공\n\n"+sb.toString());
			
		}catch (Exception e) {
			e.printStackTrace();
		} //finally에서 close 구문 생략가능
	}
	
	/*Scanner 대신 스트림을 이용한 문자열 입력받기 ->편리하지만 매우 느림
	 * 키보드입력 ->바이트(2진수)코드입력 ->문자변환
	 */
	public void keyboardInput() {
		//System.in ://기본장치(키보드)와 연결된 InputStream 반환
		/*InputStreamReader :바이트 스트림 ->문자 스트림 변환*/
		try(BufferedReader br =new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("문자열 입력1 :");
			String input1 =br.readLine();	//입력된 한 줄 읽어오기
			
			System.out.print("문자열 입력2 :");
			String input2 =br.readLine();	//입력된 한 줄 읽어오기
			
			System.out.println("input1 :"+input1);
			System.out.println("input2 :"+input2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}