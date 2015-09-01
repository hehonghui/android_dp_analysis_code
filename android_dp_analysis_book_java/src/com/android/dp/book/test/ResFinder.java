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

package com.android.dp.book.test;

import java.util.HashMap;
import java.util.Map;

public class ResFinder {
    /**
     * 资源缓存map
     */
    public static Map<ResItem, Integer> mResourcesCache = new HashMap<ResItem, Integer>();

    public static void put(ResItem item, int id) {
        mResourcesCache.put(item, id);
    }

    public static int getResourceId(ResType type, String name) {

        ResItem item = new ResItem(type, name);
        // 从缓存中读取
        int rid = getIdFromCache(item);
        if (rid != -1) {
            return rid;
        }
        // 解析成功后缓存到map中
        mResourcesCache.put(item, rid);
        return rid;
    }

    private static int getIdFromCache(ResItem item) {
        return mResourcesCache.containsKey(item) ? mResourcesCache.get(item) : -1;
    }
}
