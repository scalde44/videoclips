package co.edu.usbcali.arquitectura.aplicacion.comando.fabrica;

import co.edu.usbcali.arquitectura.aplicacion.comando.ComandoClip;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FabricaListaClip {
    public List<Clip> crear(List<ComandoClip> comandoClips) {
        return comandoClips.stream()
                .map(comClip -> new Clip(comClip.getId(), comClip.getSubtitulos(), comClip.getUrl()))
                .collect(Collectors.toList());
    }
}
