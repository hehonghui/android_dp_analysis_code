package com.android.dp.book.chapter27.strategy;

// 京东618半价优惠
public class Strategy618 extends PriceStrategy {

	@Override
	public float calculate(Book product) {
		return product.getPrice() / 2;
	}
}
