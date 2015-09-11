package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Place;
import models.Syain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public static Result place(){
    	List<Place> placeList = Place.find.all();
    	return ok(place.render(placeList,placeForm));
    }

    public static Result insert_place() {
    	Form<Place> form = placeForm.bindFromRequest();


    	if (form.hasErrors()) {
    		List<Place> placeList = Place.find.all();

            // 制約エラーが発生したら、その情報を持つ form を渡してあげる
            return badRequest(place.render(placeList, form));

        } else {
            Place newPlace = form.get();
            newPlace.save();
            return redirect(routes.Application.place());
        }

    }
}
