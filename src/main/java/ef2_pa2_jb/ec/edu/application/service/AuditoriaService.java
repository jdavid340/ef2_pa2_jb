package ef2_pa2_jb.ec.edu.application.service;

import ef2_pa2_jb.ec.edu.domain.model.Auditoria;
import ef2_pa2_jb.ec.edu.infrastructure.AuditoriaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaService {

    @Inject
    private AuditoriaRepositoryImpl ar;

    public void insertar(Auditoria au) {
        this.ar.persist(au);
    }

    public void actualizar(Auditoria au) {
        Auditoria nueva = this.ar.encontrarPlaca(au.getPlaca());

        if (nueva != null) {

            nueva.setInsertar(nueva.getInsertar() + au.getInsertar());
            nueva.setSeleccinar(nueva.getSeleccinar() + au.getSeleccinar());
            nueva.setActualizar(nueva.getActualizar() + au.getActualizar());
            nueva.setEliminar(nueva.getEliminar() + au.getEliminar());
        } else {
            insertar(au);
        }
    }
}
