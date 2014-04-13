package com.example.hackillinois;

import java.util.ArrayList;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public class Calculations {
	public static double getDistance(Location start, Location end) {
		LatLng startCoords = new LatLng(start.getLatitude(), start.getLongitude());
		LatLng endCoords = new LatLng(end.getLatitude(), end.getLongitude());
		Location startLoc = new Location("");
		startLoc.setLatitude(startCoords.latitude);
		startLoc.setLongitude(startCoords.longitude);
		Location endLoc = new Location("");
		endLoc.setLatitude(endCoords.latitude);
		endLoc.setLongitude(endCoords.longitude);
		return startLoc.distanceTo(endLoc);
	}

	public static Place getNearestLocation(Location myLocation,
			ArrayList<Place> locations) {
		Place nearest = locations.get(0);
		Location nearestLoc = new Location("");
		nearestLoc.setLatitude(nearest.getCoords().latitude);
		nearestLoc.setLongitude(nearest.getCoords().longitude);
		for (int i = 0; i < locations.size(); i++) {
			Place target = locations.get(i);
			Location targetLoc = new Location("");
			targetLoc.setLatitude(target.getCoords().latitude);
			targetLoc.setLongitude(target.getCoords().longitude);
			if (getDistance(myLocation, targetLoc) < getDistance(myLocation, nearestLoc)) {
				nearest = target;
				nearestLoc = targetLoc;
			}
		}
		return nearest;
	}

	public static double getAngle(double currentAngle, Location myLocation,
			Place target) {
		LatLng locCoords = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
		LatLng targetCoords = target.getCoords();
		double lX = locCoords.latitude;
		double lY = locCoords.longitude;
		double tX = targetCoords.latitude;
		double tY = targetCoords.longitude;
		double dX = (lX - tX);
		double dY = (lY - tY);
		double angle = Math.toDegrees(Math.atan2(dX, dY));
		return angle - currentAngle;
	}

}
