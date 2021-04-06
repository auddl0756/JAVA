package ObjectCreation.factoryMethod.pros1;

//1. 객체 생성 시에 생성자 대신 팩토리 메서드를 쓰면 의미를 더 명확히 할 수 있다는 장점이 있다...
public class Book {
	private String name;
	
	public Book(String name) {
		this.name=name;
	}
	
	public static Book withName(String name) {
		return new Book(name);
	}
	
	public static Book withAuthor(String name) {
		return new Book(name);
	}
	
	public static void main(String[] args) {
//Is Parameter "Effective Java" book name? yes in this case. but can be ambiguous
		Book book1_1 = new Book("Effective Java");
		Book book2_1 = new Book("Gosling");	//이게 저자인지 책 제목인지..?? 생성자 방식은 알수가 없다.
		System.out.println(book1_1.name);
		
//this has better clarity
		Book book1_2 = Book.withName("Effective Java");
		Book book2_2 = Book.withAuthor("Gosling");
		System.out.println(book1_2.name);
	}
	
}
