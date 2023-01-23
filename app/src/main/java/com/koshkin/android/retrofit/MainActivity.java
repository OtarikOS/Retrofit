package com.koshkin.android.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Call<List<RetroMessage>> call = service.getAllMessages();
        call.enqueue(new Callback<List<RetroMessage>>() {

            @Override
            public void onResponse(Call<List<RetroMessage>> call, Response<List<RetroMessage>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroMessage>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadDataList(List<RetroMessage> usersList) {

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(myAdapter);
    }

}