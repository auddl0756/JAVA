package ch13_Interfaces.service;

//interface를 적용하려면 클래스명 뒤에 implements를 쓰고 구현할 interface들을 나열하면 된다
// implements는 상속받는게 아니라 클래스에 인터페이스를 구현하도록 강제로 짐을 부여하는 것이므로
//다중 상속과는 상관없다. 자바는 다중 상속을 지원하지 않는다. 자바8에선 좀 얘기가 달라진다지만.
public class MemberManagerImpl implements MemberManager{
	@Override
	public boolean addMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean removeMember(String name, String phone) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean updateMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		MemberManager sample = new MemberManagerImpl();
		//List<Integer> a= new ArrayList<>(); 로 쓰는 것처럼 (인터페이스) = (구현 클래스) 형태로 초기화해줘야 한다!
		
	}
}
