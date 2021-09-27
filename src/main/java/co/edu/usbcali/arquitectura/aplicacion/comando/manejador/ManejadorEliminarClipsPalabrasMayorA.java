package co.edu.usbcali.arquitectura.aplicacion.comando.manejador;

import co.edu.usbcali.arquitectura.aplicacion.comando.fabrica.FabricaListaClip;
import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.comun.ManejadorComando;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasMayorIgualA;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasMenorA;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarClipsPalabrasMayorA implements ManejadorComando<Integer> {
    private final FabricaListaClip fabricaListaClip;
    private final ServicioEliminarClipsPalabrasMayorIgualA servicioEliminarClipsPalabrasMayorIgualA;

    public ManejadorEliminarClipsPalabrasMayorA(FabricaListaClip fabricaListaClip, ServicioEliminarClipsPalabrasMayorIgualA servicioEliminarClipsPalabrasMayorIgualA) {
        this.fabricaListaClip = fabricaListaClip;
        this.servicioEliminarClipsPalabrasMayorIgualA = servicioEliminarClipsPalabrasMayorIgualA;
    }

    @Override
    public void ejecutar(Integer comandoPalabras) {
        this.servicioEliminarClipsPalabrasMayorIgualA.ejecutar(comandoPalabras);
    }
}
