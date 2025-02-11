package section02.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteService {
	/*Stream(스트림)
	 * -데이터가 이동하는 통로 역할의 객체
	 * -데이터의 흐름의 기본적으로 단방향
	 */
	/*[Byte 기반 스트림]
	 * -1byte 단위로 데이터를 입/출력하는 스트림
	 * -최상위 클래스 : InputStream, OutputStream
	 * -입/출력 가능 데이터 -문자열, 파일(이미지,영상,오디오,PDF 등 모든 파일)
	 * *단, 2byte 범위 문자열이 깨질수 있고 좁은통로(1byte)를 이용하다보니 속도가 상대적으로 느림
	 * ***
	 * Stream 객체는 Java 프로그램이 종료되어도 외부장치/파일/프로그램과의 연결이 유지되기 때문에
	 * 자동으로 사라지지 않는다 ->프로그램 종료 전 Stream 객체의 메모리를 반환하는 .close() 구문 필수!
	 * ***
	 */
	/**지정된 경로에 파일생성 + 내용을
	 */
	public void fileByteOutput() {
		FileOutputStream fos =null;	//fos 참조변수를 try,finally에서 모두 사용할수있게 선언
		
		try {
			//폴더 경로,파일명 지정
			String folderPath ="io_test/byte";
			String fileName ="바이트기반테스트.txt";			
			File folder =new File(folderPath);
			
			if(folder.exists() ==false) {	//폴더가 없으면 생성
				folder.mkdirs();
			}
			//출력할 파일과 연결된 출력용 스트림 객체생성 ->해당 파일이 없으면 자동으로 생성
			fos =new FileOutputStream(folderPath+"/"+fileName);			
//			fos =new FileOutputStream(folderPath+"/"+fileName, true);	//이어쓰기 옵션(true)		
			/*StringBuilder :String의 불변성 문제를 해결하기 위한 객체*/
			StringBuilder builder =new StringBuilder();	//txt 파일에 출력할 내용작성
			builder.append("Hello World\n");
			builder.append("1234567980\n");
			builder.append("!@#$%^&*()\n");
			builder.append("히히모카\n");

			String content =builder.toString();	//StringBuilder에 저장된 내용을 String으로 변경
			//연결된 외부 txt파일로 content 내용을 출력
			/*방법1) 1byte씩 끊어서 출력*/
//			for(int i=0; i<content.length(); i++) {
//				char ch =content.charAt(i);	//i번째 문자 1개 반환
//				/*바이트 기반 스트림 ->1바이트 범위만 출력가능
//				 * ->0-255(바이트 범위) 사이 글자는 정상출력
//				 *  이후 글자(한글 등)은 모두 깨져서 출력
//				 */
//				fos.write(ch); //IOException 발생 가능성 있음
//			}
			/*방법2) String을 byte로 먼저 변환한 후 손실되는 데이터 없이 출력하기*/
			byte[] bytes =content.getBytes();	//String ->byte[] 형태로 얻어오기
			fos.write(bytes);	//손실되는 데이터 없이 모든 문자열(byte) 출력	
			System.out.println("출력 완료");
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos !=null) {	//NullPointerException 방지
					fos.close();	//IOException 발생 가능성 있음
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**보조 스트림 중 B을 이용해서 출력속도 향상시키기
	 */
	public void bufferedFileByteOutput() {
		/*버퍼(buffer) :데이터를 모아져있는 메모리상의 임시공간 == 장바구니
		 * ->한번에 많은양의 데이터를 이동시켜서 시간 효율을 좋아지게 만듦
		 */
		//스트림 객체 참조변수 선언
		FileOutputStream fos =null;	//기반 스트림(단독 사용 O)
		BufferedOutputStream bos =null;	//보조 스트림(단독 사용 X)
		//->보조
		try {
			/*기반 스트림 생성*/
			fos =new FileOutputStream("io_test/byte/버퍼_바이트.txt");	//파일이 없으면 생성됨
			/*보조 스트림 생성*/
			bos =new BufferedOutputStream(fos); //보조 스트림 생성시 기반 스트림과 연결
			//""" """ :내부에 작성된 모양 그대로의 문자열을 생성<pre>
			String content ="""
					<내용 작성>
					""";
			bos.write(content.getBytes());	//보조 스트림을 이용해서 출력 ->내용출력시 버퍼를 이용해 한번에 출력
			System.out.println("출력 완료");
			
		}catch (Exception e) {	//다형성 이용해서 모든 예외처리
			e.printStackTrace();
		}finally {
			try {	//사용 완료된 스트림 객체 메모리 반환
				if(bos !=null) { bos.close(); }	//보조스트림만 close하면 연결된 스트림도 같이 close 됨
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**바이트 기반 파일입력(파일 읽어오기) 1
	 */
	public void fileByteInput() {
		FileInputStream fis =null;
		
		try {
			fis =new FileInputStream("io_test/byte/노래가사.txt");
			int value =0;	//읽어온 1byte를 저장할 임시변수
			StringBuilder sb =new StringBuilder();
			
			while (true) {
				/*int fis.read()
				 * -파일로부터 1바이트 읽어서 반환
				 * -호출 시 마다 다음내용을 읽어옴
				 * -읽어올 내용이 없다면 -1 반환
				 */
				value =fis.read(); //파일로부터 1바이트
				
				if(value ==-1) break;	//반복종료
				sb.append((char)value);	//문자로 변환해서 누적
			}
			System.out.println(sb.toString());	//읽어온 값 출력
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally { //사용완료된 스트림객체 메모리 반환(.close())
			try {	
				if(fis !=null) { fis.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**바이트 기반 파일입력(한글 안깨지게 파일 읽어오기) 2
	 */
	public void fileByteInput2() {
		FileInputStream fis =null;
		
		try {
			fis =new FileInputStream("io_test/byte/노래가사.txt");
			/*byte[] readAllBytes() 
			 * -연결된 파일내용을 모두 byte로 변환하여 읽어오기
			 * -byte[] 형태로 반환됨
			 */			
			byte[] bytes =fis.readAllBytes();
			String content =new String(bytes);	//byte[]을 String에 그대로 저장
			
			System.out.println(content);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally { //사용완료된 스트림객체 메모리 반환(.close())
			try {	
				if(fis !=null) { fis.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**보조 스트림(BufferedInputStream)을 이용해서 효율적으로 파일 읽어오기
	 */
	public void bufferedFileByteInput() {
		FileInputStream fis =null;	//기반 스트림
		BufferedInputStream bis =null;	//보조 스트림
		
		try {	
			//기반,보조 스트림 생성
			fis =new FileInputStream("io_test/byte/노래가사.txt");
			bis =new BufferedInputStream(fis);
			/*보조 스트림을 이용해서 파일내용 -> 바이트로 변환 
			 * ->버퍼를 이용해 한번에 읽어옴 ->byte[]로 반환
			 */
			byte[] bytes =bis.readAllBytes();
			String content =new String(bytes);	//byte[]을 String에 그대로 저장
			
			System.out.println(content);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally { //사용완료된 스트림객체 메모리 반환(.close())
			try {	
				if(bis !=null) { bis.close(); }	//보조 스트림만 close해도 연결된 기반 스트림도 close
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**[파일 복사]
	 * <pre>
	 * - 복사할 파일의 경로를 입력받아 같은경로에 복사된 파일을 생성
	 * 
	 * -입력받은 경로에 파일이 존재하지 않으면 "파일이 존재하지 않습니다" 출력
	 * 
	 * -존재하면 같은 경로에 "파일명_copy.확장자" 이름으로 출력
	 * 
	 * [실행화면]
	 * 파일 경로 입력 :
	 * 복사 완료 :
	 * </pre>
	 */
	public void fileCopy() {
		Scanner sc =null;
		FileInputStream fis =null;			//입력 기반
		FileOutputStream fos =null;			//출력 기반
		BufferedInputStream bis =null;	//입력 보조
		BufferedOutputStream bos =null;	//출력 보조
		
		try {
			sc =new Scanner(System.in);
			System.out.print("파일 경로 입력 :");	//파일경로 입력받기
			String path =sc.nextLine();
			
			/*입력받은 경로의 파일과 FileInputStream연결하기
			 * ->파일이 없다면 FileNotFoundException 발생 ->catch에서 처리
			 */
			fis =new FileInputStream(path);			//기반
			bis =new BufferedInputStream(fis);	//보조
			
			byte[] bytes =bis.readAllBytes();	//연결된 파일 byte[] read
			
			/*입력받은 경로의 파일명에 _copy 붙이기*/
			StringBuilder sb =new StringBuilder();
			sb.append(path);	//기존 경로 추가
			
			/*뒤에서부터 검색하여 처음 찾은 "."위치(index)반환*/
			int insertpoint =sb.lastIndexOf(".");
			
			/*찾은 "." 앞에 "_copy" 삽입하기*/
			sb.insert(insertpoint, "_copy");
			String copyPath =sb.toString();	//복사본 경로
			
			fos =new FileOutputStream(copyPath);	//출력용 기반
			bos =new BufferedOutputStream(fos);		//출력용 보조
			
			bos.write(bytes);	//read file(bytes)출력
			System.out.println("복사 완료 :"+copyPath);
			
		}catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {	//스트림객체 메모리 반환
				if(bis !=null) { bis.close(); }
				if(bos !=null) { bos.close(); }
				if(sc !=null) { sc.close(); }
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}