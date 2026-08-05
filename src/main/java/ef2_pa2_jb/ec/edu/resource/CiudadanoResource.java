package ef2_pa2_jb.ec.edu.resource;

import ef2_pa2_jb.ec.edu.application.service.CiudadanoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/ciudadano")
public class CiudadanoResource {

    @Inject
    private CiudadanoService ciudadanoService;
    @POST
    
    @Path("/crear")
    public String crearCiudadano( String url) {
        this.ciudadanoService.crearURL(url);
        return "Ciudadano creado con éxito";
    }
}
