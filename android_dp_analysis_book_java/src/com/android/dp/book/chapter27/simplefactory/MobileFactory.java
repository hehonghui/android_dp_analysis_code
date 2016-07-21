package com.android.dp.book.chapter27.simplefactory;

import com.android.dp.book.chapter27.MobilePhone;

public class MobileFactory {
	// 简单工厂根据品牌创建对象
	public static MobilePhone createPhone(String brand) {
		if ( brand.equals("samsung")) {
			return new Samsung() ;
		} else if ( brand.equals("xiaomi")) {
			return new XiaoMi() ;
		} else if ( brand.equals("meizu")) {
			return new Meizu() ;
		}
 		return null ;
	}
}
