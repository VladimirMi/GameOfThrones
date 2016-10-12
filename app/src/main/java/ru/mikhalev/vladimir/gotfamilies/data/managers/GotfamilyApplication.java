package ru.mikhalev.vladimir.gotfamilies.data.managers;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;

import ru.mikhalev.vladimir.gotfamilies.data.storage.DaoMaster;
import ru.mikhalev.vladimir.gotfamilies.data.storage.DaoSession;

public class GotfamilyApplication extends Application {

    private static Context sContext;
    private static DaoSession sDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "gothouses-db");
        Database db = helper.getWritableDb();
        sDaoSession = new DaoMaster(db).newSession();

        Stetho.initializeWithDefaults(this);
    }

    public static Context getAppContext() {
        return sContext;
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
