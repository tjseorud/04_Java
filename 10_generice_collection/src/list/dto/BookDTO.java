package list.dto;

import java.util.Objects;

public class BookDTO implements Comparable<BookDTO>{
	private String title;
	private String author;
	private int price;	//가격
	private String publisher;	//출판사
	
	public BookDTO() {
		super();
	}
	public BookDTO(String title, String author, int price, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", author=" + author + ", price=" + price + ", publisher=" + publisher + "]";
	}
	/*equals(),hashCode() 오버라이딩*/
	@Override
	public int hashCode() {
		return Objects.hash(author, price, publisher, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDTO other = (BookDTO) obj;
		return Objects.equals(author, other.author) && price == other.price && Objects.equals(publisher, other.publisher)
				&& Objects.equals(title, other.title);
	}
	@Override
	/*기본 정렬 기준을 설정(제목 오름차순)
	 * ->호출시 자동으로 이 메서드 이용
	 */
	public int compareTo(BookDTO other) {
		return this.title.compareTo(other.title);
	}
	
}