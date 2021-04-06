package ch13_Interfaces.service;


//class 앞에 abstract 예약어를 붙인다.
//body를 구현하지 않은 메서드에 abstract를 붙인다
//body를 구현한 메서드에는 붙이지 않는다
//interface와 달리 구현되어 있는 메서드가 있어도 상관없다
//abstract 클래스는 인터페이스가 아니라 클래스이기때문에
//이 abstract 클래스를 구현하는 메서드는 extends를 사용해야 한다.

public abstract class MemberManagerAbstract {
	public abstract boolean addMember(MemberDTO member);
	public abstract boolean removeMember(String name,String phone);
	public abstract boolean updateMember(MemberDTO member);
	public void printLog(String data) {
		System.out.println("data = "+data);
	}
}
