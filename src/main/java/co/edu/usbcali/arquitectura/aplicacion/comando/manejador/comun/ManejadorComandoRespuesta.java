package co.edu.usbcali.arquitectura.aplicacion.comando.manejador.comun;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoRespuesta<C, R> {
    @Transactional
    R ejecutar(C comando);
}
