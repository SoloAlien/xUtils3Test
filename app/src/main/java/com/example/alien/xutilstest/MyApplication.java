package com.example.alien.xutilstest;

import android.app.Application;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.x;

/**
 * Created by Alien on 2016/8/18.
 */
public class MyApplication extends Application {
    private  DbManager.DaoConfig config;
    public  DbManager.DaoConfig getDaoConfig(){
        return config;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        initxUtils();
        initDb();
    }

    private void initDb() {
        config = new DbManager.DaoConfig()
                .setDbName("test.db")//设置数据库名称
                .setDbVersion(1)//设置数据库版本
                // 不设置dbDir时, 默认存储在app的私有目录.若要设置可调用setDbDir()方法
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();// 开启WAL, 对写入加速提升巨大
                    }
                }).setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        Toast.makeText(MyApplication.this, "数据库更新了", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initxUtils() {
        x.Ext.init(this);//初始化xutils
        x.Ext.setDebug(BuildConfig.DEBUG);//设置输出debug日志为true
    }
}
