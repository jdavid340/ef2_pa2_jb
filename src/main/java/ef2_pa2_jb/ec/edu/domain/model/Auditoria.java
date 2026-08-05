package ef2_pa2_jb.ec.edu.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Auditoria extends PanacheEntityBase{

    @Id
    private String placa;


    private Integer insertar = 0;
    private Integer eliminar = 0;
    private Integer actualizar = 0;
    private Integer seleccinar = 0;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getInsertar() {
        return insertar;
    }

    public void setInsertar(Integer insertar) {
        this.insertar = insertar;
    }

    public Integer getEliminar() {
        return eliminar;
    }

    public void setEliminar(Integer eliminar) {
        this.eliminar = eliminar;
    }

    public Integer getActualizar() {
        return actualizar;
    }

    public void setActualizar(Integer actualizar) {
        this.actualizar = actualizar;
    }

    public Integer getSeleccinar() {
        return seleccinar;
    }

    public void setSeleccinar(Integer seleccinar) {
        this.seleccinar = seleccinar;
    }


    
}

