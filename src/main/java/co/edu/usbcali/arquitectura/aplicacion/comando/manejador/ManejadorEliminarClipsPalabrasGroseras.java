package co.edu.usbcali.arquitectura.aplicacion.comando.manejador;

import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasGroseras;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarClipsPalabrasGroseras {
    private final ServicioEliminarClipsPalabrasGroseras servicioEliminarClipsPalabrasGroseras;

    public ManejadorEliminarClipsPalabrasGroseras(ServicioEliminarClipsPalabrasGroseras servicioEliminarClipsPalabrasGroseras) {
        this.servicioEliminarClipsPalabrasGroseras = servicioEliminarClipsPalabrasGroseras;
    }

    public void ejecutar() {
        this.servicioEliminarClipsPalabrasGroseras.ejecutar();
    }
}
