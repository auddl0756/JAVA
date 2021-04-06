package ch10_Inheitance;

public class ChildOther extends Parent{
	public ChildOther() {
		System.out.println("Child other's constructor");
	}
	
	@Override
	public void printName() {
		System.out.println("other child's printName()");
	}
}
