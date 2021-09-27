package co.edu.usbcali.arquitectura.aplicacion.consulta;

import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;
import co.edu.usbcali.arquitectura.dominio.puerto.dao.DaoClip;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarClipsGroseros {
    private final DaoClip daoClip;

    public ManejadorListarClipsGroseros(DaoClip daoClip) {
        this.daoClip = daoClip;
    }

    public List<DtoClip> ejecutar() {
        return this.daoClip.listarClipsPalabrasGroseras();
    }
}
