package com.example.myapplication;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.API.APIClient;
import com.example.myapplication.API.APIInterface;
import com.example.myapplication.API.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoucherActivity extends AppCompatActivity {
    private ArrayList<Example> examples;
    ViewPager viewPager;
    VoucherPagerAdapter voucherPagerAdapter;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        viewPager = findViewById(R.id.vc_vw);

        fab = findViewById(R.id.fab_vc);
        fab = new FloatingActionButton(getApplicationContext());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        getIncomingIntent();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ArrayList<Example>> listCall = apiInterface.getOrders();

        listCall.enqueue(new Callback<ArrayList<Example>>() {
            @Override
            public void onResponse(Call<ArrayList<Example>> call, Response<ArrayList<Example>> response) {
                examples = response.body();

                voucherPagerAdapter = new VoucherPagerAdapter(examples, getApplicationContext());

                viewPager.setAdapter(voucherPagerAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {

            }
        });
    }

//    private void getIncomingIntent(){
//        if(getIntent().hasExtra("Vtxt")&&(getIntent().hasExtra("Vamt"))){
//            String vc_vtxt = getIntent().getStringExtra("Vtxt");
//            String vc_vamt = getIntent().getStringExtra("Vamt");
//
//            setVoucher(vc_vtxt, vc_vamt);
//        }
//
//    }
//
//    public void setVoucher(String vc_vtxt, String vc_vamt){
//        TextView textView = findViewById(R.id.vc_vtxt);
//        textView.setText(vc_vtxt);
//
//        TextView textView1 = findViewById(R.id.vc_vamt);
//        textView1.setText(vc_vamt);
//    }

}
