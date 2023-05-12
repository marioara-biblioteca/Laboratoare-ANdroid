package com.example.lab11;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.lab11.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private List<LatLng> pins=new ArrayList<>();
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(getIntent().getExtras()!=null){
            type=getIntent().getExtras().getString("type");

        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng constanta=new LatLng(44.1811361,28.5474351);
        if(type.equals("circle"))
            mMap.addCircle(new CircleOptions()
                .center(constanta)
                .radius(1000000));
        else
            mMap.addPolygon((new PolygonOptions())
                .add(new LatLng(constanta.latitude-10, constanta.longitude-10),
                        new LatLng(constanta.latitude+10, constanta.longitude-10),
                        new LatLng(constanta.latitude+10, constanta.longitude+10),
                        new LatLng(constanta.latitude-10, constanta.longitude+10)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(constanta,12));

        PolygonOptions polygonOptions=new PolygonOptions();
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng pin) {
                pins.add(pin);
                System.out.println("added new point: ("+pin.latitude+","+pin.longitude+")");
                mMap.addMarker(new MarkerOptions().position(pin));

                polygonOptions.add(pin);
                mMap.addPolygon(polygonOptions);

            }
        });



    }
}