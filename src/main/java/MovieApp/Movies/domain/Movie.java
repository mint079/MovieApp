package MovieApp.Movies.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String director;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startingDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endingDate;
	private Float price;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryId")
	private Category category;
	
	public Movie() {}
	
	public Movie(String title, String director, LocalDate startingDate, LocalDate endingDate, Float price, Category category) {
		this.title = title;
		this.director = director;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.price = price;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "title: " + title + "director: " + director +"starting date: " +startingDate +"ending date: "+endingDate + " category: " + category;
	}
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return director;
	}
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public LocalDate getEndingDate() {
		return endingDate;
	}
	public Float getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	public void setEdingDate(LocalDate endingDate) {
		this.endingDate= endingDate;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
