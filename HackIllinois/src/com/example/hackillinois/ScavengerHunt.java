package com.example.hackillinois;

import java.util.ArrayList;
import java.util.Date;

public class ScavengerHunt 
{
	private String name;
	private Date beginDate;
	private Date endDate;
	private ArrayList<Place> places;
	private int id;

	public ScavengerHunt(String name, Date beginDate, Date endDate,
			ArrayList<Place> places, int id) {
		super();
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.places = places;
		this.id = id;
	}
	
	
}
