package ObjectCreation.factoryMethod.pros2;

//2.객체 생성을 호출할 때마다 인스턴스를 생성하지 않아도 된다.
public class Book {
	String name;
	public static final Book INSTANCE = new Book();
	
	public Book() {
		super();
	}
	
	public static Book getInstance() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		//this makes new instance every time.
		for(int i=0;i<10;i++) {
			Book book = new Book();
		}
		
		//reuse already made instance.
		for(int i=0;i<10;i++) {
			Book book = Book.getInstance();
		}
		
	}
	
}
