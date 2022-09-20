package ictmsa.practice.service;

import entity.Book;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.DataBean;

@Path("/example")
public class ExampleService {

    @Inject DataBean db;
    
    @GET
    @Path("getallbook")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Book>getAllbook(){
        return db.getAllbook();
    }

}
