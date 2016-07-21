package com.android.dp.book.chapter27.strategy;

// 平时 0.85折优惠
public class NormalStrategy extends PriceStrategy {

	@Override
	public float calculate(Book product) {
		return product.getPrice() * 0.85f;
	}
}
