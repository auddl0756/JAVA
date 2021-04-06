package ObjectCreation.factoryMethod.pros3;
import java.util.*;

//객체 생성 시에 자식 타입을 반환할 수도 있는 유연성이 있어서 클라이언트가 좀 더 쉽게 사용가능하다.
//구현을 몰라도 인터페이스만으로 사용할 수 있게 한다.
public class Book {
	public static final Book INSTANCE = new Book();
	public Book() {}
	
	public static Book getInstance() {
		return INSTANCE;			//본인 타입을 반환할 수도 있고
	}
	
	public static Book getChildInstance() {
		return BookChild.getInstance();	//자식 타입을 반환할 수도 있다
	}
	
	public static void main(String[] args) {
		//List<Integer> a = new ArrayList<>();
		//List<Integer> a2 = new LinkedList<>();
	
		Book book1 = Book.getInstance();
		Book book2 = Book.getChildInstance();
	}
}


class BookChild extends Book{
	private BookChild() {}
	
	public static BookChild getInstance() {
		return new BookChild();
	}
}