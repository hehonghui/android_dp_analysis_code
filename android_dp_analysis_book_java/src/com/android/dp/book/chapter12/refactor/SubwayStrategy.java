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

package com.android.dp.book.chapter12.refactor;

// 地铁价格计算策略
public class SubwayStrategy implements CalculateStrategy {

    /**
     * 6公里(含)内3元；6-12公里(含)4元；12-22公里(含)5元；22-32公里(含)6元；
     * 
     * @param miles 公里
     * @return
     */
    @Override
    public int calculatePrice(int miles) {
        if (miles <= 6) {
            return 3;
        } else if (miles > 6 && miles < 12) {
            return 4;
        } else if (miles > 12 && miles < 22) {
            return 5;
        }
        else if (miles > 22 && miles < 32) {
            return 6;
        }
        // 其他距离我们简化为7块
        return 7;
    }

}
