package ch15_String;

public class StringCheck {
	public static void main(String[] args) {
		StringCheck sample = new StringCheck();
		
		String[] addresses= {
				"seoul gangnam",
				"seoul mapo",
				"gyeunggi bundang",
				"here seoul"
				
		};
		
//		sample.checkAddress(addresses);
		sample.checkAddress2(addresses);
	}
	
	public void checkAddress(String[] addresses) {
		for(String s:addresses) {
			if(s.startsWith("seoul")) System.out.println(s);
		}
	}
	
	public void checkAddress2(String[] addresses) {
		for(String s:addresses) {
			if(s.contains("seoul")) System.out.println(s);
		}
	}
	
}
