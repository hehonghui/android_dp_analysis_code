package com.android.dp.book.chapter04;

import java.util.ArrayList;
import java.util.List;

/**
 * 文档类型, 扮演的是 ConcretePrototype 角色,而 cloneable 是代表 prototype 角色
 */
public class WordDocument implements Cloneable {
	// 文本
	private String mText;
	// 图片名列表
	private List<String> mImages = new ArrayList<String>();

	public WordDocument() {
		System.out.println("----------- WordDocument 构造函数 -----------");
	}

	@Override
	protected WordDocument clone() {
		try {
			WordDocument doc = (WordDocument) super.clone();
			doc.mText = this.mText;
			doc.mImages = this.mImages;
			return doc;
		} catch (Exception e) {
		}
		return null;
	}

	public String getText() {
		return mText;
	}

	public void setText(String mText) {
		this.mText = mText;
	}

	public List<String> getImages() {
		return mImages;
	}

	public void addImage(String img) {
		this.mImages.add(img);
	}

	/**
	 * 打印文档内容
	 */
	public void showDocument() {
		System.out.println("----------- Word Content Start -----------");
		System.out.println("Text : " + mText);
		System.out.println("Images List: ");
		for (String imgName : mImages) {
			System.out.println("image name : " + imgName);
		}
		System.out.println("----------- Word Content End -----------");
	}
}
