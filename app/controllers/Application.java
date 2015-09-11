package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Place;
import models.Syain;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import play.*;
import play.data.Form;
import play.db.DB;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static Form<Place> placeForm = Form.form(Place.class);


    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }


    public static Result syain(){
    	Syain s = new Syain();
    	s.name = "Aさん";
    	s.save();
    	return ok(syain.render("Aさん"));
    }

    public static Result place() {
    	List<Place> placeList = Place.find.all();
    	return ok(place.render(placeList));
    }



    public static Result insert_place() {
    	Form<Place> form = placeForm.bindFromRequest();
    	 Place newTask = form.get();
         newTask.save();

            return redirect(routes.Application.place());


    }
    public static Result select(){
    	HashMap<String,String> map = new HashMap<String,String>();
    	Place task = new Place();

    	task.name = "fsf";
    	task.save();

    	List<Place> placeList = Place.find.all();

    	for(Place place :Place.find.all()){
    		map.put(place.id.toString(),place.name);
    	}

    	return ok(setPlace.render(placeList,placeForm,map));

    }
    public static Result update_place(){
    	Form<Place> form = placeForm.bindFromRequest();


            return redirect(routes.Application.place());

    }
}
