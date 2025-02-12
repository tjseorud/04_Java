package section03.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import section03.dto.Member;

public class ObjectService {
	/**Member 객체 하나를 파일로 출력하기*/
	public void outputMenber() {
		//출력용 스트림 참조변수 선언
		FileOutputStream fos =null;		//기반 스트림
		ObjectOutputStream oos =null;	//객체 출력 보조 스트림
		
		try {			
			Member member =new Member("member112233","1q2w3e4r!","짱구"); //출력할 Member 객체생성
			fos =new FileOutputStream("io_test/byte/Member.bin");	//파일 출력 기반
			/*.bin 확장자 :바이너리 코드(==바이트 코드)저장 파일확장자*/
			oos =new ObjectOutputStream(fos);	//객체 출력 보조 스트림 객체생성
			oos.writeObject(member);	//보조 스트림 이용해서 파일에 Member 객체출력
			System.out.println("출력 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos !=null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	/**파일에서 Member 객체 입력받기(읽어오기)*/
	public void inputMember() {
		//스트림 참조변수 선언
		FileInputStream fis =null;
		ObjectInputStream ois =null;
		
		try {
			fis =new FileInputStream("io_test/byte/Member.bin");	//입력기반 스트림
			ois =new ObjectInputStream(fis);	//객체입력 보조 스트림			
			Member member =(Member)ois.readObject();	//연결된 파일로부터 Member 객체 읽어오기
			/*-파일에 존재하는 Member객체는 직렬화된 상태 
			 * ->readObject() 호출 시 자동으로 "역직렬화" 수행
			 *  ->JVM이 객체를 인식 가능한 상태로 변경
			 */
			System.out.println("읽어온 Member\n"+member);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois !=null) { 
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void outputMemberList() {
		/*Stream 객체 참조변수*/
		FileOutputStream fos =null;
		ObjectOutputStream oos =null;
		
		try {
			List<Member> memberList =new ArrayList<Member>();
			memberList.add(new Member("member1","pass1","짱구"));
			memberList.add(new Member("member2","pass2","맹구"));
			memberList.add(new Member("member3","pass3","훈이"));
			
			fos =new FileOutputStream("io_test/byte/MemberList.bin");
			oos =new ObjectOutputStream(fos);
			oos.writeObject(memberList);	//객체출력
			System.out.println("회원 목록 출력 완료");
			
		} catch (Exception e) {
			e.printStackTrace();	//예외발생 메서드 추적
		} finally {
			try {
				if(oos !=null) oos.close(); //보조 스트림 close 시 기반 스트림도 같이 close
			} catch (IOException e) {
				e.printStackTrace();	
			} 
		}
	}
	/**MemberList.bin 읽어오기
	 */
	public void inputMemberList() {
		FileInputStream fis =null;
		ObjectInputStream ois =null;
		
		try {
			fis =new FileInputStream("io_test/byte/MemberList.bin");
			ois =new ObjectInputStream(fis);
			
			/*직렬화된 상태로 저장된 List<Member> 객체를 읽어와
			 * 역직렬화해서 저장
			 */
			List<Member> memberList =(List<Member>) ois.readObject();
			
			for(Member member :memberList) {
				System.out.println(member.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois !=null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* -오버라이딩 시 throws 구문 작성 방법
	 *  1) 같거나 좁은 범위(세세한, 구체적인 예외)
	 *  2) throws 제거 가능(예외 발생 안하는 코드로 재정의)
	 *
	 * -사용자 정의 예외 :사용자가 필요한 예외 클래스 만들수 있다
	 * -사용자 정의 예외 방법 ->아무 Exception 클래스 상속
	 * 
	 * 1)Cheched Exception 		->RuntimeException 제외한 나머지 상속
	 * 2)Unchecked Exception 	->RuntimeException 또는 자식 상속
	 * 
	 *IO
	 * -input 	:프로그램이 데이터를 읽음(read)
	 * -output	:프로그램이 데이터를 씀(write)
	 * 
	 *File Class 
	 * -파일존재 여부 관계없이 파일을 참조하고 관리하는 객체
	 * 
	 *경로작성시 /,\ 차이 
	 * -Linux/Mac :/
	 * -Windows 	:\
	 * 절대경로 :root(/,C:,D:)최상위 폴더를 기준으로 원하는 위치까지의 경로를 작성하는 것
	 * 상대경로 :현재 위치(Java는 현재 프로젝트)를 기준으로 원하는 위치까지의 경로를 작성하는 것
	 * 
	 *Stream(스트림) :흐름, 개울, 시내 
	 * -데이터가 단 방향으로 흐르게하는 객체
	 * 
	 *InputStream/OutputStream 
	 * -바이트 기반 스트림(1byte씩 입출력)
	 * -기반 스트림 :단독으로 생성되어 사용가능한
	 * -보조 스트림 :기반에 붙어 기능 향상, 추가 기능 제공하는	
	 * 
	 *Buffer :데이터를 모아놓는 메모리 공간 ex)트럭,버스
	 * ->한번에 많은 데이터를 묶어서 전달
	 * ->Buffer를 이용한 속도 향상됨
	 */
}