package co.edu.usbcali.arquitectura.dominio.puerto.repositorio;

import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;

import java.util.List;

public interface RepositorioClip {

    /**
     * Permite eliminar tun clip
     *
     * @param idClip
     */
    void eliminar(Long idClip);

    /**
     * Permite eliminar todos los clips de la lista
     *
     * @param clips
     */
    void eliminarTodos(List<Clip> clips);

    /**
     * Permite guardar un clip
     *
     * @param clip
     * @return el clip guardado
     */
    Clip guardar(Clip clip);

    /**
     * Permite validar si existe un clip con ese id
     *
     * @param idClip
     * @return si existe o no
     */
    boolean existeClip(Long idClip);
}
