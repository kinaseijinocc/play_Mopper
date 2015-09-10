package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Syain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import play.*;
import play.db.DB;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }


    public static Result syain(){
    	Syain s = new Syain();
    	s.name = "Aさん";
    	s.save();
    	return ok(syain.render("Aさん"));
    }
}
