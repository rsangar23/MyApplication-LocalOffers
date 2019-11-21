package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.API.APIClient;
import com.example.myapplication.API.APIInterface;
import com.example.myapplication.API.Example;
import com.example.myapplication.API.FinalResult;
import com.example.myapplication.API.HeadingBanner;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    public static TabLayout btmTabLayout;
    private ViewPager viewPager, offerViewPager;
    private Toolbar toolbar;
//    private PagerTabStrip pagerTabStrip;
    OfferAdapter offerAdapter;
    List<Offer> offers;
    TextView address_txt;
    ImageView logo_img;
    public static ArrayList<FinalResult> results;
    ArrayList<Example> examples;
    ModelAdapter modelAdapter;
    RecyclerView model_list;
    int tabPosition;
    public static View tabView;
//    Integer [] position = null;
//    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
private FusedLocationProviderClient fusedLocationClient;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 2;

    private LocationAddressResultReceiver addressResultReceiver;

    private Location currentLocation;

    private LocationCallback locationCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = findViewById(R.id.tool_id);
        appBarLayout = findViewById(R.id.appbrn);
        tabLayout = findViewById(R.id.tabn_id);
        btmTabLayout = findViewById(R.id.tab2_id);
        viewPager = findViewById(R.id.vpn_id);
//        pagerTabStrip = findViewById(R.id.pager_tab_strip);
        offerViewPager = findViewById(R.id.vp_sub);
         address_txt = toolbar.findViewById(R.id.tool_txt);
        logo_img = toolbar.findViewById(R.id.tool_img);
        tabView = findViewById(R.id.tabView_id);

        btmTabLayout.setVisibility(View.GONE);
        tabView.setVisibility(View.GONE);

        ActionBar actionBar = getSupportActionBar();
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);

        addressResultReceiver = new LocationAddressResultReceiver(new Handler());

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                currentLocation = locationResult.getLocations().get(0);
                getAddress();
            }
        };
        startLocationUpdates();

        address_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, PickLocation.class));
            }
        });

        logo_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, PickLocation.class));
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPosition = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        View root = btmTabLayout.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.colorAccent));
            drawable.setSize(4, 0);
            ((LinearLayout) root).setDividerPadding(10);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }

//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                offerViewPager.onTouchEvent(event);
//                return false;
//            }
//        });
//
//        offerViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                viewPager.onTouchEvent(event);
//                return false;
//            }
//        });
//
//        viewPager.setOnTouchListener(new SyncScrollOnTouchListener(offerViewPager));
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                offerViewPager.setCurrentItem(i, false);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });

//        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPagerAdapter.AddFragment(new MyFragment(), "New Offers");
//        viewPagerAdapter.AddFragment(new FragmentExplore(), "Food & Drinks");
//        viewPagerAdapter.AddFragment(new FragmentStore(), "Clothing & Fashion");

//        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);

//        MyFragment myFragment = new MyFragment(results.get(i));
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.main2_id, myFragment);
//        fragmentTransaction.commit();

//        offers = new ArrayList<>();
//        offers.add(new Offer(R.drawable.grocery));
//        offers.add(new Offer(R.drawable.food));
//        offers.add(new Offer(R.drawable.clothes));

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ArrayList<HeadingBanner>> listCall = apiInterface.getHeading();

      listCall.enqueue(new Callback<ArrayList<HeadingBanner>>() {
          @Override
          public void onResponse(Call<ArrayList<HeadingBanner>> call, Response<ArrayList<HeadingBanner>> response) {
              ArrayList<HeadingBanner> headingBanners = response.body();

              offerAdapter = new OfferAdapter(headingBanners, getApplicationContext());

              offerViewPager.setAdapter(offerAdapter);
          }

          @Override
          public void onFailure(Call<ArrayList<HeadingBanner>> call, Throwable t) {

          }
      });

        swipe();
//        getList();
        getIncomingIntent();
        setupViewPager(viewPager);

    }

    public void getIncomingIntent(){

//        Category category = (Category) Objects.requireNonNull(getIntent().getExtras()).getSerializable("DATA");
//        if (category != null) {
//            viewPager.setCurrentItem(category.getCatId());
//        }
//        tabLayout.setupWithViewPager(viewPager);
        final int i = getIntent().getIntExtra("pos", 0);
        Log.d("pos", "getIncomingIntent: " +i);
        viewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(i);
            }
        }, 1000);
//        TabLayout.Tab tab = tabLayout.getTabAt(i);
//        if (tab != null) {
//            Log.d("214", "getIncomingIntent: 214 ");
//            tab.select();
//        }

//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(i);

    }

//    public void getList(){
//
//        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
//
//        Call<FinalResult> listCall = apiInterface.getFragment();
//
//        listCall.enqueue(new Callback<FinalResult>() {
//            @Override
//            public void onResponse(Call<FinalResult> call, Response<FinalResult> response) {
//                FinalResult finalResult = response.body();
//
//                ArrayList<Lst> lsts = new ArrayList<>(0);
//
//                if (finalResult != null) {
//                    lsts = finalResult.getLst();
//                }
////                if (finalResult != null) {
////                    lsts.addAll(finalResult.getLst());
////                }
//
//                modelAdapter = new ModelAdapter(lsts, Main2Activity.this);
////                viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), categories, Main2Activity.this));
//                model_list.setAdapter(modelAdapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<FinalResult> call, Throwable t) {
//
//            }
//        });
//
//
//    }

    private void setupViewPager(final ViewPager viewPager) {

        final APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ArrayList<FinalResult>> resultCall = apiInterface.getList();

        resultCall.enqueue(new Callback<ArrayList<FinalResult>>() {
            @Override
            public void onResponse(Call<ArrayList<FinalResult>> call, Response<ArrayList<FinalResult>> response) {
                ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

               results = response.body();

                for (int i = 0; i < results.size(); i++) {
                    adapter.AddFragment(new MyFragment(results.get(i)), results.get(i).getCName());
                }
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);

                setTablayoutItemsMode(tabLayout, results);
            }

            @Override
            public void onFailure(Call<ArrayList<FinalResult>> call, Throwable t) {

            }
        });

    }

    public void setTablayoutItemsMode(TabLayout tabLayout, ArrayList<FinalResult> results) {
        if (results.size() > 3)
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        else {
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }

    }

    private void startLocationUpdates() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.setInterval(2000);
            locationRequest.setFastestInterval(1000);
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            fusedLocationClient.requestLocationUpdates(locationRequest,
                    locationCallback,
                    null);
        }
    }

    private void getAddress() {

        if (!Geocoder.isPresent()) {
            Toast.makeText(Main2Activity.this,
                    "Can't find current address, ",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, GetAddressIntentService.class);
        intent.putExtra("add_receiver", addressResultReceiver);
        intent.putExtra("add_location", currentLocation);
        startService(intent);
    }

    private class LocationAddressResultReceiver extends ResultReceiver {
        LocationAddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {

            if (resultCode == 0) {
                //Last Location can be null for various reasons
                //for example the api is called first time
                //so retry till location is set
                //since intent service runs on background thread, it doesn't block main thread
                Log.d("Address", "Location null retrying");
                getAddress();
            }

            if (resultCode == 1) {
                Toast.makeText(Main2Activity.this,
                        "Address not found, " ,
                        Toast.LENGTH_SHORT).show();
            }

            String currentAdd = resultData.getString("address_result");

            showResults(currentAdd);
        }
    }
    private void showResults(String currentAdd){
        address_txt.setText(currentAdd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocationUpdates();
    }

    @Override
    protected void onPause() {
        super.onPause();
        fusedLocationClient.removeLocationUpdates(locationCallback);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case R.id.map_loc:
//                Toast.makeText(this, "Map Icon Clicked..!", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(this, MapsActivity.class));
                Intent intent = new Intent(this, MapsActivity.class);
                intent.putExtra("tabPosition", tabPosition);
                startActivity(intent);
                return true;

            case R.id.proficon_id:
                Toast.makeText(this, "Profile Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ofr:
                Toast.makeText(this, "Offer Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.alv:
                Toast.makeText(this, "Alive Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.hlp:
                Toast.makeText(this, "Help Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.rts:
                Toast.makeText(this, "Rate us Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.rfs:
                Toast.makeText(this, "Refer friends Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.shr:
                Toast.makeText(this, "Share Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.tou:
                Toast.makeText(this, "Terms of use Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.pp:
                Toast.makeText(this, "Privacy policy Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.set:
                Toast.makeText(this, "Setting Icon Clicked..!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ver:
//                Toast.makeText(this, "Version Icon Clicked..!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MapsActivity2.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void swipe(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int scrollState = ViewPager.SCROLL_STATE_IDLE;
            // Indicates that the pager is in an idle, settled state.
            // The current page is fully in view and no animation is in progress.

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                if (scrollState == ViewPager.SCROLL_STATE_IDLE) {
                    return;
                }
                offerViewPager.scrollTo(viewPager.getScrollX()*
                        offerViewPager.getWidth()/
                        viewPager.getWidth(), 0);
                // We are not interested in Y axis position
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                scrollState = state;
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    offerViewPager.setCurrentItem(viewPager.getCurrentItem(), false);
                }
            }
        });

        offerViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int scrollState = ViewPager.SCROLL_STATE_IDLE;
            // Indicates that the pager is in an idle, settled state.
            // The current page is fully in view and no animation is in progress.

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                if (scrollState == ViewPager.SCROLL_STATE_IDLE) {
                    return;
                }
                viewPager.scrollTo(offerViewPager.getScrollX()*
                        viewPager.getWidth()/
                        offerViewPager.getWidth(), 0);
                // We are not interested in Y axis position
            }

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrollStateChanged(int state) {
                scrollState = state;
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    viewPager.setCurrentItem(offerViewPager.getCurrentItem(), false);
                }
            }
        });

    }
}
