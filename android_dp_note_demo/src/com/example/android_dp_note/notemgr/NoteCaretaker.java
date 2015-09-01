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

package com.example.android_dp_note.notemgr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mrsimple
 */
public class NoteCaretaker {
    // 最大存储数量
    private static final int MAX = 30;
    // 存储30条记录
    List<Memoto> mMemotos = new ArrayList<Memoto>(MAX);

    int mIndex = 0;

    /**
     * 保存备忘录
     * 
     * @param memoto
     */
    public void saveMemoto(Memoto memoto) {
        if (mMemotos.size() > MAX) {
            mMemotos.remove(0);
        }
        mMemotos.add(memoto);
        mIndex = mMemotos.size() - 1;
    }

    public Memoto getPrevMemoto() {
        mIndex = mIndex > 0 ? --mIndex : mIndex;
        return mMemotos.get(mIndex);
    }

    public Memoto getNextMemoto() {
        mIndex = mIndex < mMemotos.size() - 1 ? ++mIndex : mIndex;
        return mMemotos.get(mIndex);
    }
}
