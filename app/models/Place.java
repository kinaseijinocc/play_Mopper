package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Place extends Model {

	@Id
	public Integer id;


	public String name;

	public static Finder<Integer, Place> find = new Finder<Integer, Place>(
			 Integer.class, Place.class);
}
