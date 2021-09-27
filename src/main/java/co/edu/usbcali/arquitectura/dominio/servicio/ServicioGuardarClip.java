package co.edu.usbcali.arquitectura.dominio.servicio;

import co.edu.usbcali.arquitectura.dominio.excepcion.ExcepcionCantidad;
import co.edu.usbcali.arquitectura.dominio.excepcion.ExcepcionDuplicidad;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.dominio.puerto.repositorio.RepositorioClip;

public class ServicioGuardarClip {
    private static final String EL_CLIP_YA_SE_ENCUENTRA_REGISTRADO = "Ya se encuentra un videoclip registrado con ese id";
    private static final String EL_CLIP_NO_CUMPLE_CON_LAS_PALABRAS = "El videoclip no cumple con las palabras minimas: %s";
    private static final int CANTIDAD_PALABRAS_MINIMAS_CLIP = 10;

    private final RepositorioClip repositorioClip;

    public ServicioGuardarClip(RepositorioClip repositorioClip) {
        this.repositorioClip = repositorioClip;
    }

    public Clip ejecutar(Clip clip) {
        validarExistencia(clip.getId());
        validarMinimoPalabras(clip.getSubtitulos());
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

    private void validarMinimoPalabras(String subtitulos) {
        String[] palabras = subtitulos.split(" ");
        int cantidad = palabras.length;
        if (cantidad < CANTIDAD_PALABRAS_MINIMAS_CLIP) {
            throw new ExcepcionCantidad(String.format(EL_CLIP_NO_CUMPLE_CON_LAS_PALABRAS, CANTIDAD_PALABRAS_MINIMAS_CLIP));
        }
    }
}
