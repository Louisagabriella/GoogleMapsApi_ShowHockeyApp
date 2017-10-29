package com.example.louisagabriella.googlemapsapi_showhockeyapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition BLITAR = CameraPosition.builder()
            .target(new LatLng(-8.095463, 112.160906))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions Tulungagung;
    MarkerOptions Kediri;
    MarkerOptions Pare;
    MarkerOptions Wlingi;
    MarkerOptions Blitar;

    @Override
    public Resources getResources() {
        return super.getResources();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tulungagung = new MarkerOptions()
                .position(new LatLng(-8.091221, 111.964173))
                .title("Tulungagung")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Kediri = new MarkerOptions()
                .position(new LatLng(-7.848016, 112.017829))
                .title("Kediri")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Pare = new MarkerOptions()
                .position(new LatLng(-7.765512, 112.197899))
                .title("Pare")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Wlingi = new MarkerOptions()
                .position(new LatLng(-8.129380, 112.320999))
                .title("Wlingi")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Blitar = new MarkerOptions()
                .position(new LatLng(-8.095463, 112.160906))
                .title("Blitar")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(Tulungagung);
        m_map.addMarker(Kediri);
        m_map.addMarker(Pare);
        m_map.addMarker(Wlingi);
        m_map.addMarker(Blitar);
        flyTo(BLITAR);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
