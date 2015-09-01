
package com.example.android_dp_plugin_host;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.dp.plugin.PluginManager;
import com.dp.plugin.conts.Constants;

import dalvik.system.DexClassLoader;

import java.io.File;
import java.lang.reflect.Constructor;

public class MainActivity extends Activity {

    PluginManager pluginMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PluginManager.init(getApplicationContext());
        pluginMgr = PluginManager.getInstance();
        getWindow().getDecorView().postDelayed(new Runnable() {

            @Override
            public void run() {
                String pluginApkPath = Environment.getExternalStorageDirectory()
                        + File.separator + "plugins" + File.separator
                        + "android_dp_plugin_plugin.apk";
                String pluginClazz = "com.example.android_dp_plugin_plugin.MainActivity";
                String pluginPackage = "com.example.android_dp_plugin_plugin";
                Log.e("", "### 插件路径 : " + pluginApkPath);
                File file = new File(pluginApkPath);
                if (file.exists()) {
                    Log.d("", "### apk存在");
                } else {
                    Log.d("", "### no apk存在");
                }

//                String includeApk = Environment.getExternalStorageDirectory()
//                        + File.separator + "plugins" + File.separator
//                        + "IncludeDemo.apk";
//                String includeClass = "com.example.includedemo.MainActivity";
//                String includePackage =
//                        "com.example.includedemo";

//                dexTest(pluginApkPath, pluginClazz);

                PluginManager.getInstance().loadApk(pluginApkPath);
//                PluginManager.getInstance().loadApk(includeApk);

                Intent intent = new Intent();
                intent.putExtra(Constants.PLUGIN_CLASS_NAME, pluginClazz);
                intent.putExtra(Constants.PACKAGE_NAME, pluginPackage);

                // intent.putExtra(Constants.PLUGIN_CLASS_NAME, includeClass);
                // intent.putExtra(Constants.PACKAGE_NAME, includePackage);
                pluginMgr.startActivity(intent);
            }
        }, 1000);
    }

    @SuppressLint("NewApi")
    private void dexTest(String dexPath, String className) {
        
        String dexOutpout = getApplicationContext().getDir("dex", 0)
                .getAbsolutePath() ;
        ClassLoader classLoader = getApplicationContext().getClassLoader() ;
        
        Log.e("", "### out : " + dexOutpout + ", class loader : " + classLoader + " , dex path " + dexPath) ;
        
        DexClassLoader dexClassLoader = new DexClassLoader(dexPath, dexOutpout, null, classLoader);
        
        try {
            Class<?> aClass = dexClassLoader.loadClass(className);
            Constructor<?> constructor = aClass.getConstructor(new Class[] {});
            constructor.setAccessible(true);
            Object object = constructor.newInstance(new Object[] {});
            Log.e("", "### 插件对象 -----> : " + object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
