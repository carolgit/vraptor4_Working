package cih.projects.controller;

import javax.inject.Inject;

import cih.projects.model.repository.UserRepository;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

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
}
