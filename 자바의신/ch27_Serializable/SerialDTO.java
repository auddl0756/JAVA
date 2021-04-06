package ch27_Serializable;

import java.io.Serializable;

public class SerialDTO implements Serializable {
	private String bookName;
	transient private int bookOrder;	//transient : Serializable에서 제외된다!(비밀번호같은 변수에 사용)
	private boolean bestSeller;
	private long soldPerDay;
	
	public SerialDTO(String bookName,int bookOrder,boolean bestSeller,long soldPerDay) {
		super();
		this.bookName=bookName;
		this.bookOrder=bookOrder;
		this.bestSeller=bestSeller;
		this.soldPerDay=soldPerDay;
	}
	
	@Override
	public String toString() {
		return "serialDTO [" +bookName+","+bookOrder+","+bestSeller+","+soldPerDay +"]";
	}
}
