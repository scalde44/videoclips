package co.edu.usbcali.arquitectura.aplicacion.comando.manejador;

import co.edu.usbcali.arquitectura.aplicacion.comando.fabrica.FabricaListaClip;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasGroseras;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasMayorIgualA;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarClipsPalabrasGroseras {
    private final FabricaListaClip fabricaListaClip;
    private final ServicioEliminarClipsPalabrasGroseras servicioEliminarClipsPalabrasGroseras;

    public ManejadorEliminarClipsPalabrasGroseras(FabricaListaClip fabricaListaClip, ServicioEliminarClipsPalabrasGroseras servicioEliminarClipsPalabrasGroseras) {
        this.fabricaListaClip = fabricaListaClip;
        this.servicioEliminarClipsPalabrasGroseras = servicioEliminarClipsPalabrasGroseras;
    }

    public void ejecutar() {
        this.servicioEliminarClipsPalabrasGroseras.ejecutar();
    }
}
