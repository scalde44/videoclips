package co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.mapeo;

import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.entidad.ClipEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClipEntityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "subtitulos", target = "subtitulos")
    @Mapping(source = "url", target = "url")
    Clip toClip(ClipEntity clipEntity);

    @InheritInverseConfiguration
    ClipEntity toClipEntity(Clip clip);

    List<ClipEntity> toClipEntities(List<Clip> clips);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "subtitulos", target = "subtitulos")
    @Mapping(source = "url", target = "url")
    DtoClip toDtoClip(ClipEntity clipEntity);

    List<DtoClip> toDtoClips(List<ClipEntity> clipEntities);
}
