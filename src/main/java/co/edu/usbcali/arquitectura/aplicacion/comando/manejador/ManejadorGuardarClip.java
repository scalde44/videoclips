package co.edu.usbcali.arquitectura.aplicacion.comando.manejador;

import co.edu.usbcali.arquitectura.aplicacion.comando.ComandoClip;
import co.edu.usbcali.arquitectura.aplicacion.comando.fabrica.FabricaClip;
import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.comun.ManejadorComandoRespuesta;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioGuardarClip;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGuardarClip implements ManejadorComandoRespuesta<ComandoClip, Clip> {
    private final FabricaClip fabricaClip;
    private final ServicioGuardarClip servicioGuardarClip;

    public ManejadorGuardarClip(FabricaClip fabricaClip, ServicioGuardarClip servicioGuardarClip) {
        this.fabricaClip = fabricaClip;
        this.servicioGuardarClip = servicioGuardarClip;
    }

    @Override
    public Clip ejecutar(ComandoClip comandoClip) {
        Clip clip = this.fabricaClip.crear(comandoClip);
        return this.servicioGuardarClip.ejecutar(clip);
    }
}
