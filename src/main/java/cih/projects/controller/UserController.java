package cih.projects.controller;

import javax.inject.Inject;

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

	@Get("/list")
	public void listAll() {
		result.use(Results.json()).withoutRoot().from(repository.list())
				.serialize();
	}

	@Post("/save")
	public void save(User user) {
		try {
			repository.objInsert(user);
		} catch (Exception e) {
		
		}
	}

	@Put("/update")
	public void update(User user) {
		try {
			repository.objUpdate(user);
		} catch (Exception e) {

		}
	}

	@Delete("/delete")
	public void delete(User user) {
		try {
			repository.objDelete(user);
		} catch (Exception e) {

		}
	}
}
