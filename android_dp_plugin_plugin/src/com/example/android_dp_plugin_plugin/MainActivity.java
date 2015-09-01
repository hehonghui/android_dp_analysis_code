
package com.example.android_dp_plugin_plugin;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dp.plugin.PluginActivity;

public class MainActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plugin_activity_main);

        // View teView = findViewById(R.id.textview);
        // Toast.makeText(mProxyActivity, "text view : " + teView,
        // Toast.LENGTH_LONG).show();
        //
        setTitle("插件Activity");

        final TextView textView = (TextView) findViewById(R.id.my_textview);
        textView.setText(R.string.plugin_text);

        Button button = new Button(mProxyActivity);
        button.setText("Start TestActivity");
        button.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        button.setGravity(Gravity.CENTER);
        // setContentView(button);

        button.postDelayed(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(
                        mProxyActivity,
                        getResources().getString(R.string.plugin_text) + ", textview = " + textView,
                        Toast.LENGTH_LONG).show();
            }
        }, 1000);
    }

}
