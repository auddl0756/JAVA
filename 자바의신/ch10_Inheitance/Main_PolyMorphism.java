package ch10_Inheitance;

public class Main_PolyMorphism {
	public static void main(String[] args) {
		Main_PolyMorphism inheritance = new Main_PolyMorphism();
		inheritance.callPrintNames();
	}
	

	public void callPrintNames() {
		//선언 시에 모두  Parent 타입으로 선언
		Parent p1 = new Parent();
		Parent p2 = new Child();
		Parent p3 = new ChildOther();
		
		//실제 호출은 생성자를 사용한 클래스에 있는 것이 호출됨.
		//각 객체의 실제 타입은 다르다.
		//원래 객체에 있는 메서드가 호출된다.
		//무엇으로 생성했느냐가 중요@@@@@
		p1.printName();
		p2.printName();
		p3.printName();
		
		
//results 
//		Parent Constructor
//		Parent Constructor
//		child's Constructor
//		Parent Constructor
//		Child other's constructor
//		Parent's printName()
//		child's printName()
//		other child's printName()

	}
}

