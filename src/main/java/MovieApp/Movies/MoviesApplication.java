package MovieApp.Movies;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import for logging activities

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import MovieApp.Movies.domain.Movie;
import MovieApp.Movies.domain.MovieRepository;
import MovieApp.Movies.domain.CateRepository;
import MovieApp.Movies.domain.Category;
import MovieApp.Movies.domain.User;
import MovieApp.Movies.domain.UserRepository;


@SpringBootApplication
public class MoviesApplication {

	private static final Logger log = LoggerFactory.getLogger(MoviesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository movieRepo, CateRepository cateRepo, UserRepository userRepo) {
		return (args) -> {
			
			log.info(">>test data injection");
			log.info("Category data");
			Category cate1 = new Category("Action");
			Category cate2 = new Category("Comedy");
			
			cateRepo.save(cate1);
			cateRepo.save(cate2);
			LocalDate localDate1 = LocalDate.of(2019, 1, 31);
			LocalDate localDate2 = LocalDate.of(2019, 12, 31);
			log.info("Movie data");
			Movie movie1 = new Movie("Peter Pan", "Noah",localDate1 , localDate2, (float) 10.00, cate1);
			Movie movie2 = new Movie("How to fly", "Micheal",localDate1 , localDate2, (float) 10.00, cate2);
			Movie movie3 = new Movie("Infinity War", "Noone", localDate1, localDate2, (float) 15.00, cate1);
			
			movieRepo.save(movie1);
			movieRepo.save(movie2);
			movieRepo.save(movie3);
			
			log.info("User data");
			// test user role:USER id:user pw:password
			User user1 = new User("user", "$2a$10$NlvPgFjQ0gaWaUrvnYothOeFgRkmS22SiYfNac/M1eucq2LbD8o5G", "", "USER");
			// test user role:ADMIN id:admin pw:admin
			User admin1 = new User("admin", "$2a$10$gosnLht4KLxiTlg4NFY5reGutRy4OJ0Sli4rzcVkkJQrfU/R7qnH6", "admin@movie.mv", "ADMIN");

			userRepo.save(user1);
			userRepo.save(admin1);
			
			log.info("Current users in db:");
			for (User user : userRepo.findAll()) {
				log.info(user.toString());
			}
		};
	}

}
