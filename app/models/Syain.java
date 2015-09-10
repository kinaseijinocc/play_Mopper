package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.data.validation.*;
@Entity

public class Syain extends Model {

	@Id
	public Long id;

	@Constraints.MaxLength(20)
	public String name;

	public static Finder<Long, Syain>find = new Finder<Long, Syain>(Long.class, Syain.class);

}
