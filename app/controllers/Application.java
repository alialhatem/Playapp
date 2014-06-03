package controllers;
//import java.text.Normalizer.Form;

import com.typesafe.config.ConfigException.Parse;

import models.*;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import play.api.data.*;

public class Application extends Controller {
	static Form<Equation> taskForm = Form.form(Equation.class);
	static String result="Hello";
    public static Result index() {
        return ok(index.render(result));
    }
 
	public static Result solve() {
		Equation filledForm = taskForm.bindFromRequest().get();
 	
double a=filledForm.a;
double b=filledForm.b;
double c=filledForm.c;
double delta = Math.sqrt(b * b - 4 * a * c);
if (delta>0){
double root1 = (-b +  delta) / (2*a) ;
double root2 = (-b -  delta) / (2*a) ;
result="sloution1="+root1+" solution2="+root2;

}
else 
	result="equation has no solutions";
return redirect(routes.Application.index());
}
	
}