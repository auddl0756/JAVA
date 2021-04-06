package ch10_Inheitance;

public class Main_Casting {
	public static void main(String[] args) {
		ParentCasting child = new ChildCasting();
		child.printName();
		
		Main_Casting m = new Main_Casting();
		m.objectCastArray();
		
	}
	
	public void objectCast() {
		ParentCasting parent = new ParentCasting();
		ChildCasting child = new ChildCasting();
		
		ParentCasting parent2 = child;
//		ChildCasting child2= parent;	
			//this makes compile error 
			//자식을 정의하는데 자식에는 새로 확장된 메서드들도 있고 할 수 있는데
			//부모만으로 정의하기엔 정보가 부족하지.
	}
	
	public void objectCastArray() {
		ParentCasting[] parentArray = new ParentCasting[3];
		for(int i=0;i<2;i++) {
			parentArray[i]= new ChildCasting();
		}
		parentArray[2]= new ParentCasting();
		
		
		System.out.println("ParentCasting type ? ");
		// [객체] instanceof [클래스(타입)]
		for (ParentCasting tmp : parentArray) {
			System.out.println(tmp instanceof ParentCasting);
		}
		
		System.out.println("ChildCasting type ? ");
		for (ParentCasting tmp : parentArray) {
			System.out.println(tmp instanceof ChildCasting);
		}
  
	}
}
