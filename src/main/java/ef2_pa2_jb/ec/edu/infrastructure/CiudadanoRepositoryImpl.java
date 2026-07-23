package ef2_pa2_jb.ec.edu.infrastructure;

import ef2_pa2_jb.ec.edu.domain.model.Ciudadano;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CiudadanoRepositoryImpl implements PanacheRepositoryBase<Ciudadano, Integer> {

}
