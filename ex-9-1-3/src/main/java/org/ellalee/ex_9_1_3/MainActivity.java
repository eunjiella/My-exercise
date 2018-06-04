package org.ellalee.ex_9_1_3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViem);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startLocationService();
            }
        });
    }
    private void startLocationService(){
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        GPSListener gpsListner = new GPSListener();
        long minTime = 10000;
        float minDistance = 0;

        try{
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistance,gpsListner);
            Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(lastLocation != null){
                Double latitude = lastLocation.getLatitude();
                Double longitude = lastLocation.getLongitude();

                textView.setText("내 위치 : "+latitude+", "+longitude);
                Toast.makeText(this, "Last K);nown Location : " + "Latitude : " + latitude + "\nLongitude:", Toast.LENGTH_SHORT).show();
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
    private class GPSListener implements LocationListener{
        @Override
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            String msg = "Latitude : "+ latitude + "\nLongitude:"+ longitude;
            Log.i("GPSListener", msg);

            textView.setText("내 위치 : "+latitude+", "+longitude);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
