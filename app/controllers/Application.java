package controllers;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import models.MyForm;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	Form<MyForm> form = Form.form(MyForm.class);
    	MyForm my = new MyForm();
    	my.name = "";
    	my.os = MyForm.WIN;
    	my.num = 50;
    	form = form.fill(my);
        return ok(index.render(form,"フォームを入力してください。"));
    }

    public static Result index2() {
    	Form<MyForm> myForm = Form.form(MyForm.class).bindFromRequest();
    	String msg = "";
    	if(!myForm.hasErrors()) {
    		Map<String,String> result = new LinkedHashMap<>();
        	result.put("name", myForm.get().name);
        	result.put("password", myForm.get().password);
        	result.put("check", String.valueOf(myForm.get().checked));
        	result.put("os", String.valueOf(myForm.get().os));
        	result.put("country", String.valueOf(myForm.get().country));
        	result.put("area", String.valueOf(myForm.get().area));
        	result.put("date", String.valueOf(myForm.get().date));
        	result.put("num", String.valueOf(myForm.get().num));
        	msg += "value: ";
        	for(String key : result.keySet()) {
        		msg += key + " : " + result.get(key) + " , ";
        	}
    	}	else	{
    		msg = "ERROR";
    	}
        return ok(index.render(myForm,msg));
    }
}