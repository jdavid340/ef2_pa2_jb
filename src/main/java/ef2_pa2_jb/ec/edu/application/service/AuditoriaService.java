package ef2_pa2_jb.ec.edu.application.service;

import ef2_pa2_jb.ec.edu.domain.model.Auditoria;
import ef2_pa2_jb.ec.edu.infrastructure.AuditoriaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaService {

    private AuditoriaRepositoryImpl auditoria;

    public void actualizar(Auditoria auditoria){
        Auditoria auditoriaExistente = this.auditoria.encontrarPlaca(auditoria.getPlaca());
        auditoriaExistente.setInserts(auditoria.getInserts());
        auditoriaExistente.setDelete(auditoria.getDelete());
        auditoriaExistente.setUpdate(auditoria.getInserts());
        auditoriaExistente.setseleccionar(auditoria.getseleccionar());
    }

    public Auditoria buscarPlaca(String placa){
        return this.auditoria.encontrarPlaca(placa);
    }
}
