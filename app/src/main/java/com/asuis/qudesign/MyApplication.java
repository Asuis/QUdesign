package com.asuis.qudesign;

import android.app.Application;
import android.content.Context;

import com.asuis.qudesign.db.model.DaoMaster;
import com.asuis.qudesign.db.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by 15988440973 on 2017/11/29.
 * desciption:
 */

public class MyApplication extends Application {
    public static DaoSession mDaoSession;
    private Context mContext;
    @Override
    public void onCreate()
    {
        super.onCreate();
        this.mContext = getApplicationContext();
        setupDataBase(this.mContext);
    }
    private void setupDataBase(Context context) {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context, "word.db");
        Database db = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }
    public static DaoSession getmDaoSession() {
        return mDaoSession;
    }
}
