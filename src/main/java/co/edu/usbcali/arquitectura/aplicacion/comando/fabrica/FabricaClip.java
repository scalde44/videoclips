package co.edu.usbcali.arquitectura.aplicacion.comando.fabrica;

import co.edu.usbcali.arquitectura.aplicacion.comando.ComandoClip;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import org.springframework.stereotype.Component;

@Component
public class FabricaClip {
    public Clip crear(ComandoClip comandoClip) {
        return new Clip(comandoClip.getId(), comandoClip.getSubtitulos(), comandoClip.getUrl());
    }
}
