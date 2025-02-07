package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

/**도서관리 프로그램 입출력 담당 클래스(UI)
 */
public class BookView {
	private Scanner sc =new Scanner(System.in);
	private BookService service =new BookService();
/*SOLID
 * 1.단일 책임 원칙(Single Responsibility Principle, SRP)
 * 	->하나의 객체는 하나의 책인(역할)만 갖는다
 * 
 * 2.개방-패쇄 원칙(OCP, OCP)
 * 	->확장엔 개방, 수정엔 패쇄
 * 	 ->기존코드 수정X, 새 코드를 작성 ->원래 잘 동작하던 코드유지
 * 
 * 3.리스코프 치환 원칙(LSP, LSP)
 * 	-서브타입은 언제나 기반 타입으로 교체할수 있도록 해야한다
 * 	 ->자식객체가 부모객체(또는 부모객체 상속)로 교환 되어도 기존코드에 문제가 없어야한다
 * 
 * 4.인터페이스 분리 원칙(ISP, ISP)
 * 	-인터페이스를 최대한 필요한 기능만 갖도록 작게 만들자
 *   ->자식이 불필요한 메서드를 상속하지 않도록하기 위해서
 *   
 * 5.의존 역전 원칙(DIP, DIP)
 * 	-결합도를 낮추고, 응집도를 높여서 유지보수의 유연성 확보(추상화)
 */
	
	/**Main Menu
	 */
	public void displayMenu() {
		int input =0;
		
		do {
			System.out.println("\n**** 도서 관리 프로그램 ****");
			System.out.println("1. 전체 조회");
			System.out.println("2. index 번호로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 가격 수정하기");
			System.out.println("5. 책 제거하기(index)");
			System.out.println("6. 제목이 일치하는 책 1권 조회");
			System.out.println("7. 제목이 일치하는 책 제거하기");
			System.out.println("8. 출판사가 일치하는 책 전체 조회");
			System.out.println("9. 저자가 일치하는 책 전체 조회");
			System.out.println("10. 검색어가 제목, 저자에 포함된 책 전체 조회");
			System.out.println("11. BookList를 제목 오름차순 정렬하기");
			System.out.println("0. 종료하기\n");
			System.out.print("메뉴 번호 입력 >>");
			input =sc.nextInt();
			sc.nextLine(); //입력버퍼에 남아있는 문자열 제거
			
			switch (input) {
				case 1: { selectAll(); break; }
				case 2: { selectIndex(); break; }
				case 3: { addBook(); break; }
				case 44: { modifyBookPrice(); break; }
				case 4: { modifyBookPrice2(); break; }
				case 5: { deleteBook(); break; }
				case 6: { selectTitle(); break; }
				case 7: { deleteBookTitle(); break; }
				case 8: { selectPublisherAll(); break; }
				case 9: { selectAuthorAll(); break; }
				case 10: { searchBook(); break; }
				case 11: { bookListSorting(); break; }
				case 0: { System.out.println("프로그램을 종료합니다"); break; }
				default: System.out.println("잘못된 번호를 입력하였습니다");
			}
		}while(input !=0);
		sc.close();
	}

	/**1. 전채 조회
	 * -BookService의 필드 bookList를 얻어와 일반 for문을 이용허여 모든요소 정보출력
	 *  단, bookList에 저장된 정보가 없으면 "저장된 책이 존재하지 않습니다" 출력
	 */
	private void selectAll() {
		System.out.println("\n*** 전체 조회 ***");
		List<BookDTO> list =service.getBookList();
		//int size() :저장된 객체의 개수 반환
		//boolean isEmpty() :저장된 객체가 없으면 true 반환
//		if(list.size() ==0) {
		if(list.isEmpty()) {
			System.out.println("저장된 책이 존재하지 않습니다");
			return;
		}
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+") "+list.get(i));
		}
	}
	/**2. index 번호로 조회
	 * -bookList로 부터 index 번째 BookDTO 반환받기
	 * -조회하려는 책의 index 번호를 입력받아 책정보 출력
	 *  단, index 번호가 의 범위를 초과하면 "해당 index에 책이 존재하지 않습니다"출력
	 */
	private void selectIndex() {
		System.out.println("\n*** index 번호로 조회 ***");
		System.out.print("조회할 책 index 번호 >>");
		int index =sc.nextInt();	
		
		BookDTO book =service.selectIndex(index);
		if(book ==null) {
			System.out.println("해당 index에 책이 존재하지 않습니다");
			return;
		}
		System.out.println("title :"+book.getTitle());
		System.out.println("author :"+book.getAuthor());
		System.out.println("price :"+book.getPrice());
		System.out.println("publisher :"+book.getPublisher());
	}
	/**3. 책 추가하기
	 * -책 정보(제목,저자,가격,출판사)를 입력받아 BookService의 bookList에 마지막 요소로 추가
	 *  단, 모든정보가 일치하는 책은 추가 X(중복저장 X)
	 */
	private void addBook() {
		System.out.println("\n*** 책 추가하기 ***");
		System.out.print("제목 >>");
		String title =sc.nextLine();
		
		System.out.print("저자 >>");
		String author =sc.nextLine();
		
		System.out.print("가격 >>");
		int price =sc.nextInt();		
		sc.nextLine();	//입력버퍼 남은 문자열 제거 ->.next()/.nextInt() 사용후 제거
		
		System.out.print("출판사 >>");
		String publisher =sc.nextLine();
		
	  boolean result =service.addBook(new BookDTO(title,author,price,publisher));		
	  if(result) {
			System.out.println(title+" 책이 추가되었습니다");
		}else {
			System.out.println(title+" 책이 이미 존재합니다");
		}
	}
	/**4. 책 가격 수정하기
	 * -index 번호를 입력받아 해당 index에 책이 없다면 "해당 인덱스에 책이 존재하지 않습니다"
	 * -책이 있다면
	 * 	1)"수정할 가격 입력 >>"출력
	 *  2)스캐너로 입력받기
	 *  3)입력받은 index 번쨰 요소의 가격 수정
	 *  4)"[책제목] 가격이 [이전 가격] ->[수정된 가격]으로 수정되었습니다"출력
	 */
	private void modifyBookPrice() {
		System.out.println("\n*** 책 가격 수정하기 ***");
		System.out.print("조회할 책 index 번호 >>");
		int index =sc.nextInt();	
		
		BookDTO book =service.selectIndex(index);
		if(book ==null) {	
			System.out.println("해당 index에 책이 존재하지 않습니다");
			return;
		}
		
		System.out.print("수정할 가격 입력 >>");
		int newPrice =sc.nextInt();
		
		int oldPrice =book.getPrice();	//기존 가격
		book.setPrice(newPrice);		
		System.out.printf("[%s] 가격이 [%d] ->[%d]으로 수정되었습니다\n",book.getTitle(),oldPrice,newPrice);
	}	
	/**4. 책 가격 수정하기2
	 * -index 번호를 입력받아 해당 index에 책이 없다면 "해당 인덱스에 책이 존재하지 않습니다"
	 * -책이 있다면
	 * 	1)"수정할 가격 입력 >>"출력
	 *  2)스캐너로 입력받기
	 *  3)입력받은 index 번쨰 요소의 가격 수정
	 *  4)"[책제목] 가격이 [이전 가격] ->[수정된 가격]으로 수정되었습니다"출력
	 */
	private void modifyBookPrice2() {
		System.out.println("\n*** 책 가격 수정하기 ***");
		System.out.print("조회할 책 index 번호 >>");
		int index =sc.nextInt();		
		
		if(service.checkIndex(index) ==false) {
			System.out.println("해당 index에 책이 존재하지 않습니다");
			return;
		}		
		System.out.print("수정할 가격 입력 >>");
		int newPrice =sc.nextInt();

		System.out.println(service.modifyBookPrice2(index, newPrice));	
	}	
	/**5. 책 제거하기
	 * -index 번호를 입력받아 책 제거
	 *  단, 해당 index에 책이 없다면 "해당 인덱스에 책이 존재하지 않습니다",
   *  있다면 "[책제목] 책이 제거되었습니다" 출력
	 */
	private void deleteBook() {
		System.out.println("\n*** 책 제거하기 ***");
		System.out.print("제거할 책 인덱스 번호 >>");
		int index =sc.nextInt();
		
		BookDTO book =service.deleteBook(index);
		if(book ==null) {
			System.out.println("해당 index에 책이 존재하지 않습니다");
		}else {
			System.out.printf("[%s] 책이 제거되었습니다\n",book.getTitle());		
		}
	}
	/**6. 제목이 일치하는 책 1권 조회
	 */
	private void selectTitle() {
		System.out.println("\n*** 제목이 일치하는 책 1권 조회 ***");
		System.out.print("조회할 책 제목 >>");
		String title =sc.nextLine();	
		
		BookDTO book =service.selectTitle(title);
		if(book ==null) {
			System.out.println("조회한 책이 존재하지 않습니다");
			return;
		}		
		System.out.println("제목 :"+book.getTitle());
		System.out.println("저자 :"+book.getAuthor());
		System.out.println("가격 :"+book.getPrice());
		System.out.println("출판사 :"+book.getPublisher());
	}
	/**7. 제목이 일치하는 책 제거하기
	 */
	private void deleteBookTitle() {
		System.out.println("\n*** 제목이 일치하는 책 제거하기 ***");
		System.out.print("제거할 책 제목 >>");
		String title =sc.nextLine();	
		
		BookDTO book =service.deleteBookTitle(title);
		if(book ==null) {
			System.out.println("해당 책이 존재하지 않습니다");
			return;
		}
		System.out.printf("[%s] 책이 제거되었습니다\n",book.getTitle());		
	}
	/**8. 출판사가 일치하는 책 전체 조회
	 */
	private void selectPublisherAll() {
		System.out.println("\n*** 출판사가 일치하는 책 전체 조회 ***");
		System.out.print("조회할 책 출판사 >>");
		String publisher =sc.nextLine();
		
		List<BookDTO> list =service.selectPublisherAll(publisher);
		if(list.size() ==0) {	//list에 저장된 객체가 없을경우 -null은 참조주소가 없을때 사용
			System.out.println("조회한 책이 존재하지 않습니다");
		}else {
			System.out.println(list);
		}
	}
	/**9. 저자가 일치하는 책 전체 조회
	 */
	private void selectAuthorAll() {
		System.out.println("\n*** 저자가 일치하는 책 전체 조회 ***");
		System.out.print("조회할 책 저자 >>");
		String author =sc.nextLine();
		
		List<BookDTO> list =service.selectAuthorAll(author);
		if(list.isEmpty()) {	//list에 저장된 객체가 없을경우 -null은 참조주소가 없을때 사용
			System.out.println("조회한 책이 존재하지 않습니다");
		}else {
			System.out.println(list);
		}
	}
	/**10. 검색어가 제목, 저자에 포함된 책 전체 조회
	 */
	private void searchBook() {
		System.out.println("\n*** 검색어가 제목, 저자에 포함된 책 전체 조회 ***");
		System.out.print("검색어 >>");
		String search =sc.nextLine();
		
		List<BookDTO> list =service.searchBook(search);
		if(list.isEmpty()) {	//list에 저장된 객체가 없을경우 -null은 참조주소가 없을때 사용
			System.out.println("조회한 책이 존재하지 않습니다");
		}else {
			System.out.println(list);
		}
	}
	/**11. BookList를 제목 오름차순 정렬하기
	 */
	private void bookListSorting() {
		System.out.println("\n*** 제목 오름차순 정렬 시키기 ***");
		service.bookListSorting();
		System.out.println("정렬되었습니다");
	}
}