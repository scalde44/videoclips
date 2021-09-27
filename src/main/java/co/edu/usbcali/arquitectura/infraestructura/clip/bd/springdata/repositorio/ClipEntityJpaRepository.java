package co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.repositorio;

import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.entidad.ClipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClipEntityJpaRepository extends JpaRepository<ClipEntity, Long> {
    @Query(value = "SELECT cp.id, cp.subtitulos, cp.url FROM clip cp WHERE " +
            "(length(subtitulos)-length(replace(subtitulos,' ',''))+1)< :cantidad", nativeQuery = true)
    List<ClipOnly> buscarPorCantidadDePalabrasMenorA(int cantidad);

    @Query(value = "SELECT cp.id, cp.subtitulos, cp.url FROM clip cp WHERE " +
            "(length(subtitulos)-length(replace(subtitulos,' ',''))+1)>= :cantidad", nativeQuery = true)
    List<ClipOnly> buscarPorCantidadDePalabrasMayorIgualA(int cantidad);


    public static interface ClipOnly {

        Long getId();

        String getSubtitulos();

        String getUrl();

    }
}
