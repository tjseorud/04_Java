package section01;

import java.util.Objects;

public class Book {
	private long bookNumber;	//책 식별번호
	private String title;
	private String author;
	private int price;
	
	public Book() {super();}
	public Book(long bookNumber, String title, String author, int price) {
		super();
		this.bookNumber = bookNumber;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	/**equals() Overriding
	 * ->비교하려는 두 객체의 필드값이 같은지 비교(동등 비교)
	 */
	@Override
	public boolean equals(Object obj) {
		//같은 객체를 참조하는 경우(주소가 같은 경우) ->무조건 true
		if(this ==obj)return true;
		//비교 대상이 없는경우 ->무조건 false
		if(obj ==null)return false;
		//비교대상이 같은타입의 객체인지 확인 ->타입이 다르면 false
//		if(!(obj instanceof Book)) return false;
		if(this.getClass() !=obj.getClass()) return false;
		
		//전달받은 매개변수를 Book으로 다운캐스팅
		Book other =(Book)obj;
		//현재 객체와 전달 받은객체가 다를 경우 return false
		if(this.bookNumber !=other.bookNumber) return false;
		if(!this.title.equals(other.title)) return false;
		if(!this.author.equals(other.author)) return false;
		if(this.price !=other.price) return false;
		return true;	//if가 수행되지 않으면 모든 필드가 같음 ==동등 ->return true
	}
	/**hashCode() Overriding
	 * -동등한 객체는 같은 식별번호를 가져야한다
	 * -A.equals(B) ->true 이면
	 *  A.equals() == B.equals() ->true
	 */
	@Override
	public int hashCode() {
//		int result =1;
//		final int PRIME =31;
//		result *= (int)bookNumber * PRIME;
//		result *= title.hashCode() * PRIME;
//		result *= author.hashCode() * PRIME;
//		result *= price * PRIME;
//		return result;			
		return Objects.hash(bookNumber,title,author,price);
	}
}