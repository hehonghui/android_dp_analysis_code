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

package com.android.dp.book.chapter22;

public class Test {
    public static void main(String[] args) {
        // Ticket ticket01 = TicketFactory.getTicket("北京", "青岛");
        // ticket01.showTicketInfo("上铺");
        // Ticket ticket02 = TicketFactory.getTicket("北京", "青岛");
        // ticket02.showTicketInfo("下铺");
        // Ticket ticket03 = TicketFactory.getTicket("北京", "青岛");
        // ticket03.showTicketInfo("坐票");
        //
        testString();
    }

    private static void testString() {
        String str1 = new String("abc");
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = "ab" + "c";
        // 使用equals只判定字符值
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str3.equals(str2));

        // 等号判等，判定两个对象是不是同一个地址
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str3 == str2);
        System.out.println(str4 == str2);
    }
}
