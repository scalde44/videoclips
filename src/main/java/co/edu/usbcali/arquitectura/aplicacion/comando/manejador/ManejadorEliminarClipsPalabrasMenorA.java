package co.edu.usbcali.arquitectura.aplicacion.comando.manejador;

import co.edu.usbcali.arquitectura.aplicacion.comando.fabrica.FabricaListaClip;
import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.comun.ManejadorComando;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasMenorA;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarClipsPalabrasMenorA implements ManejadorComando<Integer> {
    private final FabricaListaClip fabricaListaClip;
    private final ServicioEliminarClipsPalabrasMenorA servicioEliminarClipsTresPalabras;

    public ManejadorEliminarClipsPalabrasMenorA(FabricaListaClip fabricaListaClip, ServicioEliminarClipsPalabrasMenorA servicioEliminarClipsTresPalabras) {
        this.fabricaListaClip = fabricaListaClip;
        this.servicioEliminarClipsTresPalabras = servicioEliminarClipsTresPalabras;
    }


    @Override
    public void ejecutar(Integer comandoPalabras) {
        this.servicioEliminarClipsTresPalabras.ejecutar(comandoPalabras);
    }
}
