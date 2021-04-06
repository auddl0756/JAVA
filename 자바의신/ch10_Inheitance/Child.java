package ch10_Inheitance;

//extends : 확장한다.
public class Child extends Parent {
	public Child() {
		System.out.println("child's Constructor");
	}
	
	@Override
	public void printName() {
		System.out.println("child's printName()");
	}
}
