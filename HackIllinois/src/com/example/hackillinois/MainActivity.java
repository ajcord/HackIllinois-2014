package com.example.hackillinois;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
	
	private GoogleMap map;
	private ViewSwitcher switcher;
	private Camera cam;
	private CameraPreview preview;
	private CameraActivity activity;
	private SurfaceHolder holder;

    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	//Create the scavenger hunt object
    	ArrayList<Place> places = new ArrayList<Place>();
    	places.add(new Place("Siebel Center for Computer Science", false, new LatLng(40.113678, -88.224868),
    			"", ""));
    	places.add(new Place("Digital Computer Laboratory", false, new LatLng(40.113028, -88.225880),
    			"", ""));
    	Date startDate = new Date();
    	startDate.setTime(Date.UTC(2014, 3, 11, 22, 0, 0));
    	Date endDate = new Date();
    	endDate.setTime(Date.UTC(2014,  4,  13,  10,  0,  0));
    	ScavengerHunt hackIllinoisSH = new ScavengerHunt("HackIllinois Scavenger Hunt",
    			startDate, endDate, places, 42);
    	
    	//Set up the map fragment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ViewSwitcher handling
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher1);
		//Button handler setup
		Button navButton = (Button) findViewById(R.id.navButton);
        navButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Refresh.sendEmptyMessage(2);
            }
        });
		Button mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Refresh.sendEmptyMessage(1);
            }
        });
        //Display the name of the scavenger hunt
    	TextView label = (TextView) findViewById(R.id.scavengerHuntName);
    	label.setText(hackIllinoisSH.getName());
		//Setup map
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);
        
        if (map != null) {
        	//Add the places markers to the map
        	for (int i = 0; i < places.size(); i++) {
        		Place place = places.get(i);
        		map.addMarker(new MarkerOptions().position(place.getCoords()).title(place.getName()));
        	}
        };
        
        //Request receiving location updates
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
        	public void onLocationChanged(Location location) {
        		//doSomethingWithLocation(location);
        		//LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                //map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        	}
        	
        	public void onStatusChanged(String provider, int status, Bundle extras) {}
        	public void onProviderEnabled(String provider) {}
        	public void onProviderDisabled(String provider) {}
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        
        
        //Get the last known user location and zoom there
        Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        LatLng lastKnownLatLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lastKnownLatLng, 10));
        map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        
        //Setup device camera
//        try {
//        	activity = new CameraActivity();
//            cam = Camera.open();//activity.getCameraInstance();
//            cam.unlock();
//            preview = new CameraPreview(this,cam);
//            holder = preview.getSurface();
//			cam.setPreviewDisplay(holder);
			
			
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        
    }
 
	// Refresh handler, necessary for updating the UI in a/the thread
	Handler Refresh = new Handler(){
		public void handleMessage(Message msg) {
			
			switch(msg.what){
			
			case 2:
				startActivity(new Intent(MainActivity.this, CameraActivity.class));
//				switcher.showNext();
//				try{cam.startPreview();}
//				catch(Exception e){ System.out.println("Camera failed to turn on: "+e.getMessage());}
//				System.out.println("Turning On Camera");
				break;
			case 1:
				switcher.showPrevious();
				//cam.stopPreview();
				System.out.println("Turning Off Camera");
			default:
				break;
			}
		}
	};
}