package co.edu.usbcali.arquitectura.aplicacion.comando.manejador;

import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.comun.ManejadorComando;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasMayorIgualA;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarClipsPalabrasMayorA implements ManejadorComando<Integer> {
    private final ServicioEliminarClipsPalabrasMayorIgualA servicioEliminarClipsPalabrasMayorIgualA;

    public ManejadorEliminarClipsPalabrasMayorA(ServicioEliminarClipsPalabrasMayorIgualA servicioEliminarClipsPalabrasMayorIgualA) {
        this.servicioEliminarClipsPalabrasMayorIgualA = servicioEliminarClipsPalabrasMayorIgualA;
    }

    @Override
    public void ejecutar(Integer comandoPalabras) {
        this.servicioEliminarClipsPalabrasMayorIgualA.ejecutar(comandoPalabras);
    }
}
