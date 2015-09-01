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

package com.dp.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;

import com.dp.plugin.conts.Constants;
import com.dp.plugin.proxy.ActivityProxy;

import dalvik.system.DexClassLoader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 插件管理器
 * 
 * @author mrsimple
 */
public class PluginManager {

    static class PluginMgrHolder {
        static PluginManager sManager = new PluginManager();
    }

    static Context mContext;

    Map<String, PluginApk> sMap = new HashMap<String, PluginApk>();

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public static PluginManager getInstance() {
        return PluginMgrHolder.sManager;
    }

    public PluginApk getPluginApk(String packageName) {
        return sMap.get(packageName);
    }

    /**
     * 加载插件APK
     * 
     * @param apkPath 插件的绝对路径
     */
    public final void loadApk(String apkPath) {
        PackageInfo packageInfo = queryPackageInfo(apkPath);
        if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName)) {
            return;
        }

        PluginApk pluginApk = sMap.get(packageInfo.packageName);
        if (pluginApk == null) {
            pluginApk = createApk(apkPath);
            if (pluginApk != null) {
                pluginApk.packageInfo = packageInfo;
                sMap.put(packageInfo.packageName, pluginApk);
            } else {
                throw new NullPointerException("PluginApk is null!");
            }
        }
    }

    private PackageInfo queryPackageInfo(String apkPath) {
        PackageInfo packageInfo = mContext.getPackageManager().getPackageArchiveInfo(apkPath,
                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
        if (packageInfo == null) {
            return null;
        }
        return packageInfo;
    }

    // TODO : 覆写PluginActivity的对应方法
    public void startActivity(Intent intent) {
        Intent myIntent = new Intent(mContext, ActivityProxy.class);
        Bundle extra = intent.getExtras();
        if (extra == null
                || !extra.containsKey(Constants.PLUGIN_CLASS_NAME)
                && !extra.containsKey(Constants.PACKAGE_NAME)) {
            throw new IllegalArgumentException("没有设置插件的类路径和包名");
        }
        myIntent.putExtras(intent);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(myIntent);
    }

    private PluginApk createApk(String apkPath) {
        PluginApk pluginApk = null;
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, apkPath);
            Resources pluginRes = new Resources(assetManager,
                    mContext.getResources().getDisplayMetrics(), mContext.getResources()
                            .getConfiguration());
            // AssetManager am = mContext.getResources().getAssets() ;
            // Method addAssetPath = am.getClass().getMethod("addAssetPath",
            // String.class);
            // addAssetPath.invoke(am, apkPath);
            pluginApk = new PluginApk(pluginRes);
            // 加载器
            pluginApk.classLoader = createDexClassLoader(apkPath);
        } catch (Exception e) {
        }
        return pluginApk;
    }

    private DexClassLoader createDexClassLoader(String apkPath) {
        File dexOutputDir = mContext.getDir("dex", Context.MODE_PRIVATE);
        DexClassLoader loader = new DexClassLoader(apkPath, dexOutputDir.getAbsolutePath(), null,
                mContext.getClassLoader());
        return loader;
    }
}
