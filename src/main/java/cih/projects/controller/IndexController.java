package cih.projects.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {
	@Inject
	private Result result;

	@Get("/")
	public void index() {
		System.out.println(result.included().get("page"));
		System.out.println(result.included().toString());
		if (result.included().get("page") == null) {
			home();
		}
	}

	@Get("/home")
	public void home() {
		Calendar calendar = currentDate();
		result.include("date", calendar);
		result.include("meuNumero", 12);
		result.include("page_header_title", "page.header.title.home");
		result.include("page", "home.jsp");
		result.include("folder", "index");
	}

	private Calendar currentDate() {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar;
	}

	@Get("/test")
	public void other() {
		result.include("page_header_title", "page.header.title.test");
		result.include("page", "other.jsp");
		result.include("folder", "index");
		result.redirectTo(this).index();
	}
}
