package com.qa.games_app.data.entity;

import java.util.Objects;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity

public class Games {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	@Length(min = 1)
	private String gTitle;

	@Column
	@NotNull
	@Length(min = 1)
	private String gGenre;

	@Column
	@NotNull
	@Length(min = 1)
	private String rDate;

	@Column
	@NotNull
	@Length(min = 1)
	private String gDeveloper;

	@Column
	@NotNull
	@Length(min = 1)
	private String gProducer;

	@Column
	@NotNull
	@Length(min = 1)
	private String gPlatform;

	// Default constructor for JPA/Hibernate
	public Games() {
		super();
	}

	// Constructor without ID
	public Games(@NotNull @Length(min = 1) String gTitle, @NotNull @Length(min = 1) String gGenre,
			@NotNull @Length(min = 1) String rDate, @NotNull @Length(min = 1) String gDeveloper,
			@NotNull @Length(min = 1) String gProducer, @NotNull @Length(min = 1) String gPlatform) {
		super();

		this.gTitle = gTitle;
		this.gGenre = gGenre;
		this.rDate = rDate;
		this.gDeveloper = gDeveloper;
		this.gProducer = gProducer;
		this.gPlatform = gPlatform;
	}

	// Constructor with ID
	public Games(Long id, @NotNull @Length(min = 1) String gTitle, @NotNull @Length(min = 1) String gGenre,
			@NotNull @Length(min = 1) String rDate, @NotNull @Length(min = 1) String gDeveloper,
			@NotNull @Length(min = 1) String gProducer, @NotNull @Length(min = 1) String gPlatform) {
		super();
		this.id = id;
		this.gTitle = gTitle;
		this.gGenre = gGenre;
		this.rDate = rDate;
		this.gDeveloper = gDeveloper;
		this.gProducer = gProducer;
		this.gPlatform = gPlatform;
	}
	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getgTitle() {
		return gTitle;
	}

	public void setgTitle(String gTitle) {
		this.gTitle = gTitle;
	}

	public String getgGenre() {
		return gGenre;
	}

	public void setgGenre(String gGenre) {
		this.gGenre = gGenre;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getgDeveloper() {
		return gDeveloper;
	}

	public void setgDeveloper(String gDeveloper) {
		this.gDeveloper = gDeveloper;
	}

	public String getgProducer() {
		return gProducer;
	}

	public void setgProducer(String gProducer) {
		this.gProducer = gProducer;
	}

	public String getgPlatform() {
		return gPlatform;
	}

	public void setgPlatform(String gPlatform) {
		this.gPlatform = gPlatform;
	}

// default toString override
	@Override
	public String toString() {
		return "Games [id=" + id + ", gTitle=" + gTitle + ", gGenre=" + gGenre + ", rDate=" + rDate
				+ ", gDeveloper=" + gDeveloper + ", gProducer=" + gProducer + ", gPlatform=" + gPlatform + "]";
	}

	// Auto-generated Hashcode
	
	@Override
	public int hashCode() {
		return Objects.hash(gDeveloper, gGenre, gPlatform, gProducer, gTitle, id, rDate);
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
		Games other = (Games) obj;
		return Objects.equals(gDeveloper, other.gDeveloper) && Objects.equals(gGenre, other.gGenre)
				&& Objects.equals(gPlatform, other.gPlatform) && Objects.equals(gProducer, other.gProducer)
				&& Objects.equals(gTitle, other.gTitle) && Objects.equals(id, other.id)
				&& Objects.equals(rDate, other.rDate);
	}

	
	
	
	
	
	
	
}
