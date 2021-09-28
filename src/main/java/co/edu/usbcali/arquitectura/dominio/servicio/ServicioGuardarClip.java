package co.edu.usbcali.arquitectura.dominio.servicio;

import co.edu.usbcali.arquitectura.dominio.excepcion.ExcepcionCantidad;
import co.edu.usbcali.arquitectura.dominio.excepcion.ExcepcionDuplicidad;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.dominio.puerto.repositorio.RepositorioClip;

public class ServicioGuardarClip {
    private static final String EL_CLIP_YA_SE_ENCUENTRA_REGISTRADO = "Ya se encuentra un videoclip registrado con ese id";

    private final RepositorioClip repositorioClip;

    public ServicioGuardarClip(RepositorioClip repositorioClip) {
        this.repositorioClip = repositorioClip;
    }

    public Clip ejecutar(Clip clip) {
        validarExistencia(clip.getId());
        clip.validarMinimoPalabrasGuardarClip();
        return this.repositorioClip.guardar(clip);
    }

    private void validarExistencia(Long idClip) {
        if (idClip != null) {
            boolean existe = this.repositorioClip.existeClip(idClip);
            if (existe) {
                throw new ExcepcionDuplicidad(EL_CLIP_YA_SE_ENCUENTRA_REGISTRADO);
            }
        }
    }
}
