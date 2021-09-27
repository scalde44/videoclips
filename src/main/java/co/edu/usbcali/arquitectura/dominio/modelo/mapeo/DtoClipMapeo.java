package co.edu.usbcali.arquitectura.dominio.modelo.mapeo;

import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.repositorio.ClipEntityJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DtoClipMapeo {
    public static List<Clip> mapClip(List<DtoClip> dtoClips) {
        return dtoClips.stream()
                .map(dClip -> new Clip(dClip.getId(), dClip.getSubtitulos(), dClip.getUrl())).collect(Collectors.toList());
    }
}
