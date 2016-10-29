package jik.android.retrofitrelm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by tosantechnolocal on 10/29/2016.
 */
public class UserModel{

    @SerializedName("Name") @Expose(deserialize = false)
    private String name ;

    @SerializedName("family") @Expose(deserialize = false)
    private String family ;

    @SerializedName("PhoneNumber") @Expose(deserialize = false)
    private String phoneNumber ;

    public UserModel(String name , String family , String phoneNumber){
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
    }

    public UserModel(){
        //empty constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
