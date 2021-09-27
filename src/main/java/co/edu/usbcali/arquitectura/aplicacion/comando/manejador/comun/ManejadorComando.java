package co.edu.usbcali.arquitectura.aplicacion.comando.manejador.comun;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {
    @Transactional
    void ejecutar(C comando);
}
