package com.cisco.iask.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

/**
 * Created by sarthiya on 21/04/16.
 */
@Entity("questions")
@Indexes(
	    @Index(value = "title", fields = @Field("title"))
	)
public class Question {

    /**
     * Entity's unique identifier.
     */
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private String username;
    private long answers;
  //  private Date dateTime;

    /**
     * A no-argument constructor.
     */
    public Question() {
    }
    
    public Question(ObjectId id, String title, String description, String username,
                    long answers /*, Date dateTime*/) {
        this.title = title;
        this.description = description;
        this.username = username;
        this.answers = answers;
        this.id = id;
        //this.dateTime = dateTime;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getAnswers() {
		return answers;
	}

	public void setAnswers(long answers) {
		this.answers = answers;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

}
