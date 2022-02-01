package com.qa.games_app.data.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class POJO_Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(min = 1)
	private String g_title;

	@NotNull
	@Length(min = 1)
	private String g_genre;

	@NotNull
	@Length(min = 1)
	private String r_date;

	@NotNull
	@Length(min = 1)
	private String g_developer;

	@NotNull
	@Length(min = 1)
	private String g_producer;

	@NotNull
	@Length(min = 1)
	private String g_platform;

	// Default constructor for JPA/Hibernate
	public POJO_Game() {
		super();
	}

	// Constructor without ID
	public POJO_Game(@NotNull @Length(min = 1) String g_title, @NotNull @Length(min = 1) String g_genre,
			@NotNull @Length(min = 1) String r_date, @NotNull @Length(min = 1) String g_developer,
			@NotNull @Length(min = 1) String g_producer, @NotNull @Length(min = 1) String g_platform) {
		super();

		this.g_title = g_title;
		this.g_genre = g_genre;
		this.r_date = r_date;
		this.g_developer = g_developer;
		this.g_producer = g_producer;
		this.g_platform = g_platform;
	}

	// Constructor with ID
	public POJO_Game(Long id, @NotNull @Length(min = 1) String g_title, @NotNull @Length(min = 1) String g_genre,
			@NotNull @Length(min = 1) String r_date, @NotNull @Length(min = 1) String g_developer,
			@NotNull @Length(min = 1) String g_producer, @NotNull @Length(min = 1) String g_platform) {
		super();
		this.id = id;
		this.g_title = g_title;
		this.g_genre = g_genre;
		this.r_date = r_date;
		this.g_developer = g_developer;
		this.g_producer = g_producer;
		this.g_platform = g_platform;
	}
	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getG_title() {
		return g_title;
	}

	public void setG_title(String g_title) {
		this.g_title = g_title;
	}

	public String getG_genre() {
		return g_genre;
	}

	public void setG_genre(String g_genre) {
		this.g_genre = g_genre;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public String getG_developer() {
		return g_developer;
	}

	public void setG_developer(String g_developer) {
		this.g_developer = g_developer;
	}

	public String getG_producer() {
		return g_producer;
	}

	public void setG_producer(String g_producer) {
		this.g_producer = g_producer;
	}

	public String getG_platform() {
		return g_platform;
	}

	public void setG_platform(String g_platform) {
		this.g_platform = g_platform;
	}

// default toString override
	@Override
	public String toString() {
		return "POJO_Game [id=" + id + ", g_title=" + g_title + ", g_genre=" + g_genre + ", r_date=" + r_date
				+ ", g_developer=" + g_developer + ", g_producer=" + g_producer + ", g_platform=" + g_platform + "]";
	}

	// Auto-generated Hashcode
	
	@Override
	public int hashCode() {
		return Objects.hash(g_developer, g_genre, g_platform, g_producer, g_title, id, r_date);
	}

	// Auto-Generate equals method 
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POJO_Game other = (POJO_Game) obj;
		return Objects.equals(g_developer, other.g_developer) && Objects.equals(g_genre, other.g_genre)
				&& Objects.equals(g_platform, other.g_platform) && Objects.equals(g_producer, other.g_producer)
				&& Objects.equals(g_title, other.g_title) && Objects.equals(id, other.id)
				&& Objects.equals(r_date, other.r_date);
	}

	
	
	
	
	
	
	
}
