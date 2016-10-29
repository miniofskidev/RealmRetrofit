package jik.android.retrofitrelm.realm;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;


import io.realm.Realm;
import io.realm.RealmResults;
import jik.android.retrofitrelm.models.RealmUserModel;

/**
 * Created by tosantechnolocal on 10/29/2016.
 */
public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }

    //clear all objects from Book.class
    public void clearAll() {

        realm.beginTransaction();
        realm.clear(RealmUserModel.class);
        realm.commitTransaction();
    }

    //find all objects in the Book.class
    public RealmResults<RealmUserModel> getBooks() {

        return realm.where(RealmUserModel.class).findAll();
    }

    //query a single item with the given id
    public RealmUserModel getBook(String id) {

        return realm.where(RealmUserModel.class).equalTo("id", id).findFirst();
    }

    //check if Book.class is empty
    public boolean hasBooks() {

        return !realm.allObjects(RealmUserModel.class).isEmpty();
    }

    //query example
    public RealmResults<RealmUserModel> queryedBooks() {

        return realm.where(RealmUserModel.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();

    }

}
