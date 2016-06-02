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
		home();
	}
	@Get("/home")
	public void home() {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		result.include("date", calendar);
		result.include("meuNumero", 12);
		result.include("page_header_title", "page.header.title.home");
		result.include("page","home.jsp");
		result.include("folder","index");
	}
}
