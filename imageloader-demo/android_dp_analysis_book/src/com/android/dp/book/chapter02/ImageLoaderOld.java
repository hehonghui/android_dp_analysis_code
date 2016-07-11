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

package com.android.dp.book.chapter02;

import com.android.dp.book.chapter02.cache.DiskCache;
import com.android.dp.book.chapter02.cache.DoubleCache;
import com.android.dp.book.chapter02.cache.MemoryCache;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;

public class ImageLoaderOld {
    // 内存缓存
    MemoryCache mMemoryCache = new MemoryCache();
    DiskCache mDiskCache = new DiskCache();
    DoubleCache mDoubleCache = new DoubleCache();
    boolean isUseDiskCache = false;
    boolean isUseDoubleCache = false;
    private Handler mUiHandler = new Handler() ;

    // 加载图片到ImageView中
    public void displayImage(String url, ImageView imageView) {
        Bitmap bmp = null;
        if (isUseDoubleCache) {
            bmp = mDoubleCache.get(url);
        } else if (isUseDiskCache) {
            bmp = mDiskCache.get(url);
        } else {
            bmp = mMemoryCache.get(url);
        }

        if (bmp == null) {
            downloadImage(url, imageView);
        } else {
            imageView.setImageBitmap(bmp);
        }
    }

    // 从网络上下载图片
    private void downloadImage(String url, ImageView imageView) {
        Bitmap bmp = null /* = 从网络上获取图片 */;
        if (isUseDoubleCache) {
            mDoubleCache.put(url, bmp);
        } else if (isUseDiskCache) {
            mDiskCache.put(url, bmp);
        } else {
            mMemoryCache.put(url, bmp);
        }
        imageView.setImageBitmap(bmp);
    }

    /**
     * 是否使用sd卡缓存
     * 
     * @param diskCahce 如果diskCahce为真则使用sd卡缓存，否则使用内存缓存
     */
    public void useDiskCache(boolean diskCahce) {
        isUseDiskCache = diskCahce;
    }

    /**
     * 是否使用双缓存
     * 
     * @param doubleCache 如果doubleCache为真则使用双缓存，否则使用内存缓存或者sd卡缓存
     */
    public void useDoubleCache(boolean doubleCache) {
        isUseDoubleCache = doubleCache;
    }
}
