package ch21_generic;

import java.io.Serializable;

//public class CastingDTO implements Serializable{
//	private Object object;
//	public void setObject(Object object) {
//		this.object= object;
//	}
//	public Object getObject() {
//		return this.object;
//	}
//}


// using generic
// TYPE : 아무 이름이나 지정 가능. 가상의 타입 이름.
// 하지만 주로 사용되는 규칙은
// E : collection, K : key , N : 숫자 , T: type , V: value
public class CastingDTO<TYPE> implements Serializable{
	private TYPE object;
	public void setObject(TYPE object) {
		this.object=object;
	}
	public TYPE getObject() {
		return object;
	}
}