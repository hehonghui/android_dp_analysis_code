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

package com.dp.plugin.proxy;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.util.Log;

import com.dp.plugin.PluginActivity;
import com.dp.plugin.PluginApk;
import com.dp.plugin.PluginManager;
import com.dp.plugin.Pluginable;
import com.dp.plugin.conts.Constants;

import java.lang.reflect.Constructor;

public class LifeCircleController implements Pluginable {

    Activity mProxy;
    PluginActivity mPlugin;
    Resources mResources;
    Theme mTheme;
    PluginApk mPluginApk;
    String mPluginClazz;

    public LifeCircleController(Activity activity) {
        mProxy = activity;
    }

    public void onCreate(Bundle bundle) {
        mPluginClazz = bundle.getString(Constants.PLUGIN_CLASS_NAME);
        String packageName = bundle.getString(Constants.PACKAGE_NAME);
        Log.e("", "### plugin class : " + mPluginClazz + ", package name = " + packageName);
        mPluginApk = PluginManager.getInstance().getPluginApk(packageName);
        try {
            mPlugin = (PluginActivity) loadPluginable(mPluginApk.classLoader, mPluginClazz);
            mPlugin.attach(mProxy, mPluginApk);
            Log.e("", "### 插件对象 mPlugin: " + mPlugin + ", apk res : " + mPluginApk.resources);
            mResources = mPluginApk.resources;
            // initializeActivityInfo();
            // handleActivityInfo();
            // 调用插件的onCreate函数
            mPlugin.onCreate(bundle);
        } catch (Exception e) {
            Log.e("", "### 加载插件类失败 ");
            e.printStackTrace();
        }
    }

    private Object loadPluginable(ClassLoader classLoader, String pluginActivityClass)
            throws Exception {
        Class<?> pluginClz = classLoader.loadClass(pluginActivityClass);
        Constructor<?> constructor = pluginClz.getConstructor(new Class[] {});
        constructor.setAccessible(true);
        return constructor.newInstance(new Object[] {});
    }

    @Override
    public void onStart() {
        if (mPlugin != null) {
            mPlugin.onStart();
        }
    }

    @Override
    public void onResume() {
        if (mPlugin != null) {
            mPlugin.onResume();
        }
    }

    @Override
    public void onStop() {
        mPlugin.onStop();
    }

    @Override
    public void onPause() {
        mPlugin.onPause();
    }

    @Override
    public void onDestroy() {
        mPlugin.onDestroy();
    }

    public Resources getResources() {
        return mResources;
    }

    public Theme getTheme() {
        return mTheme;
    }

    public AssetManager getAssets() {
        return mResources.getAssets();
    }

//    private ActivityInfo mActivityInfo;
//
//    private void initializeActivityInfo() {
//        PackageInfo packageInfo = mPluginApk.packageInfo;
//        if ((packageInfo.activities != null) && (packageInfo.activities.length > 0)) {
//            if (mPluginClazz == null) {
//                mPluginClazz = packageInfo.activities[0].name;
//            }
//
//            // Finals 修复主题BUG
//            int defaultTheme = packageInfo.applicationInfo.theme;
//            for (ActivityInfo a : packageInfo.activities) {
//                if (a.name.equals(mPluginClazz)) {
//                    mActivityInfo = a;
//                    // Finals ADD 修复主题没有配置的时候插件异常
//                    if (mActivityInfo.theme == 0) {
//                        if (defaultTheme != 0) {
//                            mActivityInfo.theme = defaultTheme;
//                        } else {
//                            if (Build.VERSION.SDK_INT >= 14) {
//                                mActivityInfo.theme = android.R.style.Theme_DeviceDefault;
//                            } else {
//                                mActivityInfo.theme = android.R.style.Theme;
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//
//    private void handleActivityInfo() {
//        if (mActivityInfo.theme > 0) {
//            mProxy.setTheme(mActivityInfo.theme);
//        }
//
//        Theme superTheme = mProxy.getTheme();
//        mTheme = mResources.newTheme();
//        mTheme.setTo(superTheme);
//        // Finals适配三星以及部分加载XML出现异常BUG
//        try {
//            mTheme.applyStyle(mActivityInfo.theme, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
