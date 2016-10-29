package jik.android.retrofitrelm.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.realm.Realm;
import io.realm.RealmResults;
import jik.android.retrofitrelm.R;
import jik.android.retrofitrelm.adapters.RealmBooksAdapter;
import jik.android.retrofitrelm.adapters.RealmUserAdapter;
import jik.android.retrofitrelm.models.RealmUserModel;
import jik.android.retrofitrelm.models.UserModel;
import jik.android.retrofitrelm.realm.RealmController;
import jik.android.retrofitrelm.rest.ApiClient;
import jik.android.retrofitrelm.rest.ApiInterface;
import jik.android.retrofitrelm.utils.Notify;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name , family , number ;
    private RecyclerView recycler;
    private RealmUserAdapter adapter;
    private Realm realm ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        // refresh the realm instance
        RealmController.with(this).refresh();
        // get all persisted objects
        // create the helper adapter and notify data set changes
        // changes will be reflected automatically
        setRealmAdapter(RealmController.with(this).getBooks());

    }

    private void init(){
        findViewById(R.id.notify).setOnClickListener(this);

        name = (EditText) findViewById(R.id.name);
        family = (EditText) findViewById(R.id.family);
        number = (EditText) findViewById(R.id.phoneNumber);

        recycler = (RecyclerView) findViewById(R.id.recycler);

        // get Realm instance
        this.realm = RealmController.with(this).getRealm();

        setupRecycler();

    }

    public void setRealmAdapter(RealmResults<RealmUserModel> userModels) {

        RealmBooksAdapter realmAdapter = new RealmBooksAdapter(this.getApplicationContext(), userModels, true);
        // Set the data and tell the RecyclerView to draw
        adapter.setRealmAdapter(realmAdapter);
        adapter.notifyDataSetChanged();
    }

    private void setupRecycler() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recycler.setHasFixedSize(true);

        // use a linear layout manager since the cards are vertically scrollable
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);

        // create an empty adapter and add it to the recycler view
        adapter = new RealmUserAdapter(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.notify:

                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                if(!name.equals(" ")&&!family.equals(" ")&&!number.equals(" ")){
                    UserModel userModel = new UserModel(
                            name.getText().toString(),
                            family.getText().toString(),
                            number.getText().toString()
                            );
                    Call<UserModel> call = apiService.createUser(userModel);
                    call.enqueue(new Callback<UserModel>() {
                        @Override
                        public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                            Toast.makeText(MainActivity.this, "good job :)", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<UserModel> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "fail :(", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else Toast.makeText(MainActivity.this, "shit", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
