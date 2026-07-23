package ef2_pa2_jb.ec.edu.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import ef2_pa2_jb.ec.edu.domain.model.Ciudadano;
import ef2_pa2_jb.ec.edu.infrastructure.CiudadanoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CiudadanoService {

    @Inject
    private CiudadanoRepositoryImpl ciudadanoRepositoryImpl;

    public void crear(Ciudadano ciudadano) {
        ciudadanoRepositoryImpl.persist(ciudadano);
    }

    public void crear(List<Ciudadano> ciudadanos) {
        ciudadanos.parallelStream().forEach(ciudadano -> ciudadanoRepositoryImpl.persist(ciudadano));
    }

    public void crearUrl(String url){
        try{


        Path path=Paths.get(url);
        List<String> ciudadanoString=Files.readAllLines(path);
        

        List<Ciudadano> ciudadanos=ciudadanoString.parallelStream().map(linea->{
            String[] datos=linea.split(",");
            Ciudadano ciudadano=new Ciudadano();
            ciudadano.setCedula(datos[0]);
            ciudadano.setNombre(datos[1]);
            ciudadano.setApellido(datos[2]);
            ciudadano.setGenero(datos[3]);
            return ciudadano;
        }).toList();

        crear(ciudadanos);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
