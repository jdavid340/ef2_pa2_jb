package ef2_pa2_jb.ec.edu.resource;

import ef2_pa2_jb.ec.edu.application.service.VehiculoService;
import ef2_pa2_jb.ec.edu.domain.model.Vehiculo;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/vehiculo")
public class VehiculoResource {

    @Inject
    private VehiculoService vehiculoService;

    @PUT
    @Path("/actualizar/{placa}")
    public void actualizarVehiculo(@PathParam("placa") String placa, Vehiculo vehiculo) {
        this.vehiculoService.actualiazarPorPlaca(placa, vehiculo);
    }

    @POST
    @Path("/crear")
    public void crearVehiculo(Vehiculo vehiculo) {
        this.vehiculoService.crear(vehiculo);
    }

    @GET
    @Path("/buscar/{placa}")
    public Vehiculo buscarPlaca(@PathParam("placa") String placa) {
        return this.vehiculoService.buscarPorPlaca(placa);
    }
}
