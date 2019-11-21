package com.example.myapplication;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager, offerViewPager;
    OfferAdapter offerAdapter;
    List<Offer> offers;
//    Integer [] drawables = null;
//    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_id);
        appBarLayout = findViewById(R.id.appbr);
        viewPager = findViewById(R.id.vp_id);


//        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPagerAdapter.AddFragment(new MyFragment(), "New Offers");
//        viewPagerAdapter.AddFragment(new FragmentExplore(), "Food & Drinks");
//        viewPagerAdapter.AddFragment(new FragmentStore(), "Clothing & Fashion");
//
//
//        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);

//        MyFragment myFragment = new MyFragment(results.get(i));
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.main_id, myFragment);
//        fragmentTransaction.commit();

//        offers = new ArrayList<>();
//        offers.add(new Offer(R.drawable.grocery));
//        offers.add(new Offer(R.drawable.food));
//        offers.add(new Offer(R.drawable.clothes));
//
//        offerAdapter = new OfferAdapter(offers, this);

        offerViewPager = findViewById(R.id.vpo_id);
        offerViewPager.setAdapter(offerAdapter);
//        offerViewPager.setPadding(130,0,130,0);
//        Integer[] offer_temp = {
//                R.drawable.grocery,
//                R.drawable.food,
//                R.drawable.clothes
//        };

//        drawables = offer_temp;
//
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (position < (viewPagerAdapter.getCount() - 1) && (position < (drawables.length - 1))) {
//                    viewPager.setPageMarginDrawable((Integer) argbEvaluator.evaluate(positionOffset,
//                            drawables[position],
//                            drawables[position + 1]));
//                }
//            }
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//
//        });

        }

    }


