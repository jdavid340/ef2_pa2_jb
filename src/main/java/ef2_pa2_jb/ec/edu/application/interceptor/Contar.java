package ef2_pa2_jb.ec.edu.application.interceptor;

import ef2_pa2_jb.ec.edu.application.service.AuditoriaService;
import ef2_pa2_jb.ec.edu.domain.model.Auditoria;
import ef2_pa2_jb.ec.edu.domain.model.Vehiculo;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@ContarAuditoria
public class Contar {


    @Inject
    private AuditoriaService as;

    @AroundInvoke
    public Object intercepto(InvocationContext ctx) throws Exception {
        Auditoria nuevaAuditoria = new Auditoria();
        Object[] parametros = ctx.getParameters();
        String metodo = ctx.getMethod().getName();

        if (metodo.equals("crear")) {
            Vehiculo v = (Vehiculo) parametros[0];
            nuevaAuditoria.setPlaca(v.getPlaca());
            nuevaAuditoria.setInsertar(1);
        } else if (metodo.equals("actualizar")) {
            Vehiculo v = (Vehiculo) parametros[0];
            nuevaAuditoria.setPlaca(v.getPlaca());
            nuevaAuditoria.setActualizar(1);
        } else if (metodo.equals("buscar")) {
            String v = (String) parametros[0];
            nuevaAuditoria.setPlaca(v);
            nuevaAuditoria.setSeleccinar(1);
        } else {
            String v = (String) parametros[0];
            nuevaAuditoria.setPlaca(v);
            nuevaAuditoria.setEliminar(1);
        }

        this.as.actualizar(nuevaAuditoria);
        Object resultado = ctx.proceed();
        return resultado;

    }
}
