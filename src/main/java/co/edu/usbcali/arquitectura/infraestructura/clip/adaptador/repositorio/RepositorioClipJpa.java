package co.edu.usbcali.arquitectura.infraestructura.clip.adaptador.repositorio;

import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.dominio.puerto.repositorio.RepositorioClip;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.entidad.ClipEntity;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.mapeo.ClipEntityMapper;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.repositorio.ClipEntityJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioClipJpa implements RepositorioClip {
    private final ClipEntityJpaRepository clipEntityJpaRepository;
    private final ClipEntityMapper clipEntityMapper;

    public RepositorioClipJpa(ClipEntityJpaRepository clipEntityJpaRepository, ClipEntityMapper clipEntityMapper) {
        this.clipEntityJpaRepository = clipEntityJpaRepository;
        this.clipEntityMapper = clipEntityMapper;
    }

    @Override
    public void eliminar(Long idClip) {
        this.clipEntityJpaRepository.deleteById(idClip);
    }

    @Override
    public void eliminarTodos(List<Clip> clips) {
        this.clipEntityJpaRepository.deleteAll(this.clipEntityMapper.toClipEntities(clips));
    }

    @Override
    public Clip guardar(Clip clip) {
        ClipEntity clipEntity = this.clipEntityJpaRepository.save(this.clipEntityMapper.toClipEntity(clip));
        return this.clipEntityMapper.toClip(clipEntity);
    }

    @Override
    public boolean existeClip(Long idClip) {
        return this.clipEntityJpaRepository.existsById(idClip);
    }
}
