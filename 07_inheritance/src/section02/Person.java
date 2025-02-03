package section02;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("[new Person]");
	}
	//매개변수 생성자 자동생성 :Alt + Shift + S ->O

	public Person(String name, int age) {
		System.out.println("[Person 매개변수 있는 생성자로 생성됨]");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return String.format("name :%s / age :%d", name,age);
	}
}