package ef2_pa2_jb.ec.edu.infrastructure;

import ef2_pa2_jb.ec.edu.domain.model.Vehiculo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VehiculoRepositoryImpl  implements PanacheRepositoryBase<Vehiculo, Integer>{
    
    public Vehiculo buscarPorPlaca(String placa){
        return find("vehi_placa", placa).firstResult();
    }
        

}
