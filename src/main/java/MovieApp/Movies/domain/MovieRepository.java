package MovieApp.Movies.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MovieRepository extends CrudRepository<Movie, Long> {
	List<Movie> findAll();
	
	List<Movie> findByTitle(String title);
	
	Optional<Movie> findById(Long id);
	
	List<Movie> findByDirector(@Param("director") String director);
}
