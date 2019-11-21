package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.API.APIClient;
import com.example.myapplication.API.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PickLocation extends AppCompatActivity implements MyInterface{

    RecyclerView recyclerView;
    ArrayList<Category> categories;
    LocationAdapter locationAdapter;
    EditText search_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_location);

        recyclerView = findViewById(R.id.recycler_loc);
        search_et = findViewById(R.id.search_txt);

        recyclerView.setHasFixedSize(true);
//        locationAdapter.setClickListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.equals(""))
                    filterList(s);
                else
                    getLocList();
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
            getLocList();
        recyclerView.setVisibility(View.GONE);

    }

    private void filterList(CharSequence s) {
        ArrayList<Category> loc = new ArrayList<>();
        for (Category lct: categories
             ) {
            if(lct.getCName().toLowerCase().contains(s.toString().toLowerCase()));
            loc.add(lct);
        }

        locationAdapter = new LocationAdapter(loc, PickLocation.this);
        recyclerView.setAdapter(locationAdapter);
    }
        public void getLocList(){

            APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

            Call<ArrayList<Category>> listCall = apiInterface.getCategories();

            listCall.enqueue(new Callback<ArrayList<Category>>() {
                @Override
                public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                    categories = response.body();

                    locationAdapter = new LocationAdapter(categories, PickLocation.this);

                    recyclerView.setAdapter(locationAdapter);

                }

                @Override
                public void onFailure(Call<ArrayList<Category>> call, Throwable t) {

                }
            });

        }


    @Override
    public void userItemClick(View v, int pos) {
        Toast.makeText(this, "Clicked Item : " + pos, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("pos", pos);
        startActivity(intent);

    }
}
