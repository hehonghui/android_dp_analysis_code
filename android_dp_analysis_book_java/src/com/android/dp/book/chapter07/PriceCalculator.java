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

package com.android.dp.book.chapter07;

public class PriceCalculator {

    private static final int BUS = 1;
    private static final int SUBWAY = 2;
    private static final int TAXI = 3;

    public static void main(String[] args) {
        PriceCalculator tStrategy = new PriceCalculator();
        System.out.println("坐16公里的公交车票价为 : " + tStrategy.calculatePrice(16, BUS));
        System.out.println("坐16公里的地铁票价为 : " + tStrategy.calculatePrice(16, SUBWAY));
    }

    /**
     * 北京公交车,10里之内1块钱,超过十公里之后每加一块钱可以乘5公里
     * 
     * @param miles 公里
     * @return
     */
    private int busPrice(int miles) {
        // 超过10公里的总距离
        int extraTotal = miles - 10;
        // 超过的距离是5公里的倍数
        int extraFactor = extraTotal / 5;
        // 超过的距离对5公里的取余
        int fraction = extraTotal % 5;
        // 价格计算
        int price = 1 + extraFactor * 1;
        return fraction > 0 ? ++price : price;
    }

    /**
     * 6公里(含)内3元；6-12公里(含)4元；12-22公里(含)5元；22-32公里(含)6元；
     * 
     * @param miles 公里
     * @return
     */
    private int subwayPrice(int miles) {
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

    /**
     * 简单计算为每公里2块钱吧
     * 
     * @param miles
     * @return
     */
    private int taxiPrice(int miles) {
        return miles * 2;
    }

    int calculatePrice(int miles, int type) {
        if (type == BUS) {
            return busPrice(miles);
        } else if (type == SUBWAY) {
            return subwayPrice(miles);
        } else if (type == TAXI) {
            return taxiPrice(miles) ;
        }
        return 0;
    }
}
