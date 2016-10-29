package jik.android.retrofitrelm.adapters;

import android.content.Context;

import io.realm.RealmResults;
import jik.android.retrofitrelm.models.RealmUserModel;

/**
 * Created by tosantechnolocal on 10/29/2016.
 */
public class RealmBooksAdapter extends RealmModelAdapter<RealmUserModel> {

    public RealmBooksAdapter(Context context, RealmResults<RealmUserModel> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
