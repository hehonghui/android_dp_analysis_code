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

package com.example.android_dp_note.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.android_dp_note.notemgr.Memoto;

public class NoteEditText extends EditText {
    public NoteEditText(Context context) {
        this(context, null);
    }

    public NoteEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NoteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Memoto createMemoto() {
        Memoto noteMemoto = new Memoto();
        // 存储文本与光标位置
        noteMemoto.text = getText().toString();
        noteMemoto.cursor = getSelectionStart();
        return noteMemoto;
    }

    public void restore(Memoto memoto) {
        setText(memoto.text);
        // 设置光标位置
        setSelection(memoto.cursor);
    }

}
