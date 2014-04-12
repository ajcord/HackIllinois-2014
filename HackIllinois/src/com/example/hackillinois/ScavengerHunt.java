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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public ArrayList<Place> getPlaces() {
		return places;
	}
	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@SuppressWarnings("deprecation")
	public ScavengerHunt(String textfile)
	{
		String[] text = textfile.split(",");
		this.name = text[0];
		String[] begin = text[1].split(":");
		this.beginDate = new Date(Integer.parseInt(begin[0]), Integer.parseInt(begin[1]), 
				Integer.parseInt(begin[2]), Integer.parseInt(begin[3]), Integer.parseInt(begin[4]));
		String[] end = text[2].split(":");
		this.endDate = new Date(Integer.parseInt(end[0]), Integer.parseInt(end[1]), 
				Integer.parseInt(end[2]), Integer.parseInt(end[3]), Integer.parseInt(end[4]));
		String[] placeArr = text[3].split(":");
		ArrayList<Place> places = new ArrayList<Place>();
		for(String s : placeArr)
		{
			places.add(new Place(s));
		}
		this.id = Integer.parseInt(text[4]);
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		/*return "ScavengerHunt [name=" + name + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", places=" + places + ", id=" + id
				+ "]";*/
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(name);
		stringBuilder.append(",");
		
		stringBuilder.append(beginDate.getYear());
		stringBuilder.append(":");
		stringBuilder.append(beginDate.getMonth());
		stringBuilder.append(":");
		stringBuilder.append(beginDate.getDate());
		stringBuilder.append(":");
		stringBuilder.append(beginDate.getHours());
		stringBuilder.append(":");
		stringBuilder.append(beginDate.getMinutes());
		
		stringBuilder.append(endDate.getYear());
		stringBuilder.append(":");
		stringBuilder.append(endDate.getMonth());
		stringBuilder.append(":");
		stringBuilder.append(endDate.getDate());
		stringBuilder.append(":");
		stringBuilder.append(endDate.getHours());
		stringBuilder.append(":");
		stringBuilder.append(endDate.getMinutes());
		
		for(Place p : places)
		{
			stringBuilder.append(p.toString());
			stringBuilder.append(":");
		}
		
		stringBuilder.append(id);
		
		return stringBuilder.toString();
	}
	
	
	
	
	
}
