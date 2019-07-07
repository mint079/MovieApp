package MovieApp.Movies.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	private List<Movie> movies;
	
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id: " + categoryId + " name: " + name;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	public String getName() {
		return name;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}	