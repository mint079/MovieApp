package MovieApp.Movies.web;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MovieApp.Movies.domain.Movie;
import MovieApp.Movies.domain.MovieRepository;
import MovieApp.Movies.domain.CateRepository;
import MovieApp.Movies.domain.Category;
import MovieApp.Movies.domain.UserRepository;

@Controller
public class MovieController {
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private CateRepository cateRepo;

	
	@RequestMapping("/index")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/movielist")
	public String movieListPage(Model model) {
		model.addAttribute("Movies", movieRepo.findAll());
		return "movielist";
	}
	
	@RequestMapping("/addMovie")
	public String addMovie(Model model) {
		model.addAttribute("Movie", new Movie());
		model.addAttribute("Categories", cateRepo.findAll());
		return "addMovie";
	}
	
	@PostMapping("/addMovie")
	public String addMoviePOST(Movie movie) {
		movieRepo.save(movie);
		return "redirect:movielist";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteMovie(@PathVariable("id") Long movieId) {
		movieRepo.deleteById(movieId);
		return "redirect:../movielist";
	}
	
	@RequestMapping("/edit/{id}")
	public String editMovie(@PathVariable("id") Long movieId, Model model) {
		model.addAttribute("Movie", movieRepo.findById(movieId));
		model.addAttribute("Categories", cateRepo.findAll());
		return "editMovie";
	}
	
	@RequestMapping("/movieREST")
	public @ResponseBody List<Movie> movieListREST() {
		return (List<Movie>) movieRepo.findAll();
	}
	
	@RequestMapping("/movieREST/{id}")
	public @ResponseBody Optional<Movie> findMovieREST(@PathVariable("id") Long movieId) {
		return movieRepo.findById(movieId);
	}
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

}
