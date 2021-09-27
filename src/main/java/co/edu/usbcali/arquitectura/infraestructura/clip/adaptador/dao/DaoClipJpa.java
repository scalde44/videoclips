package co.edu.usbcali.arquitectura.infraestructura.clip.adaptador.dao;

import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.dominio.puerto.dao.DaoClip;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.mapeo.ClipEntityMapper;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.repositorio.ClipEntityJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DaoClipJpa implements DaoClip {
    private final ClipEntityJpaRepository clipEntityJpaRepository;
    private final ClipEntityMapper clipEntityMapper;

    public DaoClipJpa(ClipEntityJpaRepository clipEntityJpaRepository, ClipEntityMapper clipEntityMapper) {
        this.clipEntityJpaRepository = clipEntityJpaRepository;
        this.clipEntityMapper = clipEntityMapper;
    }

    @Override
    public List<DtoClip> listarClips() {
        return this.clipEntityMapper.toDtoClips(this.clipEntityJpaRepository.findAll());
    }

    @Override
    public List<DtoClip> listarClipsPalabrasMenorA(int cantidadPalabras) {
        return MapeoClip.mapDtoClip(this.clipEntityJpaRepository.buscarPorCantidadDePalabrasMenorA(cantidadPalabras));
    }

    @Override
    public List<DtoClip> listarClipsPalabrasMayorIgualA(int cantidadPalabras) {
        return MapeoClip.mapDtoClip(this.clipEntityJpaRepository.buscarPorCantidadDePalabrasMayorIgualA(cantidadPalabras));
    }

    @Override
    public List<DtoClip> listarClipsPalabrasGroseras() {
        List<DtoClip> dtoClips = this.clipEntityMapper.toDtoClips(this.clipEntityJpaRepository.findAll());
        return dtoClips.stream().filter(dtoC -> {
            Clip c = new Clip(dtoC.getId(), dtoC.getSubtitulos(), dtoC.getUrl());
            return c.contienePalabraGrosera();
        }).collect(Collectors.toList());
    }
}
