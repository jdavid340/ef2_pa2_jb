package ef2_pa2_jb.ec.edu.infrastructure;

import ef2_pa2_jb.ec.edu.domain.model.Auditoria;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public class AuditoriaRepositoryImpl implements PanacheRepositoryBase<Auditoria, Integer> {

    public Auditoria encontrarPlaca(String placa) {
        return find("placa", placa).firstResult();
    }

}
