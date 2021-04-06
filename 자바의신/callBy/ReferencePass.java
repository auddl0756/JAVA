package ch8_referenceType.callBy;

public class ReferencePass {
	public static void main(String[] args) {
		ReferencePass reference = new ReferencePass();
		
		reference.callPassByValue();
		reference.callPassByReference();
		
	}
	
	class MemberDTO{
		int age=20;
		String name="leemr";
	}
	
	public void callPassByReference() {
		MemberDTO member = new MemberDTO();
		
		System.out.println(member.age+" "+member.name);
		
		passByReference(member);
		
		System.out.println(member.age+" "+member.name);
	}
	
	public void passByReference(MemberDTO member) {
		member.age=1;
		member.name="park";
	}
	
	public void callPassByValue() {
		int a=10;
		String b="abc";
		
		System.out.println("before call : "+a+" "+b);
		
		passByValue(a, b);
		
		System.out.println("after call : "+a+" "+b);
	}
	
	public void passByValue(int a,String b) {
		a=1;
		b="cba";
	}
	
}
