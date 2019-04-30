package com.bean;

public class BookBean {
	private String BookId;
	private String Title;
	private String Author;
	private String Publisher;
	private float Price;
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "BookBean [BookId=" + BookId + ", Title=" + Title + ", Author="
				+ Author + ", Publisher=" + Publisher + ", Price=" + Price
				+ "]";
	}
	
}
