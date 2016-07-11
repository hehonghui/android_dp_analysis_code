package com.dp.chapter01.part3;

import com.dp.chapter01.part3.widgets.View;

/**
 * 简单的窗口类
 * @author mrsimple
 *
 */
public class Window {
	public void show(View child)  {
		// 绘制各种视图
		child.draw();
	}
}
