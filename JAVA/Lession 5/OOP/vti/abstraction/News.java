package vti.abstraction;

import java.util.Arrays;

public class News implements INews {
	private int ID;
	private String Title;
	private String publishDate;
	private String Author;
	private String Content;
	private float AverageRate;
	private int[] Rates;
	
	public News(int iD, String title, String publishDate, String author, String content, float averageRate) {
		super();
		ID = iD;
		Title = title;
		this.publishDate = publishDate;
		Author = author;
		Content = content;
		AverageRate = averageRate;
		
	}
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public float getAverageRate() {
		return AverageRate;
	}
	
	public void setRate(int[] rates) {
		this.Rates =rates;
	}
	
	@Override
	public float Calculate() {
		int sum = 0;
		for (int i = 0; i < Rates.length; i++) {
			sum += Rates[i];
		}
		AverageRate = (float) sum / Rates.length;
		return AverageRate;
	}

	@Override
	public void Display() {
		System.out.println("Title: "+ Title);
		System.out.println("publishDate: "+ publishDate);
		System.out.println("Author: "+ Author);
		System.out.println("Content: "+ Content);
		System.out.println("AverageRate: "+ AverageRate);
	}

	@Override
	public String toString() {
		return "News [ID=" + ID + ", Title=" + Title + ", publishDate=" + publishDate + ", Author=" + Author
				+ ", Content=" + Content + ", AverageRate=" + AverageRate + ", Rates=" + Arrays.toString(Rates) + "]";
	}
	
	
	
}