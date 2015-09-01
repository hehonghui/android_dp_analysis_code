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

package com.example.dp_state;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dp_state.state.LoginContext;
import com.example.dp_state.state.LoginedState;

public class LoginActivity extends Activity {

    EditText usrNameEditText;
    EditText pwdEditText;

    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        usrNameEditText = (EditText) findViewById(R.id.username_edittext);
        pwdEditText = (EditText) findViewById(R.id.pwd_edittext);

        // 登录按钮
        findViewById(R.id.login_btn).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
                finish();
            }
        });
    }

    private void login() {
        String usrName = usrNameEditText.getText().toString().trim();
        String pwd = pwdEditText.getText().toString().trim();
        // 执行网络请求 ,进行登录 .....

        // 登录成功之后修改为已登录状态
        LoginContext.getLoginContext().setState(new LoginedState());
        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
    }
}
