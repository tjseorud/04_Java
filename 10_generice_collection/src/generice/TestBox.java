package generice;
	
/**객체생성시 지정되는 타입 T는 Parent 또는 Parent 상속관계인 타입만 가능
 * @param <T>
 */
public class TestBox<T extends Parent> {
	private T obj;

	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
}