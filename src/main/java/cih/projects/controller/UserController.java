package cih.projects.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import cih.projects.model.entity.User;
import cih.projects.model.repository.UserRepository;

@Controller
@Path("/user")
public class UserController {
	@Inject
	private Result result;
	@Inject
	private UserRepository repository;

/*
 * {
	"user": {
		"username": "admin",
		"password": "admin123",
		"confirmpwd": "admin123",
		"email": "admin@test.com",
		"confirmEmail": "admin@test.com"
		}
	}
	
	Accept: application/json
	Content-Type: application/json;charset=UTF-8
 * */
	@Get("/list")
	public void listAll() {
		result.use(Results.json()).withoutRoot().from(repository.list())
				.serialize();
	}
	
	@Consumes({"application/json","text/plain"})
	@Post("/save")
	public void save(User user) {
		try {
			System.out.println(user.toString());
			repository.objInsert(user);
			result.nothing();
		} catch (Exception e) {
			System.out.println(e);
			result.use(Results.http()).body("<h1>Error -" +e);
		}
	}
	
	@Consumes({"application/json","text/plain"})
	@Put("/update")
	public void update(User user) {
		try {
			repository.objUpdate(user);
			result.nothing();
		} catch (Exception e) {
			result.use(Results.http()).body("<h1>Error -" +e);
		}
	}
	
	@Consumes({"application/json","text/plain"})
	@Delete("/delete")
	public void delete(User user) {
		try {
			repository.objDelete(user);
			result.nothing();
		} catch (Exception e) {
			result.use(Results.http()).body("<h1>Error -" +e);
		}
	}
}
