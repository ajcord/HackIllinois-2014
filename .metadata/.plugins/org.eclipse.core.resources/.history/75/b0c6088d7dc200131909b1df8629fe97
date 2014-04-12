package com.example.hackillinois;

import com.google.android.gms.maps.model.LatLng;


public class Place 
{
	

	private String name;
	private boolean hasBeen;
	private LatLng coords;
	private String description;
	private String hint;
	


	public Place(String name, boolean hasBeen, LatLng coords,
			String description, String hint) {
		super();
		this.name = name;
		this.hasBeen = hasBeen;
		this.coords = coords;
		this.description = description;
		this.hint = hint;
	}
	
	public Place (String str) {
		super();
		String[] place = str.split(".");
		this.name = place[0];
		this.hasBeen = place[1].equals("True");
		this.coords = new LatLng(Double.parseDouble(place[2]),Double.parseDouble(place[3]));
		this.description = place[4];
		this.hint = place[5];
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getHasBeen() {
		return hasBeen;
	}

	public void setHasBeen(boolean hasBeen) {
		this.hasBeen = hasBeen;
	}

	public LatLng getCoords() {
		return coords;
	}

	public void setCoords(LatLng coords) {
		this.coords = coords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}
	
	@Override
	public String toString() {
		StringBuilder StringBuilder = new StringBuilder();
		
		StringBuilder.append(name);
		StringBuilder.append(".");
		
		StringBuilder.append(hasBeen);
		StringBuilder.append(".");
		
		StringBuilder.append(coords.latitude);
		StringBuilder.append(".");
		
		StringBuilder.append(coords.longitude);
		StringBuilder.append(".");
		
		StringBuilder.append(description);
		StringBuilder.append(".");
		
		StringBuilder.append(hint);
		StringBuilder.append(".");
		
		return StringBuilder.toString();
		
	}
	
	
}
