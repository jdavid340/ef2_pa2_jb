package ef2_pa2_jb.ec.edu.application.service;

import ef2_pa2_jb.ec.edu.application.interceptor.ContarAuditoria;
import ef2_pa2_jb.ec.edu.domain.model.Vehiculo;
import ef2_pa2_jb.ec.edu.infrastructure.VehiculoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VehiculoService {

    @Inject
    private VehiculoRepositoryImpl vehiculoRepositoryImpl;

    @ContarAuditoria
    public void crear(Vehiculo vehiculo) {
        vehiculoRepositoryImpl.persist(vehiculo);
    }

    @ContarAuditoria
    public void eliminar(Integer id) {
        vehiculoRepositoryImpl.deleteById(id);
    }

    public void actualizar(Integer id, Vehiculo vehiculo) {
        Vehiculo vehiculoExistente = vehiculoRepositoryImpl.findById(id);
        vehiculoExistente.setMarca(vehiculo.getMarca());
        vehiculoExistente.setModelo(vehiculo.getModelo());
        vehiculoExistente.setPlaca(vehiculo.getPlaca());

    }

    @ContarAuditoria
    public Vehiculo buscarPorPlaca(String placa) {
        return vehiculoRepositoryImpl.buscarPorPlaca(placa);
    }

    @ContarAuditoria
    public void actualiazarPorPlaca(String placa, Vehiculo vehiculo) {
        Vehiculo vehiculoExistente = vehiculoRepositoryImpl.buscarPorPlaca(placa);
        vehiculoExistente.setMarca(vehiculo.getMarca());
        vehiculoExistente.setModelo(vehiculo.getModelo());
        vehiculoExistente.setPlaca(vehiculo.getPlaca());
    }
}
