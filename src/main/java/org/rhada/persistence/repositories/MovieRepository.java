package org.rhada.persistence.repositories;

import java.util.List;

import org.rhada.persistences.entities.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {
	
	public List<Movie> findByName(String name);

	
}