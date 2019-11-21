package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import android.util.Log;

import com.example.myapplication.API.Lst;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLocation;
    Marker marker;
    LocationRequest locationRequest;
    LocationCallback locationCallback;
    FusedLocationProviderClient mFusedClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mFusedClient = LocationServices.getFusedLocationProviderClient(this);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                mLocation = locationResult.getLastLocation();
                onLocationChanged(mLocation);
            }
        };
        onConnected(mapFragment.getArguments());
        //Check if Google Play Services Available or not
        if (!CheckGooglePlayServices()) {
            Log.d("onCreate", "Finishing test case since Google Play Services are not available");
            finish();
        } else {
            Log.d("onCreate", "Google Play Services available.");
        }
    }

    private boolean CheckGooglePlayServices() {
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);
        if (result != ConnectionResult.SUCCESS) {
            if (googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog(this, result,
                        0).show();
            }
            return false;
        }
        return true;
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        getLocation();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedClient.requestLocationUpdates(locationRequest, locationCallback, null);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLocation = location;
        if(marker != null){
            marker.remove();
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        marker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        mFusedClient.removeLocationUpdates(locationCallback);
    }

    private void getLocation(){
//        ArrayList<Result> results = new ArrayList<>(0);
        int tabPosition = getIntent().getIntExtra("tabPosition", 0);

        try {

            mMap.clear();

            ArrayList<Lst> lsts = new ArrayList<>();
            lsts = Main2Activity.results.get(tabPosition).getLst();

//            results.add(new Result(16.6780, 74.2555, "Shivaji University", "Vidyanagar"));
//            results.add(new Result(16.6927, 74.2261, "Khasbaug Maidan", "Mangalwar Peth"));
//            results.add(new Result(16.6931, 74.2308, "Shahu Stadium", "Mangalwar Peth"));
//            results.add(new Result(16.6910, 74.2250, "Kolekar Tikati", "Mangalwar Peth"));
//            results.add(new Result(16.6905, 74.2106, "Rankala Lake", "Shivaji Peth"));
//            results.add(new Result(16.6973, 74.2157, "Dudhali Pavilion", "Uttareshwar Peth"));
//            results.add(new Result(16.7039, 74.2197, "Toraskar Chowk", "Juna Budhwar Peth"));
//            results.add(new Result(16.6973, 74.2239, "Shivaji Chowk", "KMC"));

            for (int i = 0; i < lsts.size(); i++) {

                Log.d("Result", "Getting Locations...");

                MarkerOptions markerOptions = new MarkerOptions();
                LatLng latLng = new LatLng(lsts.get(i).getLat(), lsts.get(i).getLng());
                String placeName = lsts.get(i).getName();
//                String vicinity = results.get(i).getVicinity();
                // Position of Marker on Map
                markerOptions.position(latLng);
                // Adding Title to the Marker
//                markerOptions.title(placeName + " : " + vicinity);
                // Adding Marker to the Camera.
                IconGenerator iconFactory = new IconGenerator(this);
                iconFactory.setStyle(IconGenerator.STYLE_BLUE);

                Marker m = mMap.addMarker(markerOptions);
                // Adding colour to the marker
//                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(placeName)))
                        .anchor(iconFactory.getAnchorU(), iconFactory.getAnchorV());
                // move map camera
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
                mMap.addMarker(markerOptions);
            }
        } catch (Exception e) {
            Log.d("onResponse", "There is an error");
            e.printStackTrace();
        }
    }

 }


