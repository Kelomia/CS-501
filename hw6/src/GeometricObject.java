import java.util.*;

abstract class GeometricObject{
	private java.util.Date dateCreated;
	private String color ="white";
	private boolean filled;
	
	protected GeometricObject(String color,boolean Fill){
		this.color=color;
		this.filled=Fill;
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(){
		dateCreated = new java.util.Date();
		}
	
	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color=color;
	}
	
	public boolean isFilled(){
		return filled;
	}
	public void setFilled(boolean filled){
		this.filled=filled;
	}
	public Date getDateCreated(){
		return dateCreated;
	}
}