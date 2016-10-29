package jik.android.retrofitrelm.rest;

import jik.android.retrofitrelm.models.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by tosantechnolocal on 10/28/2016.
 */
public interface ApiInterface {

    @POST("/jikjik/test/music")
    Call<UserModel> createUser(@Body UserModel userModel);

}
