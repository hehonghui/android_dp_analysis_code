package com.android.dp.book.chapter04;

public class Client {
	public static void main(String[] args) { 
		// 1、构建文档对象
		WordDocument originDoc = new WordDocument(); 
		// 2、编辑文档,添加图片等
		originDoc.setText("这是一篇文档");
		originDoc.addImage("图片 1");
		originDoc.addImage("图片 2");
		originDoc.addImage("图片 3");
		originDoc.showDocument();
		
		// 以原始文档为原型,拷贝一份副本
		WordDocument doc2 = originDoc.clone();
		doc2.showDocument();
		// 修改文档副本,不会影响原始文档
		doc2.setText("这是修改过的 Doc2 文本");
		doc2.showDocument();
		originDoc.showDocument();
	}
}
