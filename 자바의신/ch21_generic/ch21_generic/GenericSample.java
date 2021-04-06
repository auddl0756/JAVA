package ch21_generic;

public class GenericSample {
	public static void main(String[] args) {
		GenericSample sample = new GenericSample();
		sample.checkCastingDTO();
		
	}
	
	
	//with generic
	public void checkCastingDTO2() {
		CastingDTO<String> dto1 = new CastingDTO<String>();
		dto1.setObject(new String());
		
		CastingDTO<StringBuffer> dto2 = new CastingDTO<StringBuffer>();
		dto2.setObject(new StringBuffer());
		
		CastingDTO<StringBuilder> dto3 = new CastingDTO<StringBuilder>();
		dto3.setObject(new StringBuilder());
		
		//가져올 때 형변환이 필요없어진다!
		String s1= dto1.getObject();
		StringBuffer s2= dto2.getObject();
		StringBuilder s3=dto3.getObject();
		
		//잘못된 타입을 받아오면 컴파일 수준에서 에러를 탐지한다!
		//StringBuffer s4=dto3.getObject();
		
		//제네릭을 사용함으로써 런타임에러를 컴파일 타임에러로 변환했다?
	}
	
	// with no generic
	public void checkCastingDTO() {
		CastingDTO dto1=new CastingDTO();
		dto1.setObject(new String());
		
		CastingDTO dto2=new CastingDTO();
		dto2.setObject(new StringBuffer());
		
		CastingDTO dto3 = new CastingDTO();
		dto3.setObject(new StringBuilder());
		
		//getObject는 Object 타입을 리턴하므로 형반환이 필요하다.
		//dto의 인스턴스 변수의 타입이 무엇이었는지 헷갈릴 수 있다.
		
//		String s1= (String)dto1.getObject();
//		StringBuffer s2 = (StringBuffer)dto2.getObject();
//		StringBuilder s3 = (StringBuilder)dto3.getObject();
	}
}
