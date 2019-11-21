package com.example.myapplication;

import androidx.annotation.NonNull;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.API.APIClient;
import com.example.myapplication.API.APIInterface;
import com.example.myapplication.API.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetails extends AppCompatActivity {

    OrderDetailsAdapter detailsAdapter;
    RecyclerView order_list;
    ArrayList<Example> examples;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    TextView textView;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        appBarLayout = findViewById(R.id.ord_appbr);
        textView = findViewById(R.id.tb_txt);
        toolbar = findViewById(R.id.ord_tb);
        collapsingToolbarLayout = findViewById(R.id.order_colp);

//        collapsingToolbarLayout.setTitle("Dominos Pizza");
//        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

//        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
//        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));

        ActionBar actionBar = getSupportActionBar();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        ViewCompat.setTransitionName(findViewById(R.id.ord_appbr), EXTRA_IMAGE);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()){
                    textView.setVisibility(View.GONE);
                }
                else if (verticalOffset == 0) {
                    //set your title when you scroll up
                    textView.setVisibility(View.VISIBLE);

                } else {
                    //title will disappear when you scroll down

                }
            }
        });

//        order_list = findViewById(R.id.recycler_order);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//
//        order_list.setLayoutManager(layoutManager);
//
//        order_list.setHasFixedSize(true);
//
//        getOrder();

        getIncomingIntent();


    }

    public void getOrder(){

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ArrayList<Example>> imageCall = apiInterface.getOrders();

        imageCall.enqueue(new Callback<ArrayList<Example>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Example>> call, @NonNull Response<ArrayList<Example>> response) {
                examples = response.body();

//                HeadingBanner headingBanner = response.body();
//
//                headingBanners.add(headingBanner);

                detailsAdapter = new OrderDetailsAdapter(examples, getApplicationContext());

                order_list.setAdapter(detailsAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Example>> call, @NonNull Throwable t) {

            }
        });

    }

    // && getIntent().hasExtra("Image_Name") && getIntent().hasExtra("Image_Info")
    private void getIncomingIntent(){

            String imageUrl = getIntent().getStringExtra("Image_Url");
            ImageView imageView = findViewById(R.id.order_img);
            Glide.with(this)
                .load(imageUrl)
                .into(imageView);

            String imageName = getIntent().getStringExtra("Image_Name");
            TextView name = findViewById(R.id.order_title);
            name.setText(imageName);

            String imageInfo = getIntent().getStringExtra("info");
            TextView info = findViewById(R.id.order_info);
            info.setText(imageInfo);

            String det = getIntent().getStringExtra("detail");
            TextView detail = findViewById(R.id.ord_detail);
            detail.setText(det);

            String desc = getIntent().getStringExtra("desc");
            TextView ord_desc = findViewById(R.id.ord_desc);
            ord_desc.setText(desc);

            String vtxt = getIntent().getStringExtra("vtxt");
            TextView or_vtxt = findViewById(R.id.ord_vtxt);
            or_vtxt.setText(vtxt);

            String vamt = getIntent().getStringExtra("vamt");
            TextView or_vamt = findViewById(R.id.ord_vamt);
            or_vamt.setText(vamt);

            String vtxt1 = getIntent().getStringExtra("vtxt1");
            TextView or_vtxt1 = findViewById(R.id.ord_vtxt1);
            or_vtxt1.setText(vtxt1);

            String vamt1 = getIntent().getStringExtra("vamt1");
            TextView or_vamt1 = findViewById(R.id.ord_vamt1);
            or_vamt1.setText(vamt1);

            String vtxt2 = getIntent().getStringExtra("vtxt2");
            TextView or_vtxt2 = findViewById(R.id.ord_vtxt2);
            or_vtxt2.setText(vtxt2);

            String vamt2 = getIntent().getStringExtra("vamt2");
            TextView or_vamt2 = findViewById(R.id.ord_vamt2);
            or_vamt2.setText(vamt2);

            String vtxt3 = getIntent().getStringExtra("vtxt3");
            TextView or_vtxt3 = findViewById(R.id.ord_vtxt3);
            or_vtxt3.setText(vtxt3);

            String vamt3 = getIntent().getStringExtra("vamt3");
            TextView or_vamt3 = findViewById(R.id.ord_vamt3);
            or_vamt3.setText(vamt3);

            String map = getIntent().getStringExtra("map");
            ImageView or_map = findViewById(R.id.addr_img);
            Glide.with(this)
                    .load(map)
                    .into(or_map);

            String addr = getIntent().getStringExtra("addr");
            TextView or_addr = findViewById(R.id.ord_vaddr);
            or_addr.setText(addr);

    }

}
