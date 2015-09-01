
package com.dp.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;

public abstract class PluginActivity extends Activity implements Pluginable, Attachable<Activity> {

    protected Activity mProxyActivity;
    private Resources mResource;
    PluginApk mPluginApk;

    @Override
    public void attach(Activity proxy, PluginApk apk) {
        mProxyActivity = proxy;
        Log.e("", "### 代理对象 : " + proxy);
        mPluginApk = apk;
        mResource = apk.resources;
    }

    @Override
    public void setContentView(int layoutResID) {
        mProxyActivity.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        mProxyActivity.setContentView(view);
    }

    @Override
    public View findViewById(int id) {
        return mProxyActivity.findViewById(id);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        mProxyActivity.setContentView(view, params);
    }

    @Override
    public WindowManager getWindowManager() {
        return mProxyActivity.getWindowManager();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mProxyActivity.getClassLoader();
    }

    @Override
    public Context getApplicationContext() {
        return mProxyActivity.getApplicationContext();
    }

    @Override
    public MenuInflater getMenuInflater() {
        return mProxyActivity.getMenuInflater();
    }

    @Override
    public Window getWindow() {
        return mProxyActivity.getWindow();
    }

    @Override
    public Intent getIntent() {
        return mProxyActivity.getIntent();
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mProxyActivity.getLayoutInflater();
    }

    @Override
    public String getPackageName() {
        return mPluginApk.packageInfo.packageName;
    }

    @Override
    public Resources getResources() {
        return mResource;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("", "### 插件的onCreate");
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }
}
