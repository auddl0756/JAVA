package ch10_Inheitance;

public class Parent {
	public Parent() {
		System.out.println("Parent Constructor");
	}
	// ** 부모 클래스에 기본 생성자가 없다면 ??
	// => 매개 변수 없는 생성자만 있다면 괜찮음
	// 매개변수 있는 생성자가 부모 클래스에 있다면
	// 자식 클래스 만들기 위해서는 부모에 기본생성자가 있어야 함
	// 또는 자식 생성자에서 super() 이용
	
	public void printName() {
		System.out.println("Parent's printName()");
	}
}

