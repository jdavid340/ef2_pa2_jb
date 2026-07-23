package ef2_pa2_jb.ec.edu.application.interceptor;

import ef2_pa2_jb.ec.edu.application.service.AuditoriaService;
import ef2_pa2_jb.ec.edu.domain.model.Auditoria;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@ContarAuditoria
public class Contar {


    @Inject
    private AuditoriaService auditoriaService;

    
    @AroundInvoke
    public Object contar(InvocationContext ctx) throws Exception {
        String nombreMetodo = ctx.getMethod().getName();
        Object[] parametros = ctx.getParameters();
        Object resultado=ctx.proceed();

        Auditoria auditado=this.auditoriaService.buscarPlaca((String) parametros[0]);
        
        if(nombreMetodo.equals("crear")) {
            auditado.setInserts(auditado.getInserts()+1);
        } else if (nombreMetodo.equals("actualiazarPorPlaca")) {
            auditado.setUpdate(auditado.getUpdate()+1);
        } else if (nombreMetodo.equals("buscarPorPlaca")) {
            auditado.setseleccionar(auditado.getseleccionar()+1);
        }else if(nombreMetodo.equals("eliminar")){
            auditado.setDelete(auditado.getDelete()+1);
        }

        this.auditoriaService.actualizar(auditado);

        return resultado;
    }
}
