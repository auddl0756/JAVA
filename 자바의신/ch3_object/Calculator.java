package ch3_object;

public class Calculator {
	public Long add(Long a,Long b) {
		return a+b;
	}
	
	public Long minus(Long a,Long b) {
		return a-b;
	}
	
	public Long multiply(Long a,Long b) {
		return a*b;
	}
	
	public Long divide(Long a,Long b) {
		return a/b;
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println(calc.add(10L, 20L));
		System.out.println(calc.divide(5L, 2L));
		System.out.println(calc.divide(2L, 5L));
	}
}
