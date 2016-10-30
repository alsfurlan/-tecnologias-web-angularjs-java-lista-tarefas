package tarefas;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/tarefas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TarefasResource {

    static List<Tarefa> tarefas = new ArrayList<>();

    @POST
    public void adicionar(Tarefa tarefa) {
        tarefa.setId(tarefas.size() + 1);
        tarefa.setConcluida(Boolean.FALSE);
        tarefas.add(tarefa);
    }

    @GET
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    @GET
    @Path("{id}")
    public Tarefa getTarefa(@PathParam("id") Integer id) {
        for (Tarefa t : tarefas) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @PUT
    @Path("{id}")
    public void atualizar(@PathParam("id") Integer id, Tarefa tarefa) {
        for (Tarefa t : tarefas) {
            if (t.getId().equals(id)) {
                t.setDescricao(tarefa.getDescricao());
                t.setConcluida(tarefa.getConcluida());
                break;
            }
        }
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") Integer id) {
        for (Tarefa t : tarefas) {
            if (t.getId().equals(id)) {
                tarefas.remove(t);
                break;
            }
        }
    }
}
