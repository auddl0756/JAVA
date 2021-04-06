package ch21_generic;

public class WildcardSample {
	public static void main(String[] args) {
		WildcardSample sample = new WildcardSample();
		sample.callWildcardMethod();
	}
	
	public void callWildcardMethod() {
		WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
		wildcard.setWildcard("A");
		wildcardStringMethod(wildcard);
	}
	
//	public void wildcardStringMethod(WildcardGeneric<String > c) {
//		String value = c.getWildcard();
//		System.out.println(value);
//	}
	
	 //String 타입으로 선언된 WildcardGeneric 객체뿐만 아니라 다른 타입으로 선언된 객체를 받으려면
	//generic에 wildcard를 사용할 수 있다
	//wildcard는 메서드의 파라미터에만 사용하는 것이 좋다.
	//wildcard는 받기 전용이다. wildcard로 선언하면 무슨 타입인지 알 수가 없기 때문이다.
	public void wildcardStringMethod(WildcardGeneric<?> c) {
		Object value = c.getWildcard();
		if(value instanceof String) System.out.println(value);
	}
}
