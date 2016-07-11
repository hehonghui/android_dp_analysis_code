/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.android.dp.book.chapter02.refactor.cache;

import com.android.dp.book.chapter02.refactor.ImageLoader;

import android.graphics.Bitmap;
import android.test.AndroidTestCase;
import android.widget.ImageView;

public class CacheTest extends AndroidTestCase {

    
    public static void main(String[] args) {
        ImageLoader imageLoader = new ImageLoader() ;
        // 使用内存缓存
        imageLoader.setImageCache(new MemoryCache());
        // 使用sd卡缓存
        imageLoader.setImageCache(new DiskCache());
        // 使用双缓存
        imageLoader.setImageCache(new DoubleCache());
        // 使用自定义的图片缓存实现
        imageLoader.setImageCache(new ImageCache() {
            
            @Override
            public void put(String url, Bitmap bmp) {
                // 缓存图片
            }
            
            @Override
            public Bitmap get(String url) {
                return null /*从自定义的缓存实现中获取图片*/;
            }
        });
    }
    
    protected void setUp() throws Exception {
        super.setUp();

        ImageLoader imageLoader = new ImageLoader();
        ImageView imageView = null;
        // findViewById初始化ImageView
        // 加载图片
        imageLoader.displayImage("图片url", imageView);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
