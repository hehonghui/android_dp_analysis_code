package com.android.dp.book.chapter27.strategy;

public class PriceCalculator {
	
	PriceStrategy mStrategy ;

	public void setStrategy(PriceStrategy mStrategy) {
		this.mStrategy = mStrategy;
	}

	public void calculate(Book product) {
		System.out.println("商品价格为: " + mStrategy.calculate(product) );
	}
}
