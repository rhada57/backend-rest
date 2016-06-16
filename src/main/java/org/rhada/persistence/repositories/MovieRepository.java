package org.rhada.persistence.repositories;

import java.util.List;

import org.rhada.persistences.entities.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {
	
	public List<Movie> findByName(String name);

	public List<Movie> findByRatingBetween(Double beginning, Double end);
	
}