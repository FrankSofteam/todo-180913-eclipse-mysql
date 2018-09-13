package endpoints;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.TodoDAO;
import model.Todo;

@Path("/todos")
public class Todos {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Todo> list() {
		return TodoDAO.list().collect(Collectors.toSet());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id_todo}")
	public Todo find(@PathParam("id_todo") Integer identifiant) {
		return TodoDAO
				.list()
				.filter(pro -> pro.getId_todo() == identifiant)
				.findFirst()
				.get();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Todo create(Todo todo) {
		return TodoDAO.create(todo);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id_todo}")
	public Response delete(@PathParam("id_todo") Integer identifiant) {
		TodoDAO.delete(identifiant);
		return Response.ok().build();
	}
}


