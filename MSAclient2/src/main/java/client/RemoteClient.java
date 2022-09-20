/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client;





import entity.Book;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author Jinal
 */
@RegisterRestClient(configKey="rclient")
public interface RemoteClient {
    
    /**
     *
     * @return
     */
    @RolesAllowed("Admin")
    @GET
    @Path("getAllbook")
    @Produces(MediaType.APPLICATION_JSON)
    
    @ClientHeaderParam(name="authorization",value="{generateJWTToken}")
    public Collection<Book> getAllbook();
    default String generateJWTToken()
    {
        Config config = ConfigProvider.getConfig();
        String token = config.getValue("jwt-String", String.class);
       String authtoken ="Bearer" +token;
        
        return authtoken;
    }

}
