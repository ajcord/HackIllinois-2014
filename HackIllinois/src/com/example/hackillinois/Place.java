package com.example.hackillinois;

import android.R.bool;
import android.R.string;

public class Place 
{
	private string name;
	private bool hasBeen;
	private Coordinate coords;
	private string description;
	private string hint;
	


	public Place(string name, bool hasBeen, Coordinate coords,
			string description, string hint) {
		super();
		this.name = name;
		this.hasBeen = hasBeen;
		this.coords = coords;
		this.description = description;
		this.hint = hint;
	}

	public string getName() {
		return name;
	}

	public void setName(string name) {
		this.name = name;
	}

	public bool getHasBeen() {
		return hasBeen;
	}

	public void setHasBeen(bool hasBeen) {
		this.hasBeen = hasBeen;
	}

	public Coordinate getCoords() {
		return coords;
	}

	public void setCoords(Coordinate coords) {
		this.coords = coords;
	}

	public string getDescription() {
		return description;
	}

	public void setDescription(string description) {
		this.description = description;
	}

	public string getHint() {
		return hint;
	}

	public void setHint(string hint) {
		this.hint = hint;
	}
	
	
	
	
}
