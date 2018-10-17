/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import dao.UsuarioDAO;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author Henrique
 */
@Path("login")
public class LoginWS {

@Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    
    public LoginWS() {
    }

    /**
     * Retrieves representation of an instance of ws.FazendaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "meu primeiro WS RESTFULL";
    }
    
    @GET
    @Produces("application/json")
    @Path("Usuario/get/{email}/{senha}")
    public String getUsuario(@PathParam("email") String email, @PathParam("senha") String senha)
    {
        Usuario u = new Usuario();
        System.out.println("EMAIL: "+ email);
        System.out.println("SENHA: "+ senha);
        
        u.setEmail(email);
        u.setSenha(senha);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
       
        //Converter para Gson
        Gson g = new Gson();
        System.out.println("obj--- "+ u.getEmail() +" "+ u.getSenha());
        return g.toJson(u);
    }
}
