package ef2_pa2_jb.ec.edu.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="auditoria")
public class Auditoria extends PanacheEntityBase{

    @Id
    @SequenceGenerator(name="seq_auditoria", sequenceName="seq_auditoria", allocationSize=0)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_auditoria")
    private Integer id;

    private Integer inserts;

    private Integer delete;

    private Integer update;

    private Integer seleccionar;
    private String placa;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInserts() {
        return inserts;
    }

    public void setInserts(Integer inserts) {
        this.inserts = inserts;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Integer getUpdate() {
        return update;
    }

    public void setUpdate(Integer update) {
        this.update = update;
    }

    public Integer getseleccionar() {
        return seleccionar;
    }

    public void setseleccionar(Integer seleccionar) {
        this.seleccionar = seleccionar;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
}
