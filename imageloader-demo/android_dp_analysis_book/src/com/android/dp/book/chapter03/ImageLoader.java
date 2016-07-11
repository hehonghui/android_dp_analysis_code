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

package com.android.dp.book.chapter03;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.dp.book.chapter02.refactor.cache.ImageCache;
import com.android.dp.book.chapter02.refactor.cache.MemoryCache;

import java.util.ArrayList;
import java.util.List;

/**
 * ImageLoader
 */
public class ImageLoader {

    ImageCache mCache = new MemoryCache();
    /**
     * 等待加载的列表
     */
    List<String> mWattingList = new ArrayList<String>();

    /**
     * 显示图片
     * 
     * @param url 图片url
     * @param imageView 要显示图片的ImageView
     */
    public void displayImage(String url, ImageView imageView) {
        Bitmap bmp = mCache.get(url);
        if (bmp == null) {
            downloadImageAsync(url, imageView);
        } else {
            imageView.setImageBitmap(bmp);
        }
    }

    /**
     * 下载图片 ( 后台下载 )
     * 
     * @param url 图片url
     * @param imageView 要显示图片的ImageView
     */
    private void downloadImageAsync(String url, ImageView imageView) {
        // 将加载请求加入请求队列中
        mWattingList.add(url);
        // 根据策略获取到当前要加载的url
        String currentUrl = mLoaderPolicy.getUrl();
        // 将该链接从等待列表中删除
        mWattingList.remove(currentUrl);
        Bitmap bmp = downloadBitmap(currentUrl);
        mCache.put(url, bmp);
        imageView.setImageBitmap(bmp);
    }

    private Bitmap downloadBitmap(String url) {
        return null/* 从网络中获取图片 */;
    }

    /**
     * 设置缓存策略
     * 
     * @param cache 缓存
     */
    public void setImageCache(ImageCache cache) {
        mCache = cache;
    }

    LoaderPolicy mLoaderPolicy = null;

    public void setLoaderPolicy(LoaderPolicy policy) {
        mLoaderPolicy = policy;
    }

}
