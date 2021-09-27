package co.edu.usbcali.arquitectura.aplicacion.consulta;

import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;
import co.edu.usbcali.arquitectura.dominio.puerto.dao.DaoClip;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarClipsPalabrasMenorA {
    private final DaoClip daoClip;

    public ManejadorListarClipsPalabrasMenorA(DaoClip daoClip) {
        this.daoClip = daoClip;
    }

    public List<DtoClip> ejecutar(int cantidadPalabras) {
        return this.daoClip.listarClipsPalabrasMenorA(cantidadPalabras);
    }
}
