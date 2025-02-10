package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.dto.BookDTO;

/**도서관리 프로그램 기능 제공 클래스
 */
public class BookService {
	private List<BookDTO> bookList =new ArrayList<BookDTO>();
	
	public BookService() {
		//샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다","한강",15000,"창비"));
		bookList.add(new BookDTO("초역 부처의 말","코이케 류노스케",17800,"포레스트북스"));
		bookList.add(new BookDTO("채식주의자","한강",15000,"창비"));
		bookList.add(new BookDTO("작별하지 않는다","한강",16800,"문학동네"));
		bookList.add(new BookDTO("모순","양귀자",13000,"쓰다"));
	}
	public List<BookDTO> getBookList() {
		return bookList;
	}
	/**전달받은 index 번째 요소 return
	 *  단, 범위 초과시 return null 
	 * @param index
	 * @return BookDTO 참조주소 또는 null
	 */
	public BookDTO selectIndex(int index) {
		if(checkIndex(index) ==false) { return null; }
		return bookList.get(index);
	}
	/**전달받은 index 범위가 정상인지 확인
	 * @param index
	 * @return 정상 :true, 아니면 :false
	 */
	public boolean checkIndex(int index) {		
		if(index <0 ||index >=bookList.size()) { return false; }
		return true;
	}
	/**전달받은 book을 bookList에 추가
	 * 단, 책정보가 모두 일치하는 책이 있다면 추가 X
	 * @param book
	 * @return 추가 OK :true, 추가 X :false 
	 */
	public boolean addBook(BookDTO book) {
		/*책정보 비교 방법 1)필드값 하나씩 꺼내서 비교
		/*책정보 비교 방법 2)equals() 오버라이딩 후 이용
		 */
//		for(BookDTO dto :bookList) {
//			if(dto.equals(book)) { return false; }
//		}
		//BookDTO의 equals()를 오버라이딩 했기 때문에 List가 제공하는 contains()(포함하는지 확인) 사용가능
		if(bookList.contains(book)) { return false; }
		return bookList.add(book);
		//컬렉션은 크기제한이 없어서 무조건 추가성공(return true)
	}
	/**전달받은 index 번째 요소의 가격을 newPrice로 수정2
	 * @param index
	 * @param newPrice
	 * @return "[책제목] 가격이 [이전 가격] ->[수정된 가격]으로 수정되었습니다"출력
	 */
	public String modifyBookPrice2(int index, int newPrice) {
		BookDTO book =bookList.get(index);
		int oldPrice =book.getPrice();	//기존 가격
		book.setPrice(newPrice);
		return String.format("[%s] 가격이 [%d] ->[%d]으로 수정되었습니다",book.getTitle(),oldPrice,newPrice);
	}
	/**index 번째 BookDTO 제거
	 * 단, 없으면 return null
	 * 제거에 성공하면 제거된 BookDTO 반환
	 * @param index
	 * @return 
	 */
	public BookDTO removeBook(int index) {
		if(checkIndex(index) ==false) { return null; }
		return bookList.remove(index);	//bookList에서 index 번쨰 요소 제거
	}
	/**전달받은 제목이 일치하는 책 조회
	 * @param title :찾을 책
	 * @return 없다면 :return null, 꺼낸 책의 제목과 전달받은 책의 제목이 같으면 BookDTO 반환
	 */
	public BookDTO selectTitle(String title) {
		for(BookDTO book :bookList) { //하나씩 꺼냄
			if(book.getTitle().equals(title)) { 
				return book;	//꺼낸 책의 제목과 전달받은 책의 제목이 같으면
			}
		}
		return null;	//없으면
	}
	/**전달받은 제목이 일치하는 책 제거
	 * @param title :삭제할 책
	 * @return 없다면 :return null, 있다면 제거된 BookDTO 반환
	 */
	public BookDTO removeBookTitle(String title) {		
		BookDTO book = selectTitle(title);		
		if(book ==null) { return null; }		
		bookList.remove(book);	//bookList에 저장된 객체(BookDTO)가 equals() 오버라이딩이 되어있어야 사용 가능한 방법
		return book;
	}
	/**전달받은 출판사가 일치하는 책 전체 조회
	 * @param publisher :출판사
	 */
	public List<BookDTO> selectPublisherAll(String publisher) {
		List<BookDTO> list =new ArrayList<BookDTO>();		
		
		for(BookDTO book :bookList) {
			if(book.getPublisher().equals(publisher)) { //출판사가 일치하면
				list.add(book);	//찾은 책 저장
			}
		}
		return list;
	}
	/**전달받은 저자가 일치하는 책 전체 조회
	 * @param author :저자
	 */
	public List<BookDTO> selectAuthorAll(String author) {
		List<BookDTO> list =new ArrayList<BookDTO>();		
		
		for(BookDTO book :bookList) {
			if(book.getAuthor().equals(author)) { //저자가 일치하면
				list.add(book);	//찾은 책 저장
			}
		}
		return list;
	}
	/**검색어가 제목, 저자에 포함된 책 전체 조회
	 * @param search
	 */
	public List<BookDTO> searchBook(String search) {
		List<BookDTO> list =new ArrayList<BookDTO>();
		for(BookDTO book :bookList) {
			if(book.getTitle().equals(search) ||book.getAuthor().equals(search)) { 
				//검색어에 제목,저자가 포함되면
				list.add(book);	//찾은 책 저장
			}
		}
		return list;
	}
	/**제목 오름차순 정렬
	 */
	public void bookListSorting() {
		Collections.sort(bookList);	//원본 리스트를 정렬된 형태로 변경됨
	}

}