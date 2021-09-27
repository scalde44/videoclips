package co.edu.usbcali.arquitectura.infraestructura.clip.adaptador.dao;

import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;
import co.edu.usbcali.arquitectura.infraestructura.clip.bd.springdata.repositorio.ClipEntityJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MapeoClip {
    public static List<DtoClip> mapDtoClip(List<ClipEntityJpaRepository.ClipOnly> clipsOnly) {
        return clipsOnly.stream()
                .map(clipOnly -> new DtoClip(clipOnly.getId(), clipOnly.getSubtitulos(), clipOnly.getUrl()))
                .collect(Collectors.toList());
    }
}
