package com.android.dp.book.chapter27.strategy;

public class Test {
	public static void main(String[] args) {
		Book product = new Book(100) ;
		
		PriceCalculator calculator = new PriceCalculator() ;
		calculator.setStrategy(new NormalStrategy()) ;
		calculator.calculate(product);
		
		// 策略替换
		calculator.setStrategy(new Strategy618()) ;
		calculator.calculate(product);
	}
}
