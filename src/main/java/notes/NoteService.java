package notes;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

@Path("/notes")
public class NoteService {

    private final CopyOnWriteArrayList<Note> nList = NoteList.getInstance();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
        Gson gson = new Gson();

        return gson.toJson(nList);
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNote(Note note){
        nList.add(note);
        return Response.status(201).build();
    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteNote(@PathParam("id") UUID id){
       Predicate <Note> note = n -> n.getId().equals(id);

        if (nList.removeIf(note)) {
            return Response.status(Response.Status.OK).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNote(Note note){
        int matchIdx;
        Note originNote;
        Optional<Note> match = nList.stream()
                .filter(n -> n.getId().equals(note.getId()))
                .findFirst();

        if (match.isPresent()) {
            matchIdx = nList.indexOf(match.get());
            originNote = nList.get(matchIdx);
            originNote.setTitle(note.getTitle());
            originNote.setText(note.getText());
            originNote.setDateUpdate(note.getDateUpdate());
            nList.set(matchIdx, originNote);
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
