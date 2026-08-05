package ef2_pa2_jb.ec.edu.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import ef2_pa2_jb.ec.edu.domain.model.Ciudadano;
import ef2_pa2_jb.ec.edu.infrastructure.CiudadanoRepositoryImpl;
import io.smallrye.mutiny.Uni;
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

    public void crearLista(List<Ciudadano> personas) {
    personas.forEach(p -> this.ciudadanoRepositoryImpl.persist(p));
}

     public Uni<Void> crearURL(String url) {
        return Uni.createFrom().item(() -> {
            try {
                return Files.readAllLines(Paths.get(url));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        })
                .onItem().transform(lineas -> lineas.stream()
                .skip(1)
                .map(linea -> {
                    String[] datos = linea.split(",");
                    Ciudadano persona = new Ciudadano();
                    persona.setCedula(datos[0]);
                    persona.setNombre(datos[1]);
                    persona.setApellido(datos[2]);
                    persona.setGenero(datos[3]);
                    return persona;
                })
                .toList()
                ).invoke(this::crearLista)
               .replaceWithVoid();
    }
}
