
package com.example.dp_state;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.dp_state.state.LoginContext;
import com.example.dp_state.state.LogoutState;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 转发按钮
        findViewById(R.id.forward_btn).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 调用LoginContext的转发函数
                LoginContext.getLoginContext().forward(MainActivity.this);
            }
        });

        // 注销按钮
        findViewById(R.id.logout_btn).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 设置为注销状态
                LoginContext.getLoginContext().setState(new LogoutState());
            }
        });

    }

    BroadcastReceiver updateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getApplicationContext(), "update", Toast.LENGTH_SHORT).show();
        }
    };
}
