package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */
// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};

    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }    
    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {
    		Member member =new Member();
    		List<Member> list =dao.getMemberList();
    		
    		for(Member user :list) {
    			if(user.getPhone().equals(phone)) {
    				return false;
    			}
    		}
    		member.setName(name);
    		member.setPhone(phone);
    		member.setAmount(0);
    		member.setGrade(0);
    		dao.addMember(member);
    		
    		return true;
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
    		List<Member> list =dao.getMemberList();		   		
        return list;
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {
    		List<Member> list =new ArrayList<Member>();
    		
    		for(Member member :dao.getMemberList()) {
    			if(member.getName().equals(searchName)) {
    				list.add(member);
    			}
    		}
        return list;
    }


    // 금액 누적
    @Override
    public String updateAmount(Member target, int acc) throws IOException {    	    	
	    	int grade;   	
	    	int oldAcc =target.getAmount();;
	    	String temp =null;
	    	
	    	target.setAmount(oldAcc +acc);
	    	int newAcc =target.getAmount();
	    	
	    	if(newAcc >0 || newAcc <100000) grade =Member.COMMON;
	    	else if(newAcc <1000000) grade =Member.GOLD;
	    	else grade =Member.DIAMOND;
	    	
	    	target.setGrade(grade);
	    	
	    	if(grade == 2) temp =gradeArr[2];
	    	else if(grade == 1) temp =gradeArr[1];
	    	else temp =gradeArr[0];
	    	
	    	dao.saveFile();
	      return String.format("%d -> %d\n* %s * 등급으로 변경 되셨습니다",oldAcc,newAcc,temp); // 결과 문자열 반환       
        //ex)
        // 2000 -> 100000
        // * 골드 * 등급으로 변경 되셨습니다
    }

    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {
	    	String oldPhone =target.getPhone();
	    	target.setPhone(phone);
	    	
	    	dao.saveFile();
	      return String.format(target.getName()+"님의 전화번호가 변경 되셨습니다\n"+"%s -> %s",oldPhone,target.getPhone()); // 결과 문자열 반환       
	        // ex)
	        // 홍길동님의 전화번호가 변경 되었습니다
	        // 01012341234 -> 01044445555
    }


    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {  
    		List<Member> list =dao.getMemberList();
    		list.remove(target);
    		    	
    		dao.saveFile();    		
        return String.format(target.getName()+" 회원이 탈퇴 처리 되었습니다"); // 결과 문자열 반환
        // ex)
        // "홍길동 회원이 탈퇴 처리 되었습니다"
    }

}