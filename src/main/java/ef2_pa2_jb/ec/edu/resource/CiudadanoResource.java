package ef2_pa2_jb.ec.edu.resource;

import ef2_pa2_jb.ec.edu.application.service.CiudadanoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/ciudadano")
public class CiudadanoResource {

    @Inject
    private CiudadanoService ciudadanoService;
    @POST
    @Path("/crear/{url}")
    public String crearCiudadano(@PathParam("url") String url) {
        this.ciudadanoService.crearUrl(url);
        return "Ciudadano creado con éxito";
    }
}
