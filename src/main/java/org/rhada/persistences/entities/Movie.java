package org.rhada.persistences.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "elastic_sample", type = "movie")
public class Movie {

	@Id
	private String id;

	private String name;

	@Field(type = FieldType.Nested)
	private List<Genre> genres;

	private Double criticRating;

	public Double getCriticRating() {
		return criticRating;
	}

	public void setCriticRating(Double criticRating) {
		this.criticRating = criticRating;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Movie{" + "id=" + id + ", name='" + name + '\'' + ", genres="
				+ genres + ", criticRating=" + criticRating + '}';
	}

}