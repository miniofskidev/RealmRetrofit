package jik.android.retrofitrelm.app;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by tosantechnolocal on 10/28/2016.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // CONFIGURING REALM ON APP START
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}

